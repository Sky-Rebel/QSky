package com.qsky.xposed;

import android.app.Application;
import android.content.Context;

public class HookEnv
{
	public static ClassLoader appClassLoader;
	
	public static Object mobileQQ;
	
	public static Object appRuntime;
	
	public static Context appContext;
	
	public static Application application;
	
	public static String appDataPath;
	
	public static String moduleDataPath;
	
	public static String versionName;
	
	public static String versionCode;
}