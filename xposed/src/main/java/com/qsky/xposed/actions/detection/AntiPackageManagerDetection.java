package com.qsky.xposed.actions.detection;

import android.content.pm.PackageManager;

import com.qsky.core.logger.Logger;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class AntiPackageManagerDetection
{
	private static final String TAG = "Anti_Detection_Package_Manager";
	
	private static final String PACKAGE_NAME = "com.rebel.sky";
	
	public static void start()
	{
		XposedHelpers.findAndHookMethod
		(
			PackageManager.class, 
			"getPackageGids",
		    new XC_MethodHook()
		    {
				@Override
                protected void beforeHookedMethod(MethodHookParam methodHookParam) throws Throwable
			    {
				    String packageName = (String) methodHookParam.args[0];
				    if (packageName.equals(PACKAGE_NAME))
				    {
					    methodHookParam.setResult(null);
					    methodHookParam.setThrowable
						(
							new PackageManager.NameNotFoundException(packageName)
						);
					    Logger.i(TAG, "检测到了对于QSky的针对于PackageManager的检测，尝试欺骗...");
				    }
			    }	
		    }
		);
	}
}