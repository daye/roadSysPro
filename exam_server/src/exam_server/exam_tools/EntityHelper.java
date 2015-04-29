/**
 * 公司：上海亚太神通有限公司Copyright (c) 2005 <br>
 * 作者: hajime<br>
 * 创建时间: 2008-7-8<br>
 * 单元描述(主要函数及其功能): <br>     
 */
package exam_tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import saptac.core.Err;


/**
 * 名称：ObjUtil<br>
 * 描述：<br>
 * 版权：上海亚太计算机信息系统有限公司 Copyright@2006<br>
 * 作者：hajime<br>
 * 时间：2008-7-8<br>
 */

public class EntityHelper
{
    public static void copyProperties(Object srcobj, Object destobj)
    {
        FieldHelper fh = new FieldHelper();
        Set srcf = fh.getReadFields(srcobj.getClass());
        Set desf = fh.getWriteFields(destobj.getClass());
        Iterator it = srcf.iterator();
        while(it.hasNext())
        {
            String fName = (String)it.next();
            if(desf.contains(fName))
            {
                Object value;
                try
                {
                    value = fh.getFieldValue(srcobj, fName);
                    fh.setFieldValue(destobj, fName, value);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }        
    }
    
    public static Object copyProperties(Object srcobj,Class destclass)
    {
        try
        {
            Object destobj = destclass.newInstance();
            copyProperties(srcobj, destobj);
            return destobj;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List getVo(List entitys,Class desCls)
	{
		try{
			List ret = new ArrayList();
			if(entitys.size()<1)
				return ret;
			for(Object so:entitys)
			{
				Object obj = desCls.newInstance();
				BeanUtils.copyProperties(so, obj);
				ret.add(obj);
			}
			return ret;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
