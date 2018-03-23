package www.zhouyan.project.utils;

/**
 * Created by mac on 18/3/21.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by zhouyan on 17/8/6.
 */

public class SystemManager {
    /**
     * 提升读写权限
     *
     * @param filePath 文件路径
     * @return
     * @throws IOException
     */
    public static void setPermission(String filePath) {
        String command = "chmod " + "777" + " " + filePath;
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用程序运行命令获取 Root权限，设备必须已破解(获得ROOT权限)
     *
     * @param command 命令：String apkRoot="chmod 777 "+getPackageCodePath();
     * @return 0 命令执行成功
     */
    public static int RootCommand( String command) {
//        Log.e("-----------commod", command + "");
        Process process = null;
        BufferedReader errorStream = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(command+ "\n");
            os.flush();
            os.writeBytes("exit\n");
            os.flush();
            int i = process.waitFor(); //未执行完
            return i;
        } catch (Exception e) {
            return -1;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
                process.destroy();
            } catch (Exception e) {

            }
        }
    }

//
//    作者：陈丰尧
//    链接：http://www.jianshu.com/p/58aa2b7c3943
//    來源：简书
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
