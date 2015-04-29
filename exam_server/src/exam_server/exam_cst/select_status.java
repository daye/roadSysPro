package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class select_status {

	public final static Integer Status_Select = 0;
	public final static Integer Status_Selected = 1;
	private final static String Status_Select_Str = "未选择";
	private final static String Status_Selected_Str = "已选择";
	
	public static Map seStatusMap = new HashMap();
	static{
		seStatusMap.put(Status_Select, Status_Select_Str);
		seStatusMap.put(Status_Selected, Status_Selected_Str);
	}
}
