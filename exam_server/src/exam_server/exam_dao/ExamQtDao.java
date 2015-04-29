package exam_dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import saptac.core.BaseDaoHibernate;
import exam_entity.backstage.AnswerQtRel;
import exam_entity.backstage.ExamineeQtRel;
import exam_entity.backstage.QuestionStore;
import exam_vo.exam.ExamSetVo;
import exam_vo.examinee.ExamStatisVo;
import exam_vo.examinee.ExamineeQtRelVo;
import exam_vo.examinee.QryExamineeQtRelVo;
import exam_vo.examinee.StandardAnswerVo;

public class ExamQtDao extends BaseDaoHibernate{


	public List getAllQuestions(String qtsubject,String qttype) {
		String sql = " SELECT qtno FROM question_store where 1=1  ";
		if(StringUtils.isNotBlank(qtsubject))
		{
			sql += " and qtsubject='"+qtsubject+"'";
		}
		if(StringUtils.isNotBlank(qttype))
		{
			sql += " and qttype='"+qttype+"'";
		}
		List list = findBySql(sql);
		return list;
		
	}
	
	public List findQuestionStoreInfos() {
		String hql = " SELECT t.qtno,t.qtname,t.qttype,t.qtgrade from QuestionStore t where 1=1 ";
		
		List<QuestionStore> list = this.find(hql);

		return list;
	}
	
	public List findAnswerQtRelInfos(Integer qtno) {
		String hql = " SELECT t.asno,t.asname from AnswerQtRel t where 1=1 ";
		hql += " and t.qtno="+qtno;
		List<AnswerQtRel> list = this.find(hql);
		return list;
	}
	public int findCountQtInfos(ExamSetVo vo){
		
		String sql = " SELECT COUNT(*) FROM question_store where 1=1 ";
		if(StringUtils.isNotBlank(vo.getQtsubject()))
		{
			sql += " and qtsubject ='"+vo.getQtsubject()+"'";
		}
		if(StringUtils.isNotBlank(vo.getQttype()))
		{
			sql += " and qttype='"+vo.getQttype()+"'";
		}
		int qtcount = findCountBySql(sql);
		return qtcount;
	}
	//GROUP_CONCAT(DISTINCT b.asno ORDER BY b.asid ) 生成1,2,3这样的数据 
	public List<StandardAnswerVo> fidRightAnsersInfo(String qtno) {
		String sql = "SELECT a.qtno,GROUP_CONCAT(DISTINCT b.asno ORDER BY b.asid ) AS asno,a.qtgrade "+ 
					 " FROM question_store a,answer_qt_rel b "
					+" WHERE a.qtno=b.qtno  AND b.asstatus='1' and a.qtno='"+Integer.parseInt(qtno)+"'"+
                     " GROUP BY a.qtno";
		List<StandardAnswerVo> list = this.findBySql(sql);
		
		return list;
	} 
	
	public int findCountPaperByUserCode(String usercode)
	{
		String sql = "SELECT COUNT(*) FROM ( "+
					 " SELECT DISTINCT papercode,usercode FROM examinee_qt_rel WHERE usercode='"+usercode+"')a";
		int cnt = findCountBySql(sql);
		return cnt;
	}
	
	public void saveExamineeQtRelInfo(ExamineeQtRelVo vo){
		ExamineeQtRel entity = new ExamineeQtRel();
		BeanUtils.copyProperties(vo, entity);
		this.save(entity);
	}
	
