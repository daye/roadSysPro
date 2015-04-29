package exam_factory.impl;

import exam_dao.BackstageDao;
import exam_dao.BaseDao;
import exam_dao.ExamQtDao;
import exam_dao.SecurityDao;
import exam_dao.SystemDao;
import exam_factory.ExamSF;

public class DaoFactory {
	
	
	
	public static BaseDao getBaseDao() {
		return (BaseDao)ExamSF.Service().getContext().getBean("BaseDao");
	}

    //两种方法都可以
	public static SecurityDao getSecurityDao() {
		return (SecurityDao)ExamSF.Service().getContext().getBean("securityDao");
	}
//	public static SecurityDao getSecurityDao() {
//		return (SecurityDao)ServiceFactory.ctx.getBean("securityDao");
//	}

	public static SystemDao getSystemDao() {
		return (SystemDao)ExamSF.Service().getContext().getBean("SystemDao");
	}
	
	public static BackstageDao getBackstageDao() {
		return (BackstageDao)ExamSF.Service().getContext().getBean("backstageDao");
	}
	public static ExamQtDao getExamQtDao() {
		return (ExamQtDao)ExamSF.Service().getContext().getBean("examQtDao");
	}
	
}
