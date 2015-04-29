package exam_tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static int maxYear = 50;
	public static final String CALENDER_DATE_FORMAT = "yyyy-MM-dd";
	public static final String CALENDER_MONTH_FORMAT = "yyyy-MM";
	public static final String CALENDER_YEAR_FORMAT = "yyyy";
	public static final String CALENDER_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String CALENDER_DATA_FORMAT2 = "yyyyMMdd";
	
	public static SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时期格式
	
	public static SimpleDateFormat sdfs_ch = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");// 时期格式
	
	public static SimpleDateFormat sdfd_ch = new SimpleDateFormat("yyyy年MM月dd日");// 时期格式
	
	public static SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");// 时期格式,时期格式
	
	public static SimpleDateFormat sdfms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// 时期格式
	
	public static SimpleDateFormat sdfs2 = new SimpleDateFormat(CALENDER_DATA_FORMAT2);
	
	public static SimpleDateFormat sdfd3 = new SimpleDateFormat("yyyyMMdd");// 时期格式,时期格式
	public static SimpleDateFormat sdfd4 = new SimpleDateFormat("yyyyMMddHHmmss");// 时期格式,时期格式
	
	public static SimpleDateFormat ymd_cn = new SimpleDateFormat("日期：yyyy年MM月dd日");// 时期格式
	
	public static String getDateTime(java.util.Date date)
	{
		if(null != date)
		{
			return sdfs.format(date);
		}else{
			return "";
		} 
	}
	
	public static String getAddDayDateTime(java.util.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(5, 1);
		date = c.getTime();
		if(null != date)
		{
			return sdfs.format(date);
		}else{
			return "";
		} 
	}
	
	public static String getAddDayDate(java.util.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(5, 1);
		date = c.getTime();
		if(null != date)
		{
			return sdfd.format(date);
		}else{
			return "";
		} 
	}
	
	public static String getDate(java.util.Date date)
	{
		if(null != date)
		{
			return sdfd.format(date);
		}else{
			return "";
		} 
	}
	
	public static String getSubDayDate(java.util.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(5, -1);
		date = c.getTime();
		if(null != date)
		{
			return sdfd.format(date);
		}else{
			return "";
		} 
	}
	
	public static Date stringToDate(String date)
    {
        if(null != date &&!"".equals(date))
        {
            
            try {
                return  sdfd.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        return null;
    }
	
	public static Date stringToTime(String date)
	{
		if(null != date &&!"".equals(date))
		{
			
			try {
				return  sdfs.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return null;
	}
	
	//验证起始日期是否早于截止日期
	public static String getDateRangeValidateMsg(Date start, Date end)
	{
		if (start.getTime() <= end.getTime())
		{
			return "";
		}else{
			return "起始日期 必需早于 截止日期！";
		}
	}
	/**
     * 将FORM中未格式化的日期字符串转换成数据库所需日期字符串
     * 
     * @param unformatDateStr
     *            前台页面FORM中未格式化的日期字符串 原数据样式: '010308'
     * @return date 转换后的日期格式:'2008-01-03'
     */
    public static Date str2date(String unformatDateStr)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = new String();
        String year = new String();
        String simpleYear = unformatDateStr.substring(4, unformatDateStr
                .length());
        if (new Integer(simpleYear).intValue() > maxYear)
            year = "19" + simpleYear;
        else
            year = "20" + simpleYear;
        String month = unformatDateStr.substring(0, 2);
        String day = unformatDateStr.substring(2, 4);
        dateStr = year + "-" + month + "-" + day;
        try
        {
            return sf.parse(dateStr);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return new Date();
    }
    /**
     * 将FORM中未格式化的日期字符串转换成数据库所需日期字符串
     * 
     * @param unformatDateStr
     *            前台页面FORM中未格式化的日期字符串 原数据样式: '2008-01-03'
     * @return date 转换后的日期格式:'2008-01-03'
     */
    public static Date string2date(String unformatDateStr)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            return sf.parse(unformatDateStr);
        } catch (ParseException e)
        {
            return null;
        }
    }
    /**
     * yyyyMMdd to yyyy-MM-dd
     * @param unformatDateStr
     * @return
     */
    public static String str2str(String unformatDateStr)
    {
    	return unformatDateStr.substring(0, 4)+"-"+unformatDateStr.substring(4, 6)+"-"+unformatDateStr.substring(6, 8);
    }
	public static int rangeByDay = 3;
	public static int rangeByMonth = 2;
	
	
	  public static String getWeekOfDate(Date dt) {
	        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(dt);

	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0)
	            w = 0;

	        return weekDays[w];
	    }

	
	
}
