package exam_dao;

import java.util.Map;

import exam_vo.rights.ColumnVo;
import exam_vo.rights.RowVo;
import exam_vo.rights.SysRightsManage;
@SuppressWarnings("unchecked")
public interface RightsDao {
	
	/**
	 * 查询所有列的信息
	 * @param table_name
	 * @param entity_name
	 * @return
	 */
	public ColumnVo[] findColumnEntity(SysRightsManage manage);
	
	/**
	 * 查询所有行的信息
	 * @return
	 */
	public RowVo[] findAllMenuInfo(SysRightsManage manage);
	
	/**
	 * 保存权限信息
	 * @param rows
	 */
	public void saveRightsInfo(RowVo[] rows,SysRightsManage manage) throws Exception;
	
	/**
	 * 查询此TreeTable的信息
	 * @param manage_id
	 * @return
	 */
	public SysRightsManage findRightManageInfo(Integer manage_id);
	
	/**
	 * 查询指定权限管理PANEL的指定列的所有ROW的权限
	 * 返回MAP套MAP (key - parent_id  value - List<child_id>)
	 * @param manage_id
	 * @param column_id
	 * @return
	 */
	public Map getRights(Integer manage_id,String column_id);
}
