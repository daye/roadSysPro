package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class sex_type {
	private final static Integer SEX_MALE = 0;
	private final static Integer SEX_FEMALE = 1;
	private final static String SEX_MALE_STR = "男";
	private final static String SEX_FEMALE_STR = "女";
	
	public static Map sexMap = new HashMap();
	
	static{
		sexMap.put(SEX_MALE, SEX_MALE_STR);
		sexMap.put(SEX_FEMALE, SEX_FEMALE_STR);
	}
}
