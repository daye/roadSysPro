/**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: Soddy<br>
 * 创建时间: 2008-6-22<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package exam_factory;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

import exam_service.IBackstageService;
import exam_service.IBaseService;
import exam_service.IExamService;
import exam_service.ISecurityService;
import exam_service.ISystemService;



public interface IServiceFactory {


	/**
	 * 获取系统安全服务
	 * @return
	 */
	public ISecurityService getSecurityService();
	
	/**
	 * 获取基本信息服务
	 * @return
	 */
	public IBaseService getBaseService();
	
	/**
	 * 获取系统服务
	 * @return
	 */
	public ISystemService getSystemService();
	
	/**
	 * 获取上下文
	 * @return
	 */
	public ApplicationContext getContext();
	
	/**
	 * 获取数据源
	 * @return
	 */
	public DataSource getDataSource();
	
	/**
	 * 获取后台管理service
	 * @return
	 */
	public IBackstageService getBackstageService();
	
	/**
	 * 考试service
	 * @return
	 */
	public IExamService getExamService();
	
}
