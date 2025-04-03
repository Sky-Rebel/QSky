package com.rebel.sky.friend.impl;

import com.rebel.sky.helper.FieldHelper;
import com.rebel.sky.HookEnvironInfo;
import com.rebel.sky.annotation.ClassInformation;

import com.rebel.sky.friend.IFriendDataService;
import com.rebel.sky.data.FriendInfo;
import com.rebel.sky.log.Logger;
import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

@ClassInformation
(
	author = "Sky-Rebel",
    date = "2025.03.14",
    version = "1.0.1",
    introduction = "好友数据服务实现"
)
public class FriendDataServiceImpl implements IFriendDataService
{
	private static final String TAG = "API_Friend";
	
	public static boolean isInitFinished;
	
    private static Class appRuntimeClass;
	
    private static Method getServiceMethod;
	
	private static Class friendDataServiceImplClass;
	
	private static Object friendDataServiceImplObject;
	
	protected void init()
	{
		try
		{
			appRuntimeClass = HookEnvironInfo.appClassLoader.loadClass("mqq.app.AppRuntime");
		    friendDataServiceImplClass = HookEnvironInfo.appClassLoader.loadClass("com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl");
			getServiceMethod = friendDataServiceImplClass.getMethod("getService", appRuntimeClass);
			friendDataServiceImplObject = getServiceMethod.invoke(friendDataServiceImplObject, HookEnvironInfo.appRuntime);
			return;
		}
		catch (ClassNotFoundException exception)
		{
			Logger.e(TAG, "类失其踪", exception);
			return;
		}	
		catch (NoSuchMethodException exception)
		{
			Logger.e(TAG, "法无可循", exception);
			return;
		}
		catch (IllegalAccessException exception)
		{
			Logger.e(TAG, "触法无门", exception);
			return;
		}
		catch (InvocationTargetException exception)
		{
			Logger.e(TAG, "法中生变", exception.getTargetException());
			return;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "乾坤大乱", throwable);
			return;
		}
	}

    @Override
	public int getFriendCount()
	{
		try
		{
		    return (int) XposedHelpers.callMethod(friendDataServiceImplObject, "getFriendCount");
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "Friend_Count", throwable);
			return -1;
		}	
	}

	@Override
	public boolean isFriend(String uin)
	{
		return false;
	}
	

	@Override
	public List<FriendInfo> getFriendInfoList()
	{
		return null;
	}
	

	@Override
	public FriendInfo deleteFriend(String targetUin)
	{
		return null;
	}
	

	@Override
	public FriendInfo getFriendInfo(String targetUin)
	{
		try
		{
            Object friends = XposedHelpers.callMethod(friendDataServiceImplObject, "getFriend", targetUin);
            FriendInfo friendInfo = new FriendInfo();
            for (Field field : friends.getClass().getDeclaredFields())
			{
				//跳过Final字段
				if (Modifier.isFinal(field.getModifiers())) continue;
                String fieldName = field.getName();
				//跳过非Final但无用字段
				if (fieldName.equals("MULTI_FLAGS_MASK_SHIELD") || fieldName.equals("MULTI_FLAGS_MASK_OLYMPICTORCH")) continue;
                try
				{
                    Field friendInfoField = FriendInfo.class.getDeclaredField(fieldName);
                    Class<?> fieldType = friendInfoField.getType();
                    Object value = FieldHelper.getFieldValue(friends.getClass(), fieldName, fieldType);
                    friendInfoField.setAccessible(true);
                    friendInfoField.set(friendInfo, value);
                }
				catch (NoSuchFieldException exception)
				{
                    Logger.e(TAG, "不存在的类成员 ->" + fieldName, exception);
                }
				catch (IllegalAccessException exception)
				{
                    Logger.e(TAG, "类成员赋值错误 ->" + fieldName, exception);
                }
            }
            return friendInfo;
        }
		catch (Exception exception)
		{
            Logger.e(TAG, "好友信息获取异常", exception);
            return null;
        }
	}
	

	@Override
	public FriendInfo getFriendInfoFromCache(String targetUin)
	{
		return null;
	}
	

	@Override
	public FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase)
	{
		return null;
	}
	

	@Override
	public FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase, boolean isSkipCacheCheck)
	{
		return null;
	}
	

	@Override
	public FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase, boolean isSkipCacheCheck, boolean isAutoCreateObject)
	{
		return null;
	}
}