
package exam_factory.impl;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam_factory.IServiceFactory;
import exam_service.IBackstageService;
import exam_service.IBaseService;
import exam_service.IExamService;
import exam_service.ISecurityService;
import exam_service.ISystemService;


public class ServiceFactory implements IServiceFactory {

	public static ApplicationContext ctx;

	public ServiceFactory() {
		getContext();
	}

	public ApplicationContext getContext() {
		if (ctx == null) {
			String[] xml_file = loadctx();
			ctx = new ClassPathXmlApplicationContext(xml_file);
		}
		return ctx;
	}

	private static String[] loadctx() {
		return new String[] { "exam_config/exam-db.xml", "exam_config/exam-dao.xml",
				"exam_config/exam-hibernate.xml", "exam_config/exam-service.xml" };
	}


	public IBaseService getBaseService() {
		return (IBaseService) ctx.getBean("BaseService");
	}

	public ISecurityService getSecurityService() {
		return (ISecurityService) ctx.getBean("SecurityService");
	}

	public ISystemService getSystemService() {
		return (ISystemService) ctx.getBean("SystemService");
	}

	public DataSource getDataSource() {
		return (DataSource) ctx.getBean("dataSourceProxy");
	}
	public IBackstageService getBackstageService() {
		return (IBackstageService) ctx.getBean("backstageService");
	}
	public IExamService getExamService() {
		return (IExamService) ctx.getBean("examService");
	}
}
