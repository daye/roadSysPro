package exam_tools;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import saptac.core.Err;


public class ValidateHelper {

	public static String zIntCheck = "^[1-9]|[1-9][0-9]{1,8}$";//正整数
	public static String zRealCheck = "^[1-9]|[1-9]\\d*|[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";//正实数
	public static String check_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static String check_tel = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	public static void lengthValidate(String valiName,String data,int length)
	{
		if(data!=null)
		{
			Err.checkError(data.getBytes().length>length,valiName+"长度过长!");
		}
	}
	public static void nullDataValidate(String valiName,String data){
		Err.checkError(data==null||data.trim().length()==0||data.equalsIgnoreCase("null"),valiName+"不能为空!");
	}
	
	public static void validateNUM(String valiName,String data){
		Err.checkError(numberValidate(data)==false,valiName+"不是数字,请重新输入!");
	}
	public static void validateEmail(String data){
		Err.checkError(fieldCheck(data,check_email)==false,"邮箱格式不正确!");
	}
	public static void validateMobile(String data){
		Err.checkError(fieldCheck(data,check_tel)==false,"手机式不正确!");
	}
	
	
	/**
	 * 检查字段值是否符合自身应该满足的正则表达式
	 * @param field
	 * @param check
	 * @return
	 */
	public static boolean fieldCheck(String field,String check)
	{
		boolean b = true;
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(field);
		if (!matcher.matches()) {
			b = false;//字段值与正则表达式不匹配
		}
		return b;
	}
	
	/**
	 * 数字验证
	 * @param number
	 * @return
	 */
	public static boolean numberValidate(String number)
	{
		boolean b = true;
		try {
			new BigDecimal(number);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}
	

}
