 /**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: Soddy<br>
 * 创建时间: 2008-6-22<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package saptac.core;

/**
 * @author cbx
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProjectException extends RuntimeException
{

    public ProjectException(String msg)
    {
        super(msg);
    }
    
    public ProjectException(String msg, Throwable ex)
    {
        super(msg,ex);
    }
    
    public static void main(String[] args) {
    }
}
