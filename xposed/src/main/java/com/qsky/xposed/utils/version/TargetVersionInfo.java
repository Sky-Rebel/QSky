package com.qsky.xposed.utils.version;

import android.content.Context;

import com.qsky.core.annotation.HookMethod;
import com.qsky.xposed.HookEnv;
import com.qsky.xposed.utils.helpers.ClassHelper;
import com.qsky.xposed.utils.helpers.MethodHelper;

public class TargetVersionInfo
{
	private static final String TARGET_PACKAGE = "com.tencent.common.app";
	
	private static final String TARGET_CLASS = ".QFixApplicationImpl";
	
	private static final String[] TARGET_METHOD = {"getVersionName", "getVersionCode"};
	
	private static final String TARGET_FULLY_QUALIDIED_NAME = TARGET_PACKAGE + TARGET_CLASS;
	
	@HookMethod(introduction = "获取版本名字")
    public static String getVersionName()
    {
		return (String) MethodHelper.invokeMethod
		(
			MethodHelper.findMethod
            (
			    ClassHelper.loadClass(TARGET_FULLY_QUALIDIED_NAME),
				TARGET_METHOD[1],
				new Class[]
                {
                    Context.class
			    }
			),
			HookEnv.appContext
		);
    }
	
	@HookMethod(introduction = "获取版本代码")
	public static String getVersionCode()
    {
		return (String) MethodHelper.invokeMethod
		(
			MethodHelper.findMethod
            (
			    ClassHelper.loadClass(TARGET_FULLY_QUALIDIED_NAME),
				TARGET_METHOD[1],
				new Class[]
                {
                    Context.class
			    }
			),
			HookEnv.appContext
		);
    }
}