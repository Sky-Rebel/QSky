package com.qsky.xposed.utils.helpers;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class ClassHelper
{
	public static final String TAG = "Class_Helper";
	
	private static HashMap<String, Class<?>> classCache = new HashMap<String, Class<?>>();
	private static HashMap<String, Object> instanceCache = new HashMap<String, Object>();
	
	public static Class<?> loadClass(String clazz)
	{
		try
		{
			if (HookEnv.appClassLoader == null)
			{
			    return null;
			}
			Class<?> classFromMap = classCache.get(clazz);
			if (!(classFromMap == null))
			{
			    return classFromMap;
			}		
			Class<?> classFromLoad = HookEnv.appClassLoader.loadClass(clazz);
			classCache.put(clazz, classFromLoad);
			return classFromLoad;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "loadClass ->" + clazz, throwable);
			return null;
		}	
	}
	public static Constructor<?> findConstructor(Class<?> findClass)
	{
		try
		{
			return findClass.getConstructor();
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findConstructor :0 ->", throwable);
			return null;
		}
	}
	
	
	public static Constructor<?> findConstructor(Class<?> findClass, Class<?>[] findParameters)
	{
		try
		{
			return findClass.getConstructor(findParameters);
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findConstructor :1 ->", throwable);
			return null;
		}
	}
	
	public static Object newInstance(Constructor<?> constructor)
	{
		try
		{
			Object instanceFromMap = instanceCache.get(constructor.getClass().getName());
			if (!(instanceFromMap == null))
			{
			    return instanceFromMap;
			}		
			Object instanceFromNew = constructor.newInstance();
			instanceCache.put(constructor.getClass().getName(), instanceFromNew);
			return instanceFromNew;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "newInstance :1 ->", throwable);
			return null;
		}	
	}
	
	public static Object newInstance(Constructor<?> constructor, Object[] parameters)
	{
		try
		{
			Object instanceFromMap = instanceCache.get(constructor.getClass().getName());
			if (!(instanceFromMap == null))
			{
			    return instanceFromMap;
			}		
			Object instanceFromNew = constructor.newInstance(parameters);
			instanceCache.put(constructor.getClass().getName(), instanceFromNew);
			return instanceFromNew;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "newInstance :0 ->", throwable);
			return null;
		}	
	}	
}
