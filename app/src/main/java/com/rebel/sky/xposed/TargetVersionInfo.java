package com.rebel.sky;

import de.robv.android.xposed.XposedHelpers;

import com.rebel.sky.annotation.HookMethod;
import com.rebel.sky.annotation.ClassInformation;

/* ------------------->
 * 人生若只如初见，何事秋风悲画扇。
 * If life could stay as when we first met,
 * Why would the autumn wind grieve the painted fan?
 * <------------------- */

@ClassInformation
(
	author = "Sky-Rebel",
    date = "2025",
    version = "1.0.1",
    introduction = "获取目标的版本信息"
)
public class TargetVersionInfo
{
	private static final String TARGET_PACKAGE = "com.tencent.common.app";
	private static final String TARGET_CLASS = ".QFixApplicationImpl";
	private static final String[] TARGET_FUNCTION = {"getVersionName", "getVersionCode"};
	private static final String TARGET_FULLY_QUALIDIED_NAME = TARGET_PACKAGE + TARGET_CLASS;
	
	@HookMethod(introduction = "获取版本名字")
    public static String getVersionName()
    {
		Class<?> clazz = XposedHelpers.findClass(TARGET_FULLY_QUALIDIED_NAME, HookEnvironInfo.appClassLoader);
	    String versionName = (String) XposedHelpers.callStaticMethod(clazz, TARGET_FUNCTION[0], HookEnvironInfo.appContext);
        return versionName;
    }
	
	@HookMethod(introduction = "获取版本代码")
    public static int getVersionCode()
    {
		Class<?> clazz = XposedHelpers.findClass(TARGET_PACKAGE + TARGET_CLASS, HookEnvironInfo.appClassLoader);
	    int versionCode = (Integer) XposedHelpers.callStaticMethod(clazz, TARGET_FUNCTION[1], HookEnvironInfo.appContext);
        return versionCode;
    }
}