package exam_cst;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class has_rights {
	public static boolean has_rights = true;

	public static boolean has_not_rights = false;

	public static String has_rights_str = "10";// 有权限

	public static String has_not_rights_str = "11";// 无权限

	public static Map rights_map = new HashMap();

	static {
		rights_map.put(has_rights_str, has_rights);
		rights_map.put(has_not_rights_str, has_not_rights);
	}

}
