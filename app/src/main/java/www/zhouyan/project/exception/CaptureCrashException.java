package www.zhouyan.project.exception;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.utils.MyLogger;
import www.zhouyan.project.utils.ToolAlert;

/**
 * @author zhouyan0 UncaughtException处理类,当程序发生Uncaught异常的时候,有该类 来接管程序,并记录
 *         发送错误报告.. 註冊方式 CaptureCrashException crash =
 *         CaptureCrashException.getInstance(); //注册crashHandler
 *         crash.init(getApplicationContext()); //初始化
 *         crash.sendPreviousReportsToServer();//发送以前没发送的报告(可选)
 * 
 */
public class CaptureCrashException implements UncaughtExceptionHandler {
	/** 系统默认的UncaughtException处理类 */
	private UncaughtExceptionHandler mDefaultHandler;
	/** CaptureCrashException实例 */
	private static CaptureCrashException instance;
	/** 程序的Context对象 */
	private Context mContext;

	/** 使用Properties来保存设备的信息和错误堆栈信息 */
	private static final String VERSION_NAME = "versionName";
	private static final String VERSION_CODE = "versionCode";

	/** 保证只有一个CaptureCrashException实例 */
	private CaptureCrashException() {
	}

	/** 获取CrashHandler实例 ,单例模式 */
	public static CaptureCrashException getInstance() {
		if (instance == null) {
			instance = new CaptureCrashException();
		}
		return instance;
	}

	/**
	 * 初始化,注册Context对象, 获取系统默认的UncaughtException处理器,
	 * 设置该CaptureCrashException为程序的默认处理器
	 * 
	 * @param ctx
	 */
	public void init(Context ctx) {
		mContext = ctx;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
			// 如果用户没有处理则让系统默认的异常处理器来处理
			mDefaultHandler.uncaughtException(thread, ex);
		} else {
			new Thread() {
				@Override
				public void run() {
					SystemClock.sleep(2000);
					MyApplication.getInstance().removeAll();
				}
			}.start();
			
//			AsyncTask.execute(new Runnable() {
//				@Override
//				public void run() {
//					// Sleep一会后结束程序
//					SystemClock.sleep(2000);
//					// Intent intent = new Intent(mContext,
//					// SplashActivity.class);
//					// PendingIntent restartIntent = PendingIntent.activity(
//					// mContext, 0, intent,
//					// Intent.FLAG_ACTIVITY_NEW_TASK);
//					// //退出程序
//					// AlarmManager mgr =
//					// (AlarmManager)MyApplication.getMyApplication().getSystemService(Context.ALARM_SERVICE);
//					// mgr.set(AlarmManager.RTC, System.currentTimeMillis() +
//					// 1000,
//					// restartIntent); // 1秒钟后重启应用
//
//					MyApplication.getInstance().removeAll();
//					// try {
//					// ActivityManager sd = (ActivityManager)
//					// mContext.getSystemService(mContext.ACTIVITY_SERVICE);
//					// Method method =
//					// Class.forName("android.app.ActivityManager").getMethod("forceStopPackage",
//					// String.class);
//					// method.invoke(sd, "com.nzaom.app");
//					// } catch (Exception e) {
//					// e.printStackTrace();
//					// }
//				}
//			});
		}
	}

	/**
	 * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
	 * 
	 * @param ex
	 * @return true:如果处理了该异常信息;否则返回false
	 */
	private boolean handleException(Throwable ex) {
		if (ex == null) {
			return true;
		}
		// 输出到日志
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		MyLogger.systemlLog().e(sw.toString());

//		// 保存异常日志到sd卡
//		saveErrorLog(ex);
//
//		// 收集设备信息
//		saveDeviceInfo();

		Log.e("-------------bug",ex.toString());
		// 发送异常信息到服务器
		//bugly 手动上报
//		CrashReport.postCatchedException(ex);

		//Log.e("-------------bug","上传成功");
		// 使用Toast友好提示
//		AsyncTask.execute(new Runnable() {
//			@Override
//			public void run() {
//				Looper.prepare();
//				ToolAlert.showCustomShortToast("程序有点小任性,重新打开试试!");
//				Looper.loop();
//			}
//		});

		new Thread() {
			@Override
			public void run() {
				Looper.prepare();
				ToolAlert.showCustomShortToast("程序崩溃了, 重新打开试试！");
				Looper.loop();
			}
		}.start();

		return true;
	}

//
//
//	/**
//	 * 保存异常日志
//	 *
//	 * @param ex
//	 */
//	public void saveErrorLog(Throwable ex) {
//		String errorlog = "";
//		String savePath = "";
//		String logFilePath = "";
//		FileWriter fw = null;
//		PrintWriter pw = null;
//		try {
//			// 判断是否挂载了SD卡
//			String storageState = Environment.getExternalStorageState();
//			if (storageState.equals(Environment.MEDIA_MOUNTED)) {
//				savePath = ConstantManager.logPath;
//				File file = new File(savePath);
//				if (!file.exists()) {
//					file.mkdirs();
//				}
//
//				errorlog = "errorlog "
//						+ ToolDateTime.getdateTime()
//						+ ".txt";
//				logFilePath = savePath + errorlog;
//			}
//			// 没有挂载SD卡, 无法写文件
//			if (logFilePath == "") {
//				return;
//			}
//			File logFile = new File(logFilePath);
//			if (!logFile.exists()) {
//				logFile.createNewFile();
//			}
//			fw = new FileWriter(logFile, true);
//			pw = new PrintWriter(fw);
//			ex.printStackTrace(pw);
//
//			pw.close();
//			fw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (pw != null) {
//				pw.close();
//			}
//			if (fw != null) {
//				try {
//					fw.close();
//				} catch (IOException e) {
//				}
//			}
//		}
//
//	}
//
//	/**
//	 * 保存设备信息
//	 *
//	 * @param
//	 */
//	public void saveDeviceInfo() {
//		String errorlog = "";
//		String savePath = "";
//		String logFilePath = "";
//		FileWriter fw = null;
//		PrintWriter pw = null;
//		try {
//			// 判断是否挂载了SD卡
//			String storageState = Environment.getExternalStorageState();
//			if (storageState.equals(Environment.MEDIA_MOUNTED)) {
//				savePath = ConstantManager.logPath;
//				File file = new File(savePath);
//				if (!file.exists()) {
//					file.mkdirs();
//				}
//
//				errorlog = "deviceInfo "
//						+ ToolDateTime.getdateTime()
//						+ ".txt";
//				logFilePath = savePath + errorlog;
//			}
//			// 没有挂载SD卡, 无法写文件
//			if (logFilePath == "") {
//				return;
//			}
//			File logFile = new File(logFilePath);
//			if (!logFile.exists()) {
//				logFile.createNewFile();
//			}
//			fw = new FileWriter(logFile, true);
//			pw = new PrintWriter(fw);
//
//			// 版本号
//			PackageManager pm = mContext.getPackageManager();
//			PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(),
//					PackageManager.GET_ACTIVITIES);
//			if (pi != null) {
//				pw.println(VERSION_NAME + "=" + pi.versionName == null ? "not set"
//						: pi.versionName);
//				pw.println(VERSION_CODE + "=" + pi.versionCode);
//			}
//			// 使用反射来收集设备信息.在Build类中包含各种设备信息,
//			// 例如: 系统版本号,设备生产商 等帮助调试程序的有用信息
//			Field[] fields = Build.class.getDeclaredFields();
//			for (Field field : fields) {
//				field.setAccessible(true);
//				pw.println(field.getName() + "=" + field.get(null));
//			}
//
//			pw.close();
//			fw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (pw != null) {
//				pw.close();
//			}
//			if (fw != null) {
//				try {
//					fw.close();
//				} catch (IOException e) {
//				}
//			}
//		}
//
//	}
//
//	/**
//	 * 清空错误日志缓存目录
//	 */
//	public void clearSavePathFile() {
//		File file = new File(ConstantManager.logPath);
//		ToolFile.deleteFileOrDir(file);
//	}
}