/**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: Soddy<br>
 * 创建时间: 2008-6-22<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package exam_context;

/**
 * 
 * @author Soddy
 *
 */
class Data_Manager {
  private static Data_Manager _inst=new Data_Manager();
  private Data_Manager()
  {
  }

  public static Data_Manager get_instance()
  {
    return _inst;
  }

  private java.util.Map _datas=new java.util.HashMap(200);

  /**
   * ��ȡ��ǰ�߳����map
   * @return Map
   */
  public java.util.Map get_thread_data()
  {
    String key=Thread.currentThread().toString();
    synchronized (this) {
            java.util.Map result = (java.util.Map) _datas.get(key);
            if (result == null) {
                result = new java.util.HashMap(100);
                _datas.put(key, result);
            }
            return result;
    }
  }


}
