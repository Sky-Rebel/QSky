package com.qsky.xposed.actions.loading;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;
import com.qsky.xposed.event.server.RobotOnOffLineEvent;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class BaseApplicationHook
{
	private static final String TAG = "Hook_BaseApplication";
	
	private static final String TARGET_METHOD = "onCreate";
	
	private static final String TARGET_CLASS = ".BaseApplication";
	
	private static final String TARGET_PACKAGE = "com.tencent.mobileqq.mqsafeedit";
	
	private static final String TARGET_FULLY_QUALIDIED_NAME = TARGET_PACKAGE + TARGET_CLASS;
	
    public static void hookOnCreate()
	{
		XposedHelpers.findAndHookMethod
		(
			TARGET_FULLY_QUALIDIED_NAME, 
            HookEnv.appClassLoader, 
			TARGET_METHOD, 
			new XC_MethodHook()
			{
                @Override
                protected void afterHookedMethod(MethodHookParam methodHookParam) throws Throwable
			    {
				    Logger.d(TAG, "BaseApplicationHook.hookOnCreate");
				    HookEnv.appContext = (Context) methodHookParam.thisObject;
				    HookEnv.application = (Application) methodHookParam.thisObject;
				    HookEnv.appRuntime = XposedHelpers.callMethod(HookEnv.application, "getRuntime");
				    HookEnv.mobileQQ = XposedHelpers.callMethod(HookEnv.appRuntime, "getApplication");
			    }	
		    }
		);
		new Handler(Looper.getMainLooper()).post(()->{RobotOnOffLineEvent.onOnline();});
	}		
}