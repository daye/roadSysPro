package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class dictionary_type{

	
	public final static String dictionary_type11 = "11";
	public final static String dictionary_type12 = "12";
	public final static String dictionary_type13 = "13";
	public final static String dictionary_type11_str = "选择题类型";
	public final static String dictionary_type12_str = "考试科目";
	public final static String dictionary_type13_str = "试题答案";
	
	public static Map dictionaryTypeMap = new HashMap();
	
	static{
		dictionaryTypeMap.put(dictionary_type11, dictionary_type11_str);
		dictionaryTypeMap.put(dictionary_type12, dictionary_type12_str);
		dictionaryTypeMap.put(dictionary_type13, dictionary_type13_str);
	}
}
