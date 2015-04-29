package exam_service;

import java.util.List;
import java.util.Map;

import exam_cst.PageArg;
import exam_vo.base.ExamBaseRoleVo;
import exam_vo.base.ExamDictionaryVo;
import exam_vo.base.QryExamDictionaryVo;
import exam_vo.base.QueryExamBaseRoleVo;
import exam_vo.passwordChange.SavePassword;


public interface IBaseService {
	/**
	 * 基本数据操作接口
	 */
	
	/**
	 * 查询角色信息（真分页）
	 */
	public ExamBaseRoleVo[] queryBaseRoleInfo(QueryExamBaseRoleVo queryVo,PageArg arg);
	/**
	 * 查询角色信息(假分页)
	 */
	public ExamBaseRoleVo[] queryBaseRoleInfo(QueryExamBaseRoleVo queryVo);
	
	/**
	 * 修改角色信息
	 */
	public Long updateRoleInfo(ExamBaseRoleVo vo);
	/**
	 * 删除角色信息
	 */
	public boolean deleteRoleInfo(ExamBaseRoleVo vo);
	/**
	 * 角色下拉框Map
	 */
	public Map<Long,String> getRoleMap();
	
	/**
	 * 员工下拉框
	 */
	public Map<Long, String> findUserNameMap();


	/**
	 * 查询数据字典
	 * @param qryVo
	 * @return
	 */
    public ExamDictionaryVo[] findExamDictionaryInfos(QryExamDictionaryVo qryVo);
    
    /**
     * 新增 or  修改数据字典
     * @param vo
     * @return
     */
    public Integer saveOrUpdateExamDictionary(ExamDictionaryVo vo);
    
    /**
     * 删除数据字典
     * @param vo
     * @return
     */
    public boolean deleteExamDictionary(ExamDictionaryVo vo);
    
    /**
	 * 数据字典下拉框
	 */
	public Map getdictionaryMap();
	
	/**
	 * 根據dcCode,dctype查询记录
	 * @param dcCode
	 * @return
	 */
	 public List findExamDictionaryByDcCode(ExamDictionaryVo vo);
	 
	 
	 /**
	  * 密码修改
	  * @param vo
	  * @return
	  */
	 public int passwordModify( SavePassword vo);

}
