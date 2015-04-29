package exam_service;

import exam_vo.security.CurrentOperatorVo;

public interface ISecurityService {
	/**
	 * 系统安全操作接口
	 */
	
	/**
	 * 用户登陆
	 */
	public CurrentOperatorVo login(String user, String password);

}
