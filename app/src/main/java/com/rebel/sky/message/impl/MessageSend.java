package com.rebel.sky.message;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.rebel.sky.HookEnvironInfo;
import com.rebel.sky.log.Logger;
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
			Logger.i("000");
		
		return sendTextMsg(HookEnvironInfo.appRuntime, HookEnvironInfo.appContext, parcel, text, new ArrayList(), null);
	}
	
	private static long[] sendTextMsg(Object appRuntime, Context context, Parcel sessionInfo, String msg, ArrayList<?> atList, Object param)
	{
		Logger.i("111");
		Class<?> chatActivityFacade = XposedHelpers.findClass("com.tencent.mobileqq.activity.ChatActivityFacade", HookEnvironInfo.appClassLoader);
			Logger.i("222");
		for (Method method : chatActivityFacade.getDeclaredMethods())
		{
			if (!method.getReturnType().equals(long[].class)) continue;
			Logger.i("a111");
			if (method.getParameterCount() != 6) continue;
			Logger.i("a222");
			Class<?>[] params = method.getParameterTypes();
			Logger.i("a333");
			if (params[1].equals(Context.class) && params[3].equals(String.class) && params[4].equals(ArrayList.class))
			{
				Logger.i("333");
				try
				{
				    param = params[5].newInstance();
						Logger.i("444");
				    method.setAccessible(true);
						Logger.i("555");
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
