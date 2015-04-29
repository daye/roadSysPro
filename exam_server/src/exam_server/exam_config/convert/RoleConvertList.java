package exam_config.convert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class RoleConvertList {
	
	private static Properties p = new Properties();
	
	static {
		try {
			p.load(RoleConvertList.class.getResourceAsStream("../system/role.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean getProperties(String key)
	{
		String value = p.getProperty("static_role");
		String[] values = value.split(",");
		List valueList = new ArrayList(Arrays.asList(values));
		if(valueList.contains(key))
		{
			return true;
		}
		
		else{
			return false;
		}
		
	}
//	private List valList = null;
//	public RoleConvertList(){
//		valList = this.convertList();
//	}
//	public List convertList(){
//		
//		Properties p = new Properties();
//		InputStream fis = null;
//		try {
//			fis = RoleConvertList.class
//					.getResourceAsStream("../system/role.properties");
//			p.load(fis);
//		} catch (IOException e) {
//		} finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//				}
//			}
//		}
//		String value = p.getProperty("static_role");
//		String[] values = value.split(",");
//		List valueList = new ArrayList(Arrays.asList(values));
//		
//		return valueList;
//	}
//	
//	public List getValList() {
//		return valList;
//	}
}
