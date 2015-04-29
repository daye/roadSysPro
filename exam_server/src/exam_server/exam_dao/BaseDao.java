package exam_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import exam_cst.dictionary_type;
import exam_cst.role_type;
import exam_entity.base.ExamBaseRole;
import exam_entity.base.ExamDictionary;
import exam_entity.rel.ExamRelRoleMenu;
import exam_entity.sys.ExamSysUser;
import exam_tools.EntityConverter;
import exam_tools.EntityHelper;
import exam_vo.base.ExamBaseRoleVo;
import exam_vo.base.ExamDictionaryVo;
import exam_vo.base.QryExamDictionaryVo;
import exam_vo.base.QueryExamBaseRoleVo;
import exam_vo.passwordChange.SavePassword;

public class BaseDao extends HibernateDaoSupport {


	public Map<Long, String> findUserNameMap() {
		String hql = "from ExamSysUser ";
		List<ExamSysUser> users = this.getHibernateTemplate().find(hql);
		Map<Long, String> map = new HashMap(users.size());
		for (ExamSysUser user : users) {
			map.put(user.getUser_id(), user.getUser_name());
		}
		return map;
	}

	public ExamBaseRoleVo[] findBaseRoleInfo(QueryExamBaseRoleVo queryVo){
		String hql = " from ExamBaseRole t where 1=1 ";
		
		
		if (StringUtils.isNotBlank(queryVo.getRole_name())) {
			hql += " and t.role_name like '%" + queryVo.getRole_name()+ "%'";
		}
		
		List list = this.getHibernateTemplate().find(hql);
		List voList = EntityConverter.getVo(list, ExamBaseRoleVo.class);
		if(voList.size() < 1)
			return new ExamBaseRoleVo[]{};
		ExamBaseRoleVo[] vos = new ExamBaseRoleVo[voList.size()];
		voList.toArray(vos);
		
		return vos;
	} 
	public boolean deleteRoleInfo(ExamBaseRoleVo vo){
		String hql = " from ExamRelRoleMenu t where 1=1 ";
		hql += " and t.role_id ="+vo.getRole_id();
		
		List list = this.getHibernateTemplate().find(hql);
		List entities = new ArrayList();
		for(int i = 0;i<list.size();i++)
		{
			ExamRelRoleMenu entityMenu = (ExamRelRoleMenu)list.get(i);
			entities.add(entityMenu);
		}
		ExamBaseRole entityRole = new ExamBaseRole();
		EntityHelper.copyProperties(vo, entityRole);
		entities.add(entityRole);
		this.getHibernateTemplate().deleteAll(entities);
		
		return true;
	}
	public Long updateRoleInfo(ExamBaseRoleVo vo){
		ExamBaseRole entity = new ExamBaseRole();
		if(vo.getRole_id()!=null)
		{
			EntityHelper.copyProperties(vo, entity);
			this.getHibernateTemplate().update(entity);
			return entity.getRole_id();
		}else{
			EntityHelper.copyProperties(vo, entity);
			this.getHibernateTemplate().save(entity);
			return entity.getRole_id();
		}
		
	}
	public Map<Long,String> getRoleMap() {
//		String hql = " from ExamBaseRole t";
//		List<ExamBaseRole> list = this.getHibernateTemplate().find(hql);
//		Map<Long, String> roleMap = new HashMap<Long, String>();
//		for(ExamBaseRole role:list)
//		{
//			roleMap.put(role.getRole_id(), role.getRole_name());
//		}
//		return roleMap;
		String hql = " from ExamBaseRole t";
		List<ExamBaseRole> list = this.getHibernateTemplate().find(hql);
		Map roleMap = new HashMap();
		for(ExamBaseRole role:list)
		{
			roleMap.put(role.getRole_id(), role.getRole_name());
		}
		return roleMap;
	}
	public Map<Long, String> findProjectManagerMap() {
		String hql = " from ExamSysUser t where t.role_id="+role_type.project_manager;
		List<ExamSysUser> list = this.getHibernateTemplate().find(hql);
		Map pmMap = new HashMap();
		for(ExamSysUser user:list)
		{
			pmMap.put(user.getUser_id(), user.getUser_name());
		}
		return pmMap;
		
	}
	
