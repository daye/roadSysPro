package exam_tools;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WeekToDateUtil {

	//根据年份、年份的第X周得到那周的开始日期    返回开始日期(指的是周日的日期)
	public static Date getStartDate(int year, int weeks) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, 0, 1);
		Long Jan_1st = cal.getTimeInMillis();
		Long date_of_custom_week = Jan_1st + A_DAY * (weeks - 1) * 7;
		Long custom_week_start = date_of_custom_week
				- (cal.get(Calendar.DAY_OF_WEEK) - 1) * A_DAY;
		Date week_start = new Date(custom_week_start);
		return week_start;
	}
	//根据年份、年份的第X周得到那周的结束日期   返回结束日期（指的是周六的日期）
	public static Date getEndDate(int year, int weeks) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, 0, 1);
		Long Jan_1st = cal.getTimeInMillis();
		Long date_of_custom_week = Jan_1st + A_DAY * (weeks - 1) * 7;
		Date week_end = new Date(date_of_custom_week+A_DAY);
		return week_end;
	}

	public static final Long A_DAY = 86400000L;

	//standard 日期 传进去的天数就是standard+这个天数的日期
	public static Date getAnyDate(Date standard,int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(standard);
		return new Date(cal.getTimeInMillis()+A_DAY*day);
	}
	//根据项目开始日期 和现在日期 算出现在是项目的第几周
	public static Long weeksToprjStartTime(Date prjStartTime,Date prjNowTime){
		Long prjStar = prjStartTime.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(prjStartTime);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//因为每周的第一天是从周日算起的,当周一的时候dayOfWeek是2
		int dayOfWeek_a = dayOfWeek-1;
		if(dayOfWeek==1)
		{
			dayOfWeek_a=7;
		}
		//与第一天相差的毫秒数
		Long days_millis = (7-dayOfWeek_a)*A_DAY;

		Long prjNow = prjNowTime.getTime();
		//项目开始时间到今天  一共多少天数
		Long days= (prjNow-prjStar+days_millis)/A_DAY;
		//项目开始时间到今天 是第几周
		Long weeks = days/7+1;
		return weeks;
	}
	
	//某年某月份里的第一个星期一的日期
	public static Date getDate(int year,int month){
        Calendar cal = Calendar.getInstance(); 
        cal.set(year,month-1,1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        switch(dayOfWeek){
        case 1:
            cal.add(Calendar.DATE,1);
            break;
        case 2:
            break;
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
            cal.add(Calendar.DATE, cal.get(Calendar.DATE) + 7 - dayOfWeek + 1);
            break;
        }
        return cal.getTime();
    } 
	//判断每月份的1号是星期几  以及每月份的周一、周日对应的日期
	public static List getWeedDate(int week,Date mDate){
		//设置日期显示格式 DateFormat.FULL 代表XX年xx月xx日  星期x 
		  DateFormat dateFormat = 
		       DateFormat.getDateInstance(DateFormat.MEDIUM); 
		
		   Calendar cld=Calendar.getInstance(); 
		   //cld.setFirstDayOfWeek(Calendar.MONDAY); 
		   cld.setTime(mDate); 
		   String startFirDate = dateFormat.format(cld.getTime());
		   //这个时间是时间所属月的第几周
		   int i=cld.get(Calendar.WEEK_OF_MONTH); 
		   //日期是这个周的第几天,由于是从周日算作每周的第一天 不符合我们中国的习惯 所以-1
		   int dayW = cld.get(Calendar.DAY_OF_WEEK)-1;
		   cld.set(GregorianCalendar.DAY_OF_WEEK, 
				   GregorianCalendar.MONDAY); 

				cld.add(GregorianCalendar.DAY_OF_MONTH, 7*(week-1));
				String monDayDate = dateFormat.format(cld.getTime());//周一日期
				cld.add(GregorianCalendar.DAY_OF_MONTH, 6); 
				String friDayDate = dateFormat.format(cld.getTime());//周五日期
				//如果第一周的第一天不是星期一的话
				List dateList = new ArrayList();
				//看xx年xx月01日 是对应的周几,如果是在周日-周六之间
				   if(week==1&&dayW>0&&dayW<6){
					   
					 dateList.add(startFirDate);
					 dateList.add(friDayDate);
					 return dateList;
				   }else
				   {
					   dateList.add(monDayDate);
					   dateList.add(friDayDate);
					   return dateList;
				   }
				   
	}
	
}
