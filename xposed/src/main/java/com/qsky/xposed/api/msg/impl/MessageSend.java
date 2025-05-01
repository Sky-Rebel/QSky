package com.qsky.xposed.api.msg.impl;

import android.content.Context;
import android.os.Parcel;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;

import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MessageSend
{
	private static final String TAG = "MessageSend";
	
	public static long[] sendTextMsg(String groupUin, String text, boolean isGroup)
	{
		Parcel parcel = Parcel.obtain();
		parcel.writeInt(isGroup ? 1 : 0);
		parcel.writeString(groupUin);
		parcel.writeString(null);
		parcel.writeString(null);
		parcel.writeInt(3999);
		parcel.writeBundle(null);
		parcel.setDataPosition(0);
		return sendTextMsg(HookEnv.appRuntime, HookEnv.appContext, parcel, text, new ArrayList(), null);
	}
	
	private static long[] sendTextMsg(Object appRuntime, Context context, Parcel sessionInfo, String msg, ArrayList<?> atList, Object param)
	{
		Class<?> chatActivityFacade = XposedHelpers.findClass("com.tencent.mobileqq.activity.ChatActivityFacade", HookEnv.appClassLoader);
		for (Method method : chatActivityFacade.getDeclaredMethods())
		{
			if (!method.getReturnType().equals(long[].class)) continue;
			if (method.getParameterCount() != 6) continue;
			Class<?>[] params = method.getParameterTypes();
			if (params[1].equals(Context.class) && params[3].equals(String.class) && params[4].equals(ArrayList.class))
			{
				try
				{
				    param = params[5].newInstance();
				    method.setAccessible(true);
				    return (long[]) method.invoke(null, appRuntime, context, sessionInfo, msg, atList, param);
						
				}
				catch (InstantiationException exception)
				{
					Logger.e(TAG, "实例创建异常", exception);
					return null;
				}
				catch (IllegalAccessException exception)
				{
					Logger.e(TAG, "非法访问异常", exception);
					return null;
				}
				catch (InvocationTargetException exception)
				{
					Logger.e(TAG, "方法调用异常", exception);
					return null;
				}
			}	
		}
		return null;
	}
}
