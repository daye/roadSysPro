package exam_service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import exam_cst.PageArg;
import exam_factory.impl.DaoFactory;
import exam_service.IBaseService;
import exam_tools.EntityConverter;
import exam_vo.base.ExamBaseRoleVo;
import exam_vo.base.ExamDictionaryVo;
import exam_vo.base.QryExamDictionaryVo;
import exam_vo.base.QueryExamBaseRoleVo;
import exam_vo.passwordChange.SavePassword;

public class BaseServiceImpl implements IBaseService {

	public ExamBaseRoleVo[] queryBaseRoleInfo(QueryExamBaseRoleVo queryVo,PageArg arg) {
		StringBuffer sb = new StringBuffer();
		String hql = " from ExamBaseRole t where 1=1 ";
		String count = " select count(r.role_id) from ExamBaseRole r where 1=1";
		if(StringUtils.isNotBlank(queryVo.getRole_name())){
			sb.append(" and t.role_name like '%"+queryVo.getRole_name()+"%'");
		}
		arg.recordCount = ((Long)DaoFactory.getBaseDao().getHibernateTemplate().find(count+sb.toString()).get(0)).intValue();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory(); 
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction(); 
		
		List list = session.createSQLQuery(hql).setFirstResult((arg.pageIndex-1)*arg.rowsPerPage).setMaxResults(arg.rowsPerPage).list();
		//tx.commit(); 
		session.close();

//		List list = DaoFactory.getBaseDao().findBaseRoleInfo(queryVo);
		List voList = EntityConverter.getVo(list, ExamBaseRoleVo.class);
		if(voList.size() < 1)
			return new ExamBaseRoleVo[]{};
		ExamBaseRoleVo[] vos = new ExamBaseRoleVo[voList.size()];
		voList.toArray(vos);
		return vos;
	}
	public ExamBaseRoleVo[] queryBaseRoleInfo(QueryExamBaseRoleVo queryVo) {
		
		return DaoFactory.getBaseDao().findBaseRoleInfo(queryVo);
	}
	public boolean deleteRoleInfo(ExamBaseRoleVo vo) {
		return DaoFactory.getBaseDao().deleteRoleInfo(vo);
	}

	public Long updateRoleInfo(ExamBaseRoleVo vo) {
		return DaoFactory.getBaseDao().updateRoleInfo(vo);
	}


	public Map<Long,String> getRoleMap() {
		return DaoFactory.getBaseDao().getRoleMap();
	}
	public Map<Long, String> findUserNameMap() {
		return DaoFactory.getBaseDao().findUserNameMap();
	}


	public boolean deleteExamDictionary(ExamDictionaryVo vo) {
		
		return DaoFactory.getBaseDao().deleteExamDictionary(vo);
	}
	public ExamDictionaryVo[] findExamDictionaryInfos(
			QryExamDictionaryVo qryVo) {
		
		return DaoFactory.getBaseDao().findExamDictionaryInfos(qryVo);
	}
	public Integer saveOrUpdateExamDictionary(ExamDictionaryVo vo) {
		
		return DaoFactory.getBaseDao().saveOrUpdateExamDictionary(vo);
	}
	public Map getdictionaryMap() {
		return DaoFactory.getBaseDao().getdictionaryMap();
	}
	public List findExamDictionaryByDcCode(ExamDictionaryVo vo) {
		return DaoFactory.getBaseDao().findExamDictionaryByDcCode(vo);
	}
	
	public int passwordModify(SavePassword vo) {
		return DaoFactory.getBaseDao().passwordModify(vo);
	}
}
