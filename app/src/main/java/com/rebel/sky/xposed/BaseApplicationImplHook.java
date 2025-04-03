package com.rebel.sky;

import android.app.Application;
import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

import com.rebel.sky.annotation.ClassInformation;

@ClassInformation
(
	author = "Sky-Rebel",
	contributor = {},
    date = "2025.03.29",
    introduction = "Hook关键方法以得到一些必要实例"
)
public class BaseApplicationImplHook
{
	private static final String TARGET_FUNCTION = "onCreate";
	private static final String TARGET_CLASS = ".BaseApplicationImpl";
	private static final String TARGET_PACKAGE = "com.tencent.common.app";
	private static final String TARGET_FULLY_QUALIDIED_NAME = TARGET_PACKAGE + TARGET_CLASS;
	
    protected static void init()
	{
        XC_MethodHook hookMethod = new XC_MethodHook()
	    {
            @Override
            protected void afterHookedMethod(MethodHookParam methosHookParam) throws Throwable
			{
				HookEnvironInfo.appContext = (Context) methosHookParam.thisObject;
				HookEnvironInfo.application = (Application) methosHookParam.thisObject;
				HookEnvironInfo.appRuntime = XposedHelpers.callMethod(HookEnvironInfo.application, "getRuntime");
				HookEnvironInfo.mobileQQ = XposedHelpers.callMethod(HookEnvironInfo.appRuntime, "getApplication");
			}	
		};
		XposedHelpers.findAndHookMethod(TARGET_FULLY_QUALIDIED_NAME, HookEnvironInfo.appClassLoader, TARGET_FUNCTION, hookMethod);
	}		
}
