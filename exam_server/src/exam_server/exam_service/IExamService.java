package exam_service;

import java.util.List;
import java.util.Map;

import exam_bean.QuestionBean;
import exam_vo.exam.ExamSetVo;
import exam_vo.examinee.ExamStatisVo;
import exam_vo.examinee.ExamineeQtRelVo;
import exam_vo.examinee.QryExamineeQtRelVo;
import exam_vo.examinee.StandardAnswerVo;

public interface IExamService {

	/**
	 * 根据科目以及选择题类型查询出所有的符合条件的试题
	 * @author 武晓
	 */
	public Integer[] getAllQuestions(String qtsubject,String qttype);
	/**
	 * 根据所选的题目ID找出所有题目
	 * @param questionId
	 * @return
	 */
	List<QuestionBean> findQuestions(Integer[] questionId);
	
	/**
	 * 查找出可以用生成试卷的最大数量
	 * @param vo
	 * @return
	 */
	public int findCountQtInfos(ExamSetVo vo);
	
	/**
	 * 根据题号查出对应的答案以及分数
	 * @param qtno
	 * @return
	 */
	public StandardAnswerVo fidRightAnsersInfo(String qtno);
	
	/**
	 * 查询某人试卷数量 --为了生存试卷编号
	 * @param usercode
	 * @return
	 */
	public int findPagerCountByUserCode(String usercode);
	
	/**
	 * 保存试卷信息
	 * @param vo
	 */
	public void saveExamineeQtRelInfo(ExamineeQtRelVo vo);
	
	/**
	 * 查找试卷信息
	 * @param vo
	 * @return
	 */
	public ExamineeQtRelVo[] findExamineeQtRelInfos(QryExamineeQtRelVo vo) ;
	
	/**
	 * 根据试卷名称  考生 查找做对的题数 做错的题数 总得分
	 * @param vo
	 * @return
	 */
	public ExamStatisVo findExamStatisVo(QryExamineeQtRelVo vo);
	
	/**
	 * 试卷列表
	 * @return
	 */
	public List findExamPaperList(String usercode);
	
	/**
	 * 查询试卷的题目编号
	 * @param vo
	 * @return
	 */
	public Integer[] gePaperQuestions(QryExamineeQtRelVo vo);
	
	
	/**
	 * 根据试卷、考生、题号  查询考生所做的答案
	 * @param papercode
	 * @param usercode
	 * @param qtno
	 * @return
	 */
	public String userAnswerStr(String papercode,String usercode,Integer qtno);
	
	/**
	 * 查询出考生map
	 * @return
	 */
	public Map getExamineeMap(String papercode);

}
