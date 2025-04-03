package com.rebel.sky;

import android.app.Application;
import android.content.Context;

public class HookEnvironInfo
{
	public static ClassLoader appClassLoader;
	
	public static Object mobileQQ;
	public static Object appRuntime;
	public static Context appContext;
	public static Application application;
	
	public static String appDataPath;
	public static String selfDataPath;
	public static String selfName;
}
