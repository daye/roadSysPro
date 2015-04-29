package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class qtstatus {

	public final static String qtstatus1 = "1";
	public final static String qtstatus2 = "2";
	private final static String qtstatus1_str ="正确";
	private final static String qtstatus2_str = "错误";
	public static Map qtstatusMap = new HashMap();
	static{
		qtstatusMap.put(qtstatus1, qtstatus1_str);
		qtstatusMap.put(qtstatus2, qtstatus2_str);
	}
}
