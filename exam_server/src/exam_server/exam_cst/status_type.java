package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class status_type {

	private final static Integer STATUS_VALID = 0;
	private final static Integer STATUS_INVALID = 1;
	private final static String STATUS_VALID_STR ="有效";
	private final static String STATUS_INVALID_STR = "无效";
	public static Map statusMap = new HashMap();
	static{
		statusMap.put(STATUS_VALID, STATUS_VALID_STR);
		statusMap.put(STATUS_INVALID, STATUS_INVALID_STR);
	}
}
