/**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: Soddy<br>
 * 创建时间: 2008-6-22<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package exam_context;

public class Thread_Data {
  public Thread_Data() {
  }

  /**
   * 功能描述：获取属性��ȡ��ǰ�
   * @param name String
   * @return Object
   */
  public Object get_attribute(String name)
  {
    java.util.Map map=Data_Manager.get_instance().get_thread_data();
    synchronized(map)
    {
        return map.get(name);
    }
    
  }

  /**
   * 功能描述：设置属性�
   * @param name String
   * @param value Object
   */
  public void set_attribute(String name,Object value)
  {
    java.util.Map map=Data_Manager.get_instance().get_thread_data();
    synchronized(map)
    {
      if(name==null) return;
      if(value==null)
        map.remove(name);
      else
        map.put(name,value);
    }
  }
  
  public void remove_attribute(String name)
  {
    if(name==null) return;
    
    java.util.Map map=Data_Manager.get_instance().get_thread_data();
    synchronized(map)
    {
      map.remove(name);
    }
  }
  
  /**
   * 功能描述：清除
   *
   */
  public void clear()
  {
      java.util.Map map=Data_Manager.get_instance().get_thread_data();
      synchronized(map)
      {
        map.clear();
      }
  }
}
