package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class asstatus {

	public final static String asstatus_flag1 = "1";
	public final static String asstatus_flag2 = "2";
	private final static String asstatus_flag1_str ="正确答案";
	private final static String asstatus_flag2_str = "错误答案";
	public static Map asstatusMap = new HashMap();
	static{
		asstatusMap.put(asstatus_flag1, asstatus_flag1_str);
		asstatusMap.put(asstatus_flag2, asstatus_flag2_str);
	}
}
