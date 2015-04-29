package exam_dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import exam_entity.sys.ExamSysUser;
import exam_vo.security.CurrentOperatorVo;
import saptac.core.Err;

public class SecurityDao extends HibernateDaoSupport {
	public CurrentOperatorVo login(String user, String password) {
		String hql = "from ExamSysUser where user_code = '" + user
				+ "' and password = '" + password + "'";
		List<ExamSysUser> list = this.getHibernateTemplate().find(hql);
		Err.checkError(list.size() != 1, "工号或密码错误！");
		CurrentOperatorVo rs = new CurrentOperatorVo();
		BeanUtils.copyProperties(list.get(0), rs);
		return rs;

	}
}
