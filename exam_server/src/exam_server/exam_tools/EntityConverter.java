package exam_tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class EntityConverter {
	
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
