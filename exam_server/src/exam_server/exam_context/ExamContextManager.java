/**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: Soddy<br>
 * 创建时间: 2008-6-22<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package exam_context;

import exam_vo.security.CurrentOperatorVo;


/**
 * @author cbx
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ExamContextManager {
  private static Thread_Data thread_data = new Thread_Data();

  static ExamContextManager inst=new ExamContextManager(); 
  
  public CurrentOperatorVo getOperator()
  {
    return (CurrentOperatorVo)thread_data.get_attribute("operator");    
  }
  
  public void setOperator(CurrentOperatorVo operator)
  {
     thread_data.set_attribute("operator",operator);    
  }
  
  public static ExamContextManager getInstance()
  {
      return inst;
  }
  
  public void setSession(Object obj)
  {
	  thread_data.set_attribute("session",obj);
  }
  
  public Object getSession()
  {
	  return thread_data.get_attribute("session");
  }
  
  public void clear()
  {
	  thread_data.clear(); 
  }
  
}