	public List findPmUser(Long project_id) {
		String hql = " select u.user_id from ExamSysUser u,ExamRelProjectUser rpu where 1=1 ";
		if(null!=project_id)
		{
			hql+=" and rpu.project_id= "+project_id;	   
			hql+=" and u.user_id = rpu.user_id";
		}
		List<ExamSysUser> users = this.getHibernateTemplate().find(hql);
		return users;
	}
	public Map getDeparUserMap(Long depart_id){
		String hql = " from ExamSysUser t where 1=1";
		//0L表示没有选择部门
		if(depart_id!=0L)
		{
			 hql+= " and t.department_id="+depart_id;
		}
		List<ExamSysUser> list = this.getHibernateTemplate().find(hql);
		Map departUserMap = new HashMap();
		for(ExamSysUser user:list)
		{
			departUserMap.put(user.getUser_id(), user.getUser_code()+"--"+user.getUser_name());
		}
		return departUserMap;
	}
	
	
	//获取字典
	public ExamDictionaryVo[] findExamDictionaryInfos(
			QryExamDictionaryVo qryVo) {
		String hql = "from ExamDictionary where 1=1 ";
		if (StringUtils.isNotBlank(qryVo.getDcname())) {
			hql += " and dcname like '%" + qryVo.getDcname() + "%' ";
		}
		if (StringUtils.isNotBlank(qryVo.getDctype())) {
			hql += " and dctype ='" +qryVo.getDctype()+ "'";
		}
		List<ExamDictionary> list = this.getHibernateTemplate().find(hql+" order by dcid desc ");
		int sum = list.size();
		ExamDictionaryVo[] rs = new ExamDictionaryVo[sum];
		Map dictionaryMap = dictionary_type.dictionaryTypeMap;
		
		for (int i = 0; i < sum; i++) {
			ExamDictionaryVo tmpVo = new ExamDictionaryVo();
			BeanUtils.copyProperties(list.get(i), tmpVo);
			tmpVo.setDctype_name(dictionaryMap.get(tmpVo.getDctype())==null?"":dictionaryMap.get(tmpVo.getDctype()).toString());
			rs[i] = tmpVo;
		}
		
		return rs;
	}
	public Integer saveOrUpdateExamDictionary(ExamDictionaryVo vo) {
		 ExamDictionary entity = new ExamDictionary();
		 EntityHelper.copyProperties(vo, entity);
		 this.getHibernateTemplate().saveOrUpdate(entity);
		 return entity.getDcid();
	}
	
	public boolean deleteExamDictionary(ExamDictionaryVo vo) {
		 ExamDictionary entity = new ExamDictionary();
		 EntityHelper.copyProperties(vo, entity);
		 this.getHibernateTemplate().delete(entity);
		 return true;
	}
	public Map getdictionaryMap() {
		
		Map map = dictionary_type.dictionaryTypeMap;
		Map dictionarymap = new TreeMap();
		Set entries = map.entrySet( );
		if(entries != null) 
		{ 
			 Iterator iterator = entries.iterator();
			  while(iterator.hasNext( )) {
				    Map.Entry entry =(Entry) iterator.next( );
				    Object key = entry.getKey( );
				    
				    String hql = "from ExamDictionary where dctype='"+key.toString()+"'";
					List<ExamDictionary> dcs = this.getHibernateTemplate().find(hql);
					if(dcs.size()>0)
					{
						Map dcMap = new TreeMap();
						for (ExamDictionary dc : dcs) {
							dcMap.put(dc.getDcCode(), dc.getDcName());
							
							dictionarymap.put(key.toString(), dcMap);
						}
						
					}
					
				
			  }
		} 
		return dictionarymap;
	}
	public List findExamDictionaryByDcCode(ExamDictionaryVo vo) {
		 String hql = "from ExamDictionary where 1=1 and dcid!="+vo.getDcid()+" and dcCode='"+vo.getDcCode()+"' and dctype='"+vo.getDctype()+"'";
		 return  this.getHibernateTemplate().find(hql);
	}
	public int passwordModify(SavePassword vo){
		
		Object[] obj=new Object[]{vo.getNewpassword(),vo.getUser_code()};
		return getHibernateTemplate().bulkUpdate("update from ExamSysUser set password=? where user_code=?", obj);
	}
	
}
