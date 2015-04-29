package exam_dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import saptac.core.BaseDaoHibernate;
import exam_entity.backstage.AnswerQtRel;
import exam_entity.backstage.QuestionStore;
import exam_tools.EntityHelper;
import exam_vo.backstage.AnswerQtRelVo;
import exam_vo.backstage.QryAnswerQtRelVo;
import exam_vo.backstage.QryExamPaperManagerVo;
import exam_vo.backstage.QryQuestionStoreVo;
import exam_vo.backstage.QuestionStoreVo;

public class BackstageDao extends BaseDaoHibernate{

	public List findQuestionStoreInfo(QryQuestionStoreVo vo) {
		String hql = " from QuestionStore t where 1=1 ";
		
		if (StringUtils.isNotBlank(vo.getQtname())) {
			hql += " and t.qtname like '%" + vo.getQtname()+ "%'";
		}
		if(StringUtils.isNotBlank(vo.getQtsubject()))
		{
			hql+=" and t.qtsubject ='"+vo.getQtsubject()+"'";
		}
		if(StringUtils.isNotBlank(vo.getQttype()))
		{
			hql+=" and t.qttype='"+vo.getQttype()+"'";
		}
		
		List<QuestionStore> list = this.find(hql);

		return list;
	}
	
	public boolean delQuestionStoreInfo(QuestionStoreVo vo) {
		QuestionStore entity = new QuestionStore();
		EntityHelper.copyProperties(vo, entity);
		this.delete(entity);
		return true;
		
	}
	public void saveOrupdateQuestionStoreInfo(QuestionStoreVo vo) {
		QuestionStore entity = null;
		if(vo.getQtno()!=null)
		{
			entity = (QuestionStore)this.get(QuestionStore.class, vo.getQtno());
			
		}
		if(vo.getQtno() == null)
		{
			entity = new QuestionStore();
		}
		BeanUtils.copyProperties(vo, entity);
		this.saveOrUpdate(entity);
	}
	
	
	public List findAnswerQtRelInfo(QryAnswerQtRelVo vo) {
		String sql = " select t.asid,t.qtno,t.asno,t.asname,t.asstatus,b.qtname,b.qtsubject,b.qttype from answer_qt_rel t LEFT JOIN question_store b ON t.qtno=b.qtno where 1=1 ";
		
		if (StringUtils.isNotBlank(vo.getQtno())) {
			sql += " and t.qtno ='" + vo.getQtno()+ "'";
		}
		if(StringUtils.isNotBlank(vo.getQtsubject()))
		{
			sql+=" and b.qtsubject ='"+vo.getQtsubject()+"'";
		}
		if(StringUtils.isNotBlank(vo.getQttype()))
		{
			sql+=" and b.qttype='"+vo.getQttype()+"'";
		}
		List list = this.findBySql(sql);

		return list;
	}
	public List findExamPaperManagerInfo(QryExamPaperManagerVo vo) {
		String hql = " select b.paperno,b.papername,b.qtsubject,b.qtno,a.qtname "
				+ "from exam_paper_manager b,question_store a where 1=1  and b.qtno=a.qtno";
		
		if(StringUtils.isNotBlank(vo.getQtsubject()))
		{
			hql+=" and b.qtsubject ='"+vo.getQtsubject()+"'";
		}
		if(StringUtils.isNotBlank(vo.getPapername()))
		{
			hql+=" and b.papername='"+vo.getPapername()+"'";
		}
		List list = this.find(hql);

		return list;
	}
	public boolean delAnswerQtRelInfo(AnswerQtRelVo vo) {
		AnswerQtRel entity = new AnswerQtRel();
		EntityHelper.copyProperties(vo, entity);
		this.delete(entity);
		return true;
		
	}
	public void saveOrupdateAnswerQtRelInfo(AnswerQtRelVo vo) {
		AnswerQtRel entity = null;
		if(vo.getAsid()!=null)
		{
			entity = (AnswerQtRel)this.get(AnswerQtRel.class, vo.getAsid());
			
		}
		if(vo.getAsid() == null)
		{
			entity = new AnswerQtRel();
		}
		BeanUtils.copyProperties(vo, entity);
		this.saveOrUpdate(entity);
	}
	
	public Map findQuestionMap(String qtsubject, String qttype){
		String hql = " from QuestionStore qt where 1=1 ";
		hql+=" and qt.qtsubject= '"+qtsubject+"'";	
		hql+=" and qt.qttype='"+qttype+"'";
		
		List<QuestionStore> list = find(hql);
		Map qtstoretMap = new HashMap();
		for(QuestionStore qtstore:list)
		{
			qtstoretMap.put(qtstore.getQtno(),qtstore.getQtname());
		}
		return qtstoretMap;
		
	}
	public Map findQuestionMapAll(){
		String hql = " from QuestionStore qt where 1=1 ";
		
		List<QuestionStore> list = find(hql);
		Map qtstoretMap = new HashMap();
		for(QuestionStore qtstore:list)
		{
			qtstoretMap.put(qtstore.getQtno(),qtstore.getQtname());
		}
		return qtstoretMap;
		
	}
	public List findIsExsistAnswerQtRelInfos(Integer qtno,String asstatus,Integer asid) {
		String hql = " from AnswerQtRel t where 1=1 ";
		
		if (qtno!=null) {
			hql += " and t.qtno=" + qtno;
		}
		if(StringUtils.isNotBlank(asstatus))
		{
			hql+=" and t.asstatus ='1'";
		}
		hql+=" and t.asid!="+asid;
		
		List<QuestionStore> list = this.find(hql);

		return list;
	} 
	
	public List findIsExsistAnswerQtRelInfos(Integer qtno,Integer asno,Integer asid) {
		String hql = " from AnswerQtRel t where 1=1 ";
		
		if (qtno!=null) {
			hql += " and t.qtno=" + qtno;
		}
		if (asno!=null) {
			hql += " and t.asno=" + asno;
		}
		hql+=" and t.asid!="+asid;
		List<QuestionStore> list = this.find(hql);

		return list;
	} 
}