	public List findExamineeQtRelInfo(QryExamineeQtRelVo vo) {
		String wheresql = "";
		if (StringUtils.isNotBlank(vo.getUsercode())) {
			wheresql += " and m.usercode ='" + vo.getUsercode()+ "'";
		}
		if(StringUtils.isNotBlank(vo.getPapercode()))
		{
			wheresql+=" and m.papercode ='"+vo.getPapercode()+"'";
		}
		//查询试卷信息sql 包含试卷名称 考生名称 试题名称 答案以及得分
		String sql = " SELECT m.papercode,m.usercode,m.user_name,m.qtno,m.qtname,m.qtanswer,m.qtgrade,m.qtstatus,n.asno,n.rigtasname FROM ( "+
					 " SELECT a.papercode,a.usercode,b.user_name,a.qtno,c.qtname,a.qtanswer,a.qtgrade,a.qtstatus  "+
					 " FROM examinee_qt_rel a  "+
					 " JOIN exam_sys_user b ON a.usercode=b.user_code   "+
					 " JOIN question_store c ON a.qtno=c.qtno "+
					 " LEFT JOIN answer_qt_rel d ON a.qtno=d.qtno AND a.qtanswer=d.asno "+
					 " ORDER BY a.reid)m "+
					 " LEFT JOIN ( "+
					 " SELECT a.qtno,GROUP_CONCAT(DISTINCT b.asno ORDER BY b.asid ) AS asno,GROUP_CONCAT(b.asname ORDER BY b.asid) AS rigtasname "+
					 " FROM question_store a,answer_qt_rel b WHERE a.qtno=b.qtno  AND b.asstatus='1' "+
					 " GROUP BY a.qtno"+
					 " )n ON n.qtno=m.qtno where 1=1 "+wheresql+
					 " ORDER BY m.papercode  ";
		
		
		
		List list = this.findBySql(sql);

		return list;
	}
	public List<ExamStatisVo> findExamStatisVo(QryExamineeQtRelVo vo){
		String sql = "SELECT a.rights_as,b.wrong_as,a.qtgrade FROM ( "+
					 " SELECT papercode,usercode,COUNT(*) AS rights_as,SUM(qtgrade) AS qtgrade "+
					 " FROM examinee_qt_rel WHERE  qtstatus='1' AND papercode='"+vo.getPapercode()+"' AND usercode='"+vo.getUsercode()+"' "+
					 " ) a LEFT JOIN ( "+
					 " SELECT papercode,usercode,COUNT(*)  AS wrong_as "+
					 " FROM examinee_qt_rel WHERE  qtstatus='2' AND papercode='"+vo.getPapercode()+"' AND usercode='"+vo.getUsercode()+"' "+
					 " ) b ON a.papercode = b.papercode AND a.usercode=b.usercode ";
		
		List list = this.findBySql(sql);
		return list;
	}
	
	public List findPaperList(String usercode){
		String wheresql = "";
		if(StringUtils.isNotBlank(usercode))
		{
			wheresql +=" and usercode='"+usercode+"'";
		}
		String hql = "SELECT papercode FROM ExamineeQtRel  where 1=1 "+wheresql+" GROUP BY papercode";
		return find(hql);
	}
	
	public List gePaperQuestions(QryExamineeQtRelVo vo) {
		String wheresql = "";
		if (StringUtils.isNotBlank(vo.getUsercode())) {
			wheresql += " and usercode ='" + vo.getUsercode()+ "'";
		}
		if(StringUtils.isNotBlank(vo.getPapercode()))
		{
			wheresql+=" and papercode ='"+vo.getPapercode()+"'";
		}
		String sql = " SELECT qtno FROM examinee_qt_rel  where 1=1  "+wheresql;
		
		List list = findBySql(sql);
		return list;
		
	}
	
	public String userAnswerStr(String papercode, String usercode, Integer qtno) {
		String wheresql = " and papercode='"+papercode+"' and usercode='"+usercode+"' and qtno="+qtno;
		String sql = " SELECT qtanswer FROM examinee_qt_rel where 1=1 "+wheresql;
		return findBySql(sql).get(0).toString();
	}
	
	public Map getExamineeMap(String papercode){
		String wheresql="";
		if(StringUtils.isNotBlank(papercode)){
			wheresql += " and a.papercode='"+papercode+"'";
		}
		String sql = "SELECT a.usercode,b.user_name FROM examinee_qt_rel a,exam_sys_user b  "+
				     " WHERE a.usercode=b.user_code "+wheresql+"  GROUP BY a.usercode";
		
		List ls = findBySql(sql);
		Map eMap = new HashMap();
		for(int i = 0;i<ls.size();i++)
		{
			Object[] objs = (Object[])ls.get(i);
			eMap.put(objs[0].toString(), objs[1].toString());
		}
		return eMap;
	}
	
	
}
