package www.zhouyan.project.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by zhouyan on 17/8/6.
 */

public class DelUtils {
    /**
     * 删除之前的apk
     *
     * @param apkName apk名字
     * @return
     */
    public static File clearApk(Context context, String apkName) {
        File apkFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), apkName);
        if (apkFile.exists()) {
            apkFile.delete();
        }
        return apkFile;
    }
}
