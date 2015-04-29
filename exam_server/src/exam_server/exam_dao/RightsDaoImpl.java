package exam_dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import exam_cst.has_rights;
import exam_vo.rights.ColumnVo;
import exam_vo.rights.HasRightsVo;
import exam_vo.rights.RelationVo;
import exam_vo.rights.RowVo;
import exam_vo.rights.SysRightsManage;

@SuppressWarnings("unchecked")
public class RightsDaoImpl implements RightsDao {
	private JdbcTemplate jt = null;

	public void setDataSource(DataSource ds) {
		if (ds != null) {
			jt = new JdbcTemplate(ds);
		}
	}

	public ColumnVo[] findColumnEntity(SysRightsManage manage) {
		try {
			List<Map<String, Object>> list = jt.queryForList("select "
					+ manage.getColumnpk() + "," + manage.getColumnvalue()
					+ " from " + manage.getColumntable());
			List<ColumnVo> rs = new LinkedList<ColumnVo>();
			for (Map<String, Object> map : list) {
				ColumnVo vo = new ColumnVo();
				vo.setColumn_id(map.get(manage.getColumnpk()) + "");
				vo.setColumn_name(map.get(manage.getColumnvalue()) + "");
				rs.add(vo);
			}
			ColumnVo[] cv = new ColumnVo[rs.size()];
			return rs.toArray(cv);
		} catch (Exception e) {
			e.printStackTrace();
			return new ColumnVo[0];
		}
	}

	private String getRightsViewSql(SysRightsManage manage) {
		return " select t." + manage.getRowpk() + ", t." + manage.getRowvalue()
				+ ", t." + manage.getRowparentid() + ", t."
				+ manage.getColumnpk() + ",'10' as has_rights "
				+ " from (select m." + manage.getRowpk() + ", m."
				+ manage.getRowvalue() + ", m." + manage.getRowparentid()
				+ ", o." + manage.getColumnpk() + " from "
				+ manage.getColumntable() + " o, " + manage.getRowtable()
				+ " m) t " + " join " + manage.getRelationtable() + " t2 "
				+ " on (t." + manage.getColumnpk() + " = t2."
				+ manage.getColumnpk() + " and t." + manage.getRowpk()
				+ " = t2." + manage.getRowpk() + ") " + " union all "
				+ " select t." + manage.getRowpk() + ", t."
				+ manage.getRowvalue() + ", t." + manage.getRowparentid()
				+ ", t." + manage.getColumnpk() + ",'11' as has_rights "
				+ " from (select m." + manage.getRowpk() + ", m."
				+ manage.getRowvalue() + ", m." + manage.getRowparentid()
				+ ", o." + manage.getColumnpk() + " from "
				+ manage.getColumntable() + " o, " + manage.getRowtable()
				+ " m) t " + " left join " + manage.getRelationtable() + " t2 "
				+ " on (t." + manage.getColumnpk() + " = t2."
				+ manage.getColumnpk() + " and t." + manage.getRowpk()
				+ " = t2." + manage.getRowpk() + ") " + " where t2."
				+ manage.getRowpk() + " is null ";
	}

	public RowVo[] findAllMenuInfo(SysRightsManage manage) {
		/**
		 * (1)查询出所有菜单权限信息（并将菜单权限信息放置于一个MAP中）
		 */
		List<Map<String, Object>> temp = jt.queryForList("select * from ("
				+ this.getRightsViewSql(manage) + ")n");/////////////////ccc
		List<HasRightsVo> mpList = new LinkedList<HasRightsVo>();
		for (Map<String, Object> map : temp) {
			HasRightsVo vo = new HasRightsVo();
			vo.setColumnpk(map.get(manage.getColumnpk()) + "");
			vo.setHas_rights(map.get("has_rights") + "");
			vo.setRowparentid(map.get(manage.getRowparentid()) + "");
			vo.setRowpk(map.get(manage.getRowpk()) + "");
			vo.setRowview(map.get(manage.getRowvalue()) + "");
			mpList.add(vo);
		}
		HasRightsVo[] mpVos = new HasRightsVo[mpList.size()];
		mpList.toArray(mpVos);
		Map<String, Map<String, Boolean>> menu_role_map = new HashMap<String, Map<String, Boolean>>();
		for (int i = 0; i < mpVos.length; i++) {
			if (null == menu_role_map.get(mpVos[i].getRowpk())) {
				Map tempMap = new HashMap();
				tempMap.put(mpVos[i].getColumnpk() + "", has_rights.rights_map
						.get(mpVos[i].getHas_rights()));
				menu_role_map.put(mpVos[i].getRowpk(), tempMap);
			} else {
				Map tempMap = menu_role_map.get(mpVos[i].getRowpk());
				tempMap.put(mpVos[i].getColumnpk() + "", has_rights.rights_map
						.get(mpVos[i].getHas_rights()));
				menu_role_map.put(mpVos[i].getRowpk(), tempMap);
			}
		}
		/**
		 * (2)返回MenuInfoVo数组
		 */
		List<Map<String, Object>> miList = jt.queryForList("select "
				+ manage.getRowpk() + "," + manage.getRowvalue() + ","
				+ manage.getRowparentid() + " from " + manage.getRowtable());
		int sum = miList.size();
		List<RowVo> temp1 = new ArrayList(sum);
		for (Map<String, Object> map : miList) {
			RowVo vo = new RowVo();
			vo.setRowpk(map.get(manage.getRowpk()) + "");
			vo.setRowvalue(map.get(manage.getRowvalue()) + "");
			vo.setParentid(map.get(manage.getRowparentid()) + "");
			vo.setMenu_role_map(menu_role_map.get(vo.getRowpk()));
			temp1.add(vo);
		}
		RowVo[] rs = new RowVo[sum];
		return temp1.toArray(rs);
	}

