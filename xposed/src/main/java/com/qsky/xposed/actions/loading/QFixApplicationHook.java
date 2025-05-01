package com.qsky.xposed.actions.loading;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class QFixApplicationHook
{
	private static final String TAG = "Hook_QFixApplicationImpl";
	
	private static final String TARGET_METHOD = "onCreate";
	
	private static final String TARGET_CLASS = ".QFixApplication";
	
	private static final String TARGET_PACKAGE = "com.tencent.mobileqq.qfix";
	
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
				    Logger.d(TAG, "QFixApplicationImplHook.hookOnCreate");
					HookEnv.appClassLoader = methodHookParam.thisObject.getClass().getClassLoader();
			    }
		    }
		);
	}		
}
