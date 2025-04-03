package com.rebel.sky.helper;

import com.rebel.sky.HookEnvironInfo;
import com.rebel.sky.annotation.ClassInformation;
import com.rebel.sky.log.Logger;
import de.robv.android.xposed.XposedHelpers;
import java.util.HashMap;

@ClassInformation
(
	author = "Sky-Rebel",
    contributor = {},
    date = "2025.04.03",
    introduction = "为反射类提供帮助."
)

public class ClassHelper
{
	public static final String TAG = "Class_Helper";
	
	//反射类缓存机制，可节约性能
	private static HashMap<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	
	public static Class<?> loadClass(String clazz)
	{
		try
		{
			if (HookEnvironInfo.appClassLoader == null)
			{
			    return null;
			}
			Class<?> classFromMap = classMap.get(clazz);
			if (!(classFromMap == null))
			{
			    return classFromMap;
			}		
			Class<?> classFromLoad = HookEnvironInfo.appClassLoader.loadClass(clazz);
			classMap.put(clazz, classFromLoad);
			return classFromLoad;
		}
		catch (ClassNotFoundException exception)
		{
			Logger.e(TAG, "类失其踪 ->" + clazz, exception);
			return null;
		}	
	}
}
