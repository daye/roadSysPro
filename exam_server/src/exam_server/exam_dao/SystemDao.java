package exam_dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import exam_entity.sys.ExamSysMenu;
import exam_entity.sys.ExamSysUser;
import exam_tools.EntityHelper;
import exam_vo.system.ExamSysUserVo;
import exam_vo.system.QueryExamSysUserVo;

public class SystemDao extends HibernateDaoSupport {
	public Map<Long,ExamSysMenu> getAllMenuMap(){
		String hql = "from ExamSysMenu ";
		List<ExamSysMenu> list = this.getHibernateTemplate().find(hql);
		Map<Long,ExamSysMenu> rs = new HashMap(list.size());
		for(ExamSysMenu menu : list){
			rs.put(menu.getMenu_id(), menu);
		}
		return rs;
	}

	public boolean delExamSysUserInfo(ExamSysUserVo vo) {
		ExamSysUser entity = new ExamSysUser();
		EntityHelper.copyProperties(vo, entity);
		this.getHibernateTemplate().delete(entity);
		return true;
		
	}

	public List findExamSysUserInfo(QueryExamSysUserVo vo) {
		String hql = " from ExamSysUser t where 1=1 ";
		
		if (StringUtils.isNotBlank(vo.getUser_name())) {
			hql += " and t.user_name like '%" + vo.getUser_name()+ "%'";
		}
		if(vo.getDepartment_id()!=null)
		{
			hql+=" and t.department_id ="+vo.getDepartment_id();
		}
		if(vo.getRole_id()!=null)
		{
			hql+=" and t.role_id="+vo.getRole_id();
		}
//		if(vo.getStatus()!=null)
//		{
//			hql+=" and t.status="+vo.getStatus();
//		}
		if(StringUtils.isNotBlank(vo.getUsercode()))
		{
			hql+=" and t.user_code='"+vo.getUsercode()+"'";
		}
		
		List list = this.getHibernateTemplate().find(hql);

		return list;
	}

	public Long updateExamSysUserInfo(ExamSysUserVo vo) {
		ExamSysUser entity = null;
		if(vo.getUser_id()!=null)
		{
			entity = (ExamSysUser)this.getHibernateTemplate().get(ExamSysUser.class, vo.getUser_id());
			
		}
		if(vo.getUser_id() == null)
		{
			entity = new ExamSysUser();
		}
		BeanUtils.copyProperties(vo, entity);
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity.getUser_id();
	}
    public List findExamSysUserList(String userCode){
		
		String hql = " from ExamSysUser t where 1=1 ";
		hql+=" and t.user_code='"+userCode+"'";
		List list = getHibernateTemplate().find(hql);
		return list;
	}
}
