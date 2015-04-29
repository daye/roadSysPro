package exam_service;

import java.util.List;
import java.util.Map;

import exam_entity.sys.ExamSysMenu;
import exam_vo.system.ExamSysUserVo;
import exam_vo.system.QueryExamSysUserVo;


public interface ISystemService {
	/**
	 * 系统操作接口
	 */
	
	/**
	 * 查询所有菜单
	 */
	public Map<Long,ExamSysMenu> getAllMenuMap();
	
	/**
	 * 查询员工信息
	 * @param vo
	 * @return
	 */
	public ExamSysUserVo[] findExamSysUserInfo(QueryExamSysUserVo vo);
	
	
	public Long updateExamSysUserInfo(ExamSysUserVo vo);
	
	/**
	 * 查询工号是否存在
	 * @param userCode
	 * @return
	 */
	public List findIsExsitExamSysUserInfo(String userCode);
	
	/**
	 * 删除员工信息
	 * @param department_id
	 */
	public boolean delExamSysUserInfo(ExamSysUserVo vo);
}
