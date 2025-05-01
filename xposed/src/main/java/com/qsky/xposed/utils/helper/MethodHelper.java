package com.qsky.xposed.utils.helpers;

import com.qsky.core.logger.Logger;

import java.lang.reflect.Method;

public class MethodHelper
{
	public static final String TAG = "Reflect_Helper_Method";
	
	public static Method findMethod(Class<?> findClass, String findName, Class<?>[] findParameters, Class<?> findReturn)
	{
		try
		{
		    Method[] findMethods = findClass.getDeclaredMethods();
			if (findMethods == null || findMethods.length == 0)
			    return null;
			for (Method method : findMethods)
			{
				String methodName = method.getName();
				Class<?> methodReturn = method.getReturnType();
				Class<?>[] methodParameters = method.getParameterTypes();
				if (!methodName.equals(findName))
				    continue;
				if (!methodReturn.equals(findReturn))
				    continue;
				for (int i = 0 ; i < findParameters.length ; i++)
					if (!methodParameters[i].getClass().equals(findParameters[i].getClass()))
						continue;
				return method;
			}
			return null;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findMethod :0 ->", throwable);
			return null;
		}
    }
	
	public static Method findMethod(Class<?> findClass, Class<?>[] findParameters, Class<?> findReturn)
	{
		try
		{
		    Method[] findMethods = findClass.getDeclaredMethods();
			if (findMethods == null || findMethods.length == 0)
			    return null;
			for (Method method : findMethods)
			{
				Class<?> methodReturn = method.getReturnType();
				Class<?>[] methodParameters = method.getParameterTypes();
				if (!methodReturn.equals(findReturn))
				    continue;
				for (int i = 0 ; i < findParameters.length ; i++)
					if (!methodParameters[i].getClass().equals(findParameters[i].getClass()))
						continue;
				return method;
			}
			return null;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findMethod :1 ->", throwable);
			return null;
		}
    }
	
	public static Method findMethod(Class<?> findClass, String findName, Class<?>[] findParameters)
	{
		try
		{
		    Method[] findMethods = findClass.getDeclaredMethods();
			if (findMethods == null || findMethods.length == 0)
			    return null;
			for (Method method : findMethods)
			{
				String methodName = method.getName();
				Class<?>[] methodParameters = method.getParameterTypes();
				if (!methodName.equals(findName))
				    continue;
				if (method.getParameterCount() ==  findParameters.length)
				{
				    for (int i = 0 ; i < findParameters.length ; ++i)
				    {
					    if (!findParameters[i].equals(methodParameters[i]))
						    continue;
				    }
				}		
				return method;
			}
			return null;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findMethod :2 ->", throwable);
			return null;
		}
    }
	
	public static Method findMethod(Class<?> findClass, String findName)
	{
		try
		{
		    Method[] findMethods = findClass.getDeclaredMethods();
			if (findMethods == null || findMethods.length == 0)
			    return null;
			for (Method method : findMethods)
			{
				String methodName = method.getName();
				Class<?>[] methodParameters = method.getParameterTypes();
				if (methodName.equals(findName))
				    return method;
			}
			return null;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findMethod :3 ->", throwable);
			return null;
		}
    }
	
	public static Method findMethod(Class<?> findClass, Class<?>[] findParameters)
	{
		try
		{
		    Method[] findMethods = findClass.getDeclaredMethods();
			if (findMethods == null || findMethods.length == 0)
			    return null;
			for (Method method : findMethods)
			{
				Class<?>[] methodParameters = method.getParameterTypes();
				for (int i = 0 ; i < findParameters.length ; i++)
					if (!methodParameters[i].getClass().equals(findParameters[i].getClass()))
						continue;
				return method;
			}
			return null;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "findMethod :4 ->", throwable);
			return null;
		}
    }
	
	public static Object invokeMethod(Method invokeMethod, Object invokeObject, Object[] invokeParameters)
	{
		try
		{
		    return invokeMethod.invoke(invokeObject, invokeParameters);
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "invokeMethod :0 ->", throwable);
			return null;
		}
	}
	
	public static Object invokeMethod(Method invokeMethod, Object[] invokeParameters)
	{
		try
		{
		    return invokeMethod.invoke(null, invokeParameters);
		}
		catch (Throwable throwable)
		{
		
			Logger.e(TAG, "invokeMethod :1 ->", throwable);
			return null;
		}
	}
	
	public static Object invokeMethod(Method invokeMethod, Object invokeObject)
	{
		try
		{
		    return invokeMethod.invoke(invokeObject);
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "invokeMethod :2 ->", throwable);
			return null;
		}
	}
}