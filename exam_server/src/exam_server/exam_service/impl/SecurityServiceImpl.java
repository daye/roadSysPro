package exam_service.impl;

import exam_factory.impl.DaoFactory;
import exam_service.ISecurityService;
import exam_vo.security.CurrentOperatorVo;

public class SecurityServiceImpl implements ISecurityService {

	public CurrentOperatorVo login(String user, String password) {
		return DaoFactory.getSecurityDao().login(user, password);
	}

}