	public void saveRightsInfo(RowVo[] rows, SysRightsManage manage)
			throws Exception {
		Connection conn = jt.getDataSource().getConnection();
		try {
			
			conn.setAutoCommit(false);
			ColumnVo[] cols = this.findColumnEntity(manage);
			final String relationtable = manage.getRelationtable();
			jt.execute("delete from " + manage.getRelationtable());
			final List<String[]> batch = new LinkedList<String[]>();

			for (int i = 0; i < rows.length; i++) {// 循环所有的菜单
				Map menu_role_map = rows[i].getMenu_role_map();

				for (int j = 0; j < cols.length
						&& null != menu_role_map.get(cols[j].getColumn_id()
								+ ""); j++) {// 循环所有角色
					if ((Boolean) menu_role_map
							.get(cols[j].getColumn_id() + "")) {// 满足条件新增
						batch.add(new String[] { cols[j].getColumn_id(),
								rows[i].getRowpk() });
					}
				}
			}
			String sql = " INSERT INTO " + relationtable//+"(role_menu_id,role_id,menu_id)"
					+ " VALUES (?,? ,?) ";
			jt.batchUpdate(sql, new BatchPreparedStatementSetter() {
				public int getBatchSize() {
					return batch.size();
				}

				public void setValues(PreparedStatement ps, int i)
						throws SQLException {
//					String seq = "select " + relationtable
//							+ "_seq.nextval from dual";
					ps.setObject(1, i+1);
					System.out.println(i+"*******************************");
					ps.setObject(2, Long.parseLong(batch.get(i)[0]));
					System.out.println(batch.get(i)[0]+"++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println(batch.get(i)[1]+"++++++++++++++++++++++++++++++++++++++++++++");
					ps.setObject(3, Long.parseLong(batch.get(i)[1]));
					
				}
			});
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new Exception("保存权限错误！");
		}

	}

	public SysRightsManage findRightManageInfo(Integer manage_id) {
		try {
			String sql = " SELECT  * FROM SYS_RIGHTS_MANAGE WHERE MANAGEMENTID = "
					+ manage_id;
			List<Map<String, Object>> list = jt.queryForList(sql);
			Map<String, Object> vm = list.get(0);
			SysRightsManage manage = new SysRightsManage();
			for (Field field : manage.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value = vm.get(field.getName());
				if (value.getClass() == BigDecimal.class) {
					Class target = field.getType();
					if (target == Integer.class) {
						value = Integer.parseInt(value + "");
					} else if (target == Long.class) {
						value = Long.parseLong(value + "");
					} else if (target == Double.class) {
						value = Double.parseDouble(value + "");
					}
				}
				field.set(manage, value);
			}
			return manage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map getRights(Integer manage_id, String column_id) {
		SysRightsManage manage = findRightManageInfo(manage_id);
		String sql = " SELECT a.*,b." + manage.getRowparentid() + " FROM "
				+ manage.getRelationtable() + " a " + "join "
				+ manage.getRowtable() + " b on a." + manage.getRowpk() + "=b."
				+ manage.getRowpk() + " WHERE " + manage.getColumnpk() + " = '"
				+ column_id + "'";
				//+ 1 + "'";///////所有人员都看到全部菜单 就像管理员权限.
		List<Map<String, Object>> list = jt.queryForList(sql);
		List<RelationVo> rels = new ArrayList<RelationVo>(list.size());
		for (Map<String, Object> map : list) {
			RelationVo vo = new RelationVo();
			vo.setColumn_id(map.get(manage.getColumnpk()) + "");
			vo.setRow_id(map.get(manage.getRowpk()) + "");
			vo.setRow_parent_id(map.get(manage.getRowparentid()) + "");
			rels.add(vo);
		}
		Map<String, Map> rs = new HashMap<String, Map>();
		rs.put(getRootVo(rels).getRow_id(), new HashMap());
		initTreeNode(getRootVo(rels).getRow_id(), rs, rels);
		return rs;
	}

	private void initTreeNode(String current_id, Map<String, Map> current_map,
			List<RelationVo> rels){
		Map children = current_map.get(current_id);
		for (RelationVo vo : rels) {
			if (vo.getRow_parent_id().equals(current_id)) {
				String child_row_id = vo.getRow_id();
				if(isLeaf(child_row_id, rels)){
					children.put(child_row_id, null);
				}else{
					children.put(child_row_id, new HashMap());
					initTreeNode(child_row_id,children,rels);
				}
			}
		}
	}

	private boolean isLeaf(String row_id, List<RelationVo> list) {
		boolean is_leaf = true;
		for (RelationVo vo : list) {
			if (vo.getRow_parent_id().equals(row_id)) {
				is_leaf = false;
				break;
			}
		}
		return is_leaf;
	}

	private RelationVo getRootVo(List<RelationVo> list) {
		for (RelationVo vo : list) {
			boolean flag = true;
			for (RelationVo vo2 : list) {
				if (vo2.getRow_id().equals(vo.getRow_parent_id())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return vo;
			}
		}
		return new RelationVo();
	}
}
