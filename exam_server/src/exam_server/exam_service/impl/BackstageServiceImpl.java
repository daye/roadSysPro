package exam_service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exam_factory.impl.DaoFactory;
import exam_service.IBackstageService;
import exam_tools.EntityConverter;
import exam_vo.backstage.AnswerQtRelVo;
import exam_vo.backstage.ExamPaperManagerVo;
import exam_vo.backstage.QryAnswerQtRelVo;
import exam_vo.backstage.QryExamPaperManagerVo;
import exam_vo.backstage.QryQuestionStoreVo;
import exam_vo.backstage.QuestionStoreVo;

public class BackstageServiceImpl implements IBackstageService{

	public QuestionStoreVo[] findQuestionStoreInfo(QryQuestionStoreVo vo) {
		List list = DaoFactory.getBackstageDao().findQuestionStoreInfo(vo);
		List voList = EntityConverter.getVo(list, QuestionStoreVo.class);
		if(voList.size() < 1)
			return new QuestionStoreVo[]{};
		QuestionStoreVo[] vos = new QuestionStoreVo[voList.size()];
		voList.toArray(vos);
		return vos;
	}

	public void saveOrupdateQuestionInfos(QuestionStoreVo vo) {
		 DaoFactory.getBackstageDao().saveOrupdateQuestionStoreInfo(vo);
	}

	public void deleteQuestionInfos(QuestionStoreVo vo) {
		
		DaoFactory.getBackstageDao().delQuestionStoreInfo(vo);
	}

	@Override
	public AnswerQtRelVo[] findAnswerQtRelInfo(QryAnswerQtRelVo qrvo) {
		List list = DaoFactory.getBackstageDao().findAnswerQtRelInfo(qrvo);
		List vosList = new ArrayList();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{//t.asid,t.qtno,t.asno,t.asname,t.asstatus,b.qtname,b.qtsubject,b.qttype
				AnswerQtRelVo vo = new AnswerQtRelVo();
				Object[] objs = (Object[])list.get(i);
			    vo.setAsid(Integer.parseInt(objs[0]+""));
			    vo.setQtno(Integer.parseInt(objs[1]+""));
			    vo.setAsno(Integer.parseInt(objs[2]+""));
			    vo.setAsname(objs[3]+"");
			    vo.setAsstatus(objs[4]+"");
			    vo.setQtname(objs[5]+"");
			    vo.setQtsubject(objs[6]+"");
			    vo.setQttype(objs[7]+"");
			
				vosList.add(vo);
			}
		}
		
		if(vosList.size() < 1)
			return new AnswerQtRelVo[]{};
		AnswerQtRelVo[] vos = new AnswerQtRelVo[vosList.size()];
		vosList.toArray(vos);
		return vos;
	}

	@Override
	public void saveOrupdateAnswerQtRelInfos(AnswerQtRelVo vo) {
		 DaoFactory.getBackstageDao().saveOrupdateAnswerQtRelInfo(vo);
		
	}

	@Override
	public void deleteAnswerQtRelInfos(AnswerQtRelVo vo) {
		DaoFactory.getBackstageDao().delAnswerQtRelInfo(vo);
		
	}

	@Override
	public Map findQuestionMap(String qtsubject, String qttype) {
		return DaoFactory.getBackstageDao().findQuestionMap(qtsubject, qttype);
	}

	@Override
	public Map findQuestionMapAll() {
		return DaoFactory.getBackstageDao().findQuestionMapAll();
	}

	public List findIsExsistAnswerQtRelInfos(Integer qtno,String asstatus,Integer asid){
		return DaoFactory.getBackstageDao().findIsExsistAnswerQtRelInfos(qtno, asstatus, asid);
	}

	@Override
	public List findIsExsistAnswerQtRelInfos(Integer qtno, Integer asno,Integer asid) {
		return DaoFactory.getBackstageDao().findIsExsistAnswerQtRelInfos(qtno,asno,asid);
	}

	@Override
	public ExamPaperManagerVo[] findExamPaperManagerInfo(QryExamPaperManagerVo qryvo) {
		List list = DaoFactory.getBackstageDao().findExamPaperManagerInfo(qryvo);
		List vosList = new ArrayList();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{//t.asid,t.qtno,t.asno,t.asname,t.asstatus,b.qtname,b.qtsubject,b.qttype
				ExamPaperManagerVo vo = new ExamPaperManagerVo();
				Object[] objs = (Object[])list.get(i);
			    vo.setPaperno(Integer.parseInt(objs[0]+""));
			    vo.setPapername(objs[1]+"");
			    vo.setQtsubject(objs[2]+"");
			    vo.setQtno(Integer.parseInt(objs[3]+""));
			    vo.setQtname(objs[4]+"");
				vosList.add(vo);
			}
		}
		
		if(vosList.size() < 1)
			return new ExamPaperManagerVo[]{};
		ExamPaperManagerVo[] vos = new ExamPaperManagerVo[vosList.size()];
		vosList.toArray(vos);
		return vos;
	}
}
