package www.zhouyan.project.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by mac on 18/3/21.
 */

public class ToolDateTime {

    /**
     * 日期格式: yyyy-MM-dd HH:mm:ss
     **/
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static String getdate() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }

    public static String getdateTime() {
        DateFormat formatter = new SimpleDateFormat(ToolDateTime.DF_YYYY_MM_DD_HH_MM_SS);
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }

    public static String getdateTime2() {
        DateFormat formatter = new SimpleDateFormat(ToolDateTime.YYYYMMDDHHMMSS);
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }

    //day 天前的日期
    public static String getdateOlderDay(int day) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }

    //一个月前的日期
    public static String getdateOlderMonth() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        calendar.add(Calendar.MONTH, -1);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }

    //3个月前的日期
    public static String getdateOlderMonth2() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        calendar.add(Calendar.MONTH, -3);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));  //加上这行代码就哦了
        //System.out.println(now + " ====== " + formatter.format(calendar.getTime()));
        return formatter.format(calendar.getTime());
    }


    public static int getTimeDifference(String starTime, String endTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            long diff = dateFormat.parse(endTime).getTime() - dateFormat.parse(starTime).getTime();
            return (int) (diff / (60 * 60 * 1000));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }


}
