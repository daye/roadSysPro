package exam_service;

import java.util.List;
import java.util.Map;

import exam_vo.backstage.AnswerQtRelVo;
import exam_vo.backstage.ExamPaperManagerVo;
import exam_vo.backstage.QryAnswerQtRelVo;
import exam_vo.backstage.QryExamPaperManagerVo;
import exam_vo.backstage.QryQuestionStoreVo;
import exam_vo.backstage.QuestionStoreVo;

public interface IBackstageService {

	/**
	 * 后台管理service
	 * @author 武晓
	 */
	
	/**
	 * 查询试题信息
	 * @param vo
	 * @return
	 */
	public QuestionStoreVo[] findQuestionStoreInfo(QryQuestionStoreVo  qrvo);
	
	/**
	 * 对试题信息 进行新增或者修改操作
	 * @param vo
	 * @return
	 */
	public void saveOrupdateQuestionInfos(QuestionStoreVo vo);
	
	/**
	 * 删除试题信息
	 * @param vo
	 * @return
	 */
	public void deleteQuestionInfos(QuestionStoreVo vo);
	
	
	/**
	 * 查询试题答案关系信息
	 * @param vo
	 * @return
	 */
	public AnswerQtRelVo[] findAnswerQtRelInfo(QryAnswerQtRelVo  qrvo);
	
	/**
	 * 查询试卷设置信息
	 * @param vo
	 * @return
	 */
	public ExamPaperManagerVo[] findExamPaperManagerInfo(QryExamPaperManagerVo vo) ;
	
	/**
	 * 对试题设置答案
	 * @param vo
	 * @return
	 */
	public void saveOrupdateAnswerQtRelInfos(AnswerQtRelVo vo);
	
	/**
	 * 删除试题答案
	 * @param vo
	 * @return
	 */
	public void deleteAnswerQtRelInfos(AnswerQtRelVo vo);
	
	/***
	 * 根据科目、试题类型 查询出试题
	 * @param qtsubject
	 * @param qttype
	 * @return
	 */
	public Map findQuestionMap(String qtsubject,String qttype);
	
	/**
	 * 查询出所有的试题 放到map里 去做翻译
	 * @return
	 */
	public Map findQuestionMapAll();
	
	/**
	 * 如果单选的时候看该试题是否设置过正确答案
	 * @param qtno
	 * @param asstatus
	 * @param asid
	 * @return
	 */
	public List findIsExsistAnswerQtRelInfos(Integer qtno,String asstatus,Integer asid);
	
	/**
	 * 该选项是否已经被设置过
	 * @param qtno
	 * @param asno
	 * @return
	 */
	public List findIsExsistAnswerQtRelInfos(Integer qtno,Integer asno,Integer asid);
}
