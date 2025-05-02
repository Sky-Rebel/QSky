package com.qsky.core.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger
{
	private static final String TAG = "QSky_Logger";
	
	private static boolean stackTrace = false;
	
	private static final int LOG_LINE = 2;
	
	private static final String LOG_FILE_NAME = "logger.log";
	
	private static final String LOG_DATA_DIR_PATH = "/storage/emulated/0/QSky/";
	
	private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();
	
	private Logger() { }
	
	public static void startStackTrace()
	{
		stackTrace = true;
	}
	
	public static void closeStackTrace()
	{
        stackTrace = false;
	}
	
	public static void v(String tag, String verbose)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " VERBOSE-> " + "[" + tag + "] " + verbose;
		writeLogToFile(content);
    }
	
	public static void d(String tag, String dobug)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " DEBUG-> " + "[" + tag + "] " + dobug;
		writeLogToFile(content);
    }
	
    public static void i(String info)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " INFO-> " + info;
		writeLogToFile(content);
    }
	
	public static void i(String tag, String info)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " INFO-> " + "[" + tag + "] " + info;
		writeLogToFile(content);
    }

	public static void w(String tag, String info)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " WARN-> " + "[" + tag + "] " + info;
		writeLogToFile(content);
    }
	
	public static void e(String tag, String error)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + error;
		writeLogToFile(content);
    }
	
	public static void e(String tag, Throwable throwable)
	{
		if (stackTrace)
		{
			StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
		    if (stackTraceElementArray == null || stackTraceElementArray.length == 0) return;
		    StringBuilder stackTrace = new StringBuilder();
		    for (StackTraceElement stackTraceElement : stackTraceElementArray)
		    {
			    stackTrace.append("\n");
			    stackTrace.append(stackTraceElement.getClassName());
			    stackTrace.append(".");
			    stackTrace.append(stackTraceElement.getMethodName());
			    stackTrace.append("(");
			    stackTrace.append(stackTraceElement.getFileName());
			    stackTrace.append(":");
			    stackTrace.append(")");
			    stackTrace.append(stackTraceElement.getLineNumber());
		    }
		    String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + throwable +
                             stackTrace;
		    writeLogToFile(content);
        }
		else
		{
		    String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + throwable;
		    writeLogToFile(content);
        }
	}
	
	public static void e(String tag, String info, String error)
	{
		String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + info + " " + error;
		writeLogToFile(content);
    }
	
	public static void e(String tag, String info, Throwable throwable)
	{
		if (stackTrace)
		{
			StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
		    if (stackTraceElementArray == null || stackTraceElementArray.length == 0) return;
		    StringBuilder stackTrace = new StringBuilder();
		    for (StackTraceElement stackTraceElement : stackTraceElementArray)
		    {
			    stackTrace.append("\n");
			    stackTrace.append(stackTraceElement.getClassName());
			    stackTrace.append(".");
			    stackTrace.append(stackTraceElement.getMethodName());
			    stackTrace.append("(");
			    stackTrace.append(stackTraceElement.getFileName());
			    stackTrace.append(":");
			    stackTrace.append(")");
			    stackTrace.append(stackTraceElement.getLineNumber());
		    }
		    String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + info + " " + throwable +
                             stackTrace;
		    writeLogToFile(content);
        }
		else
		{
		    String content = (new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss.SSS]").format(new Date())) + " ERROR-> " + "[" + tag + "] " + info + " " + throwable;
		    writeLogToFile(content);
        }
	}
	
	public static void deleteLogFile()
	{
		File file = new File(LOG_DATA_DIR_PATH, LOG_FILE_NAME);
		if (file.exists())
		    file.delete();
		d(TAG, "deleteLogFile");
    }
	
	private static void writeLogToFile(String content)
	{
		EXECUTOR_SERVICE.submit
		(() ->
			{
				File logDir = new File(LOG_DATA_DIR_PATH);
				if (!logDir.exists() && !logDir.mkdirs())
				{
					return;
				}
				File logFile = new File(logDir, LOG_FILE_NAME);
				try
				(
				    FileWriter writer = new FileWriter(logFile, true);
				    BufferedWriter bufferedWriter = new BufferedWriter(writer)
                )
				{
				    bufferedWriter.write(content);
					for(int i = 0 ; i < LOG_LINE; i++)
					{
						bufferedWriter.newLine();
					}
				}
			    catch (IOException exception)
				{
                }
			}
		);
	}
}