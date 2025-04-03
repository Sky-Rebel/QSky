package com.rebel.sky.log;

import com.rebel.sky.annotation.ClassInformation;

import de.robv.android.xposed.XposedBridge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ClassInformation
(
	author = "Sky-Rebel",
    date = "2025.02.23",
    version = "1.0.1",
    introduction = "日志工具"
)
public class Logger
{
	private static final String TAG = "QSky_Logger";
	private static final String LOG_DATA_DIR_PATH = "/storage/emulated/0/QSky/";
	private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();
	
	private Logger()
	{
		return;
	}
	
	public static void v(String tag, String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " VERBOSE-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
	}
	
	public static void d(String tag, String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " DEBUG-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
	}
	
    public static void i(String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " INFO-> " + log;
		writeLogToFile(content);
		return;
    }
	
	public static void i(String tag, String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " INFO-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
    }

	public static void w(String tag, String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " WARN-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
	}
	
	public static void e(String tag, String log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
	}
	
	public static void e(String tag, Throwable log)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + log;
		writeLogToFile(content);
		return;
	}
	
	public static void e(String tag, String log, Throwable throwable)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + log + " " + throwable;
		writeLogToFile(content);
		return;
	}
	
	private static void writeLogToFile(String content)
	{
		EXECUTOR_SERVICE.submit
		(() ->
			{
				File logDir = new File(LOG_DATA_DIR_PATH);
				if (!logDir.exists() && !logDir.mkdirs())
				{
					XposedBridge.log(TAG + "-> Failed to Creating Log Directory.");
					return;
				}
				File logFile = new File(logDir, "log.txt");
				try
				(
				    FileWriter writer = new FileWriter(logFile, true);
				    BufferedWriter bufferedWriter = new BufferedWriter(writer);
				)
				{
				    bufferedWriter.write(content);
					bufferedWriter.newLine();
				}
			    catch (IOException exception)
			    {
					XposedBridge.log(TAG + "-> " + exception);
					return;
			    }
			}
		);
	}
}