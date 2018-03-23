package www.zhouyan.project.utils;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by mac on 18/3/21.
 */

public class ToolString {
    /**
     * 获取UUID
     *
     * @return 32UUID小写字符串
     */
    public static String gainUUID() {
        String strUUID = UUID.randomUUID().toString();
        strUUID = strUUID.replaceAll("-", "").toLowerCase();
        return strUUID;
    }

    /**
     * 判断字符串是否非空非null
     *
     * @param strParm 需要判断的字符串
     * @return 真假
     */
    public static boolean isNoBlankAndNoNull(String strParm) {
        return !((strParm == null) || (strParm.equals("")));

    }


    /**
     * 四舍五入，保留2位小数
     * @param f
     * @return
     */
    public static BigDecimal format(double f) {
        BigDecimal b = new BigDecimal(f);
        return b.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

}
