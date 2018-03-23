package www.zhouyan.project.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhouyan on 2016/11/2.
 */
public class ToolPhoneEmail {

    public static boolean isMobileNO(String mobiles){
        // Pattern p = Pattern.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-3,5-9]))\\d{8}$");
        Pattern p = Pattern.compile("^1\\d{10}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    public static boolean isItemNo(String mobiles){ //只允许输入 字母和数字
        Pattern p = Pattern.compile("^[a-zA-Z0-9\\-]+$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    //判断email格式是否正确
    public static  boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    // 匹配实数 ^[-+]?\d+(\.\d+)?$
    public static  boolean isrealNumber(String email) {
        String str = "^[-+]?\\d+(\\.\\d+)?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public static double number(String str){
        if(str==null) return 0.00;
        double num = 0.00;
        if(str.substring(0,1).equals("-")){
            num = 0-Double.parseDouble(str.substring(1,str.length()));
        }else num =Double.parseDouble(str);
        return ToolString.format(num).doubleValue();
    }
}