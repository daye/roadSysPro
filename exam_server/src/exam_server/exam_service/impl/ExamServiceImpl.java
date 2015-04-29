package exam_service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exam_bean.QuestionBean;
import exam_bean.Result;
import exam_entity.backstage.ExamineeQtRel;
import exam_factory.impl.DaoFactory;
import exam_service.IExamService;
import exam_vo.exam.ExamSetVo;
import exam_vo.examinee.ExamStatisVo;
import exam_vo.examinee.ExamineeQtRelVo;
import exam_vo.examinee.QryExamineeQtRelVo;
import exam_vo.examinee.StandardAnswerVo;

public class ExamServiceImpl implements IExamService {


	/**
	 * 根据科目以及选择题类型查询出所有的符合条件的试题
	 * @author 武晓
	 */
	public Integer[] getAllQuestions(String qtsubject,String qttype) {
		List list = DaoFactory.getExamQtDao().getAllQuestions(qtsubject, qttype);
		Object[] allQ = (Object[])list.toArray();
		Integer[] it = new Integer[allQ.length];
		for(int i=0;i<it.length;i++){
			it[i]=(Integer)allQ[i];
		}
		return it;
	}

	/**
	 * 根据随机产生的试题编号去查询对应的试题
	 * 思路:将试题提前放到map里去 ,键值对 :key是 试题编号 value是对应的试题
	 * @author 武晓
	 */
	public List<QuestionBean> findQuestions(Integer[] questionId) {

		Map<Integer, QuestionBean> map = new HashMap<Integer, QuestionBean>();
		
		List qlist = DaoFactory.getExamQtDao().findQuestionStoreInfos();
		for(int i =0;i<qlist.size();i++)
		{//t.qtno,t.qtname,t.qttype,t.qtgrade
			Object[] objs = (Object[])qlist.get(i);
			QuestionBean qt = new QuestionBean();
			qt.setQuestionId(Integer.parseInt(objs[0].toString()));
			qt.setQuestionName(objs[1]+"");
			qt.setType(objs[2]+"");
			qt.setQtgrade(objs[3]+"");
			
			//查询出对应的答案选项
			List alst = DaoFactory.getExamQtDao().findAnswerQtRelInfos(qt.getQuestionId());
			Result[] results = new Result[alst.size()];
			for(int j = 0;j<alst.size();j++){
				Object[] rs = (Object[])alst.get(j);
				results[j] = new Result();
				results[j].setResultId(Integer.parseInt(rs[0].toString()));
				results[j].setResult(rs[1].toString());
			}
			qt.setResults(results);
			
			//将试题编号 以及试题放到map中
			map.put(qt.getQuestionId(), qt);
		}

		List<QuestionBean> questionBeans = new ArrayList<QuestionBean>(questionId.length);
		for (Integer id : questionId) {
			questionBeans.add(map.get(id));
		}
		return questionBeans;

	}

	public int findCountQtInfos(ExamSetVo vo){
		return DaoFactory.getExamQtDao().findCountQtInfos(vo);
	}

	public StandardAnswerVo fidRightAnsersInfo(String qtno) {
		List list = DaoFactory.getExamQtDao().fidRightAnsersInfo(qtno);
		StandardAnswerVo vo = new StandardAnswerVo();
		if (list.size()>0) {
			Object[] obj = (Object[])list.get(0);
			vo.setQtno(obj[0]+"");
			vo.setAsno(obj[1]+"");
			vo.setQtgrade(obj[2]+"");;
		}
		return vo;
	}

	@Override
	public int findPagerCountByUserCode(String usercode) {
		return DaoFactory.getExamQtDao().findCountPaperByUserCode(usercode);
	}

	@Override
	public void saveExamineeQtRelInfo(ExamineeQtRelVo vo) {
		 DaoFactory.getExamQtDao().saveExamineeQtRelInfo(vo);
		
	}

	@Override
	public ExamineeQtRelVo[] findExamineeQtRelInfos(QryExamineeQtRelVo vo) {
		List list = DaoFactory.getExamQtDao().findExamineeQtRelInfo(vo);
		ExamineeQtRelVo[] vos = new ExamineeQtRelVo[list.size()];
		for(int i = 0;i<list.size();i++)
		{
			Object[] objs = (Object[]) list.get(i);
			vos[i] = new ExamineeQtRelVo();
			vos[i].setPapercode(objs[0].toString());
			vos[i].setUsercode(objs[1].toString());
			vos[i].setUsername(objs[2].toString());
			vos[i].setQtno(objs[3].toString());
			vos[i].setQtname(objs[4].toString());
			vos[i].setQtanswer(objs[5]==null?"":objs[5].toString());
			vos[i].setQtgrade(objs[6]==null?"":objs[6].toString());
			vos[i].setQtstatus(objs[7].toString());
			vos[i].setAsno(objs[8]==null?"":objs[8].toString());
			vos[i].setRigtasname(objs[9]==null?"":objs[9].toString());
		}
		return vos;
	}

	@Override
	public ExamStatisVo findExamStatisVo(QryExamineeQtRelVo vo) {
		List list =  DaoFactory.getExamQtDao().findExamStatisVo(vo);
		ExamStatisVo svo = new ExamStatisVo();
		if(list.size()==1)
		{
			Object[] objs = (Object[])list.get(0);
			
			svo.setRights_as(objs[0]==null?"0":objs[0].toString());
			svo.setWrong_as(objs[1]==null?"0":objs[1].toString());
			svo.setQtgrade_total(objs[2]==null?"0":objs[2].toString());
		}
		return svo;
	}

	@Override
	public List findExamPaperList(String usercode) {
		// TODO Auto-generated method stub
		return  DaoFactory.getExamQtDao().findPaperList(usercode);
	}
	
	/**
	 * 查询出试卷的题目编号
	 * @author 武晓
	 */
	public Integer[] gePaperQuestions(QryExamineeQtRelVo vo) {
		List list = DaoFactory.getExamQtDao().gePaperQuestions(vo);
		Object[] allQ = (Object[])list.toArray();
		Integer[] it = new Integer[allQ.length];
		for(int i=0;i<it.length;i++){
			it[i]= Integer.parseInt(allQ[i].toString());
		}
		return it;
	}

	@Override
	public String userAnswerStr(String papercode, String usercode, Integer qtno) {
		return DaoFactory.getExamQtDao().userAnswerStr(papercode, usercode, qtno);
	}

	@Override
	public Map getExamineeMap(String papercode) {
		return DaoFactory.getExamQtDao().getExamineeMap(papercode);
	}
}
