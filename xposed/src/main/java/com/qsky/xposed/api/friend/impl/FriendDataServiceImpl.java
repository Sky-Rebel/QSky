package com.qsky.xposed.api.friend.impl;

import com.qsky.core.data.FriendInfo;
import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;
import com.qsky.xposed.api.friend.IFriendDataService;

import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FriendDataServiceImpl implements IFriendDataService
{
	private static final String TAG = "API_Friend";
	
	public static boolean isInited = false;
	
    private static Class appRuntimeClass;
	
    private static Method getServiceMethod;
	
	private static Class friendDataServiceImplClass;
	
	private static Object friendDataServiceImplObject;
	
	private void init()
	{
		try
		{
			appRuntimeClass = HookEnv.appClassLoader.loadClass("mqq.app.AppRuntime");
		    friendDataServiceImplClass = HookEnv.appClassLoader.loadClass("com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl");
			getServiceMethod = friendDataServiceImplClass.getMethod("getService", appRuntimeClass);
			friendDataServiceImplObject = getServiceMethod.invoke(friendDataServiceImplObject, HookEnv.appRuntime);
			isInited = true;
			return;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "init ->", throwable);
			isInited = false;
			return;
		}
	}
	
	public FriendDataServiceImpl()
	{
		this.init();
		return;
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
			Logger.e(TAG, "getFriendCount ->", throwable);
			return -1;
		}	
	}

	@Override
	public boolean isFriend(String uin)
	{
		try
		{
			return (boolean) XposedHelpers.callMethod(friendDataServiceImplObject, "isFriend", uin);
		}
		catch(Throwable throwable)
		{
			Logger.e(TAG, "isFriend ->", throwable);
		}
		return false;
	}
	
	@Override
	public List<FriendInfo> getFriendInfoList()
	{
		try
		{
			List friendList = (List) XposedHelpers.callMethod(friendDataServiceImplObject, "getAllFriends", true);
			return fromRemoteFriendInfoListToLocalFriendInfoList(friendList);
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getFriendInfoList ->", throwable);
			return null;
		}
	}
	
	@Override
	public FriendInfo getFriendInfo(String uin)
	{
		try
		{
			Object friendInfo = XposedHelpers.callMethod(friendDataServiceImplObject, "getFriend", uin, true);
			return fromRemoteFriendInfoToLocalFriendInfo(friendInfo);
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getFriendInfo ->", throwable);
			return null;
		}
	}
	
	private static List<FriendInfo> fromRemoteFriendInfoListToLocalFriendInfoList(List friendInfoList)
	{
		if (friendInfoList == null || friendInfoList.isEmpty()) return new ArrayList<FriendInfo>();
		List<FriendInfo> localFriendInfoList = new ArrayList<FriendInfo>();
		for (Object remoteFriendInfo : localFriendInfoList)
		{
			FriendInfo localFriendInfo = fromRemoteFriendInfoToLocalFriendInfo(remoteFriendInfo);
			if (localFriendInfo != null)
			{
			    localFriendInfoList.add(localFriendInfo);
			}	
		}	
		return localFriendInfoList;
	}
	
	private static FriendInfo fromRemoteFriendInfoToLocalFriendInfo(Object remoteFriendInfo)
	{
        try
		{
            FriendInfo localFriendInfo = new FriendInfo();
            for (Field remoteFriendInfoField : remoteFriendInfo.getClass().getFields())
			{
                if (Modifier.isFinal(remoteFriendInfoField.getModifiers())) continue;
                if (remoteFriendInfoField.getName().equals("MULTI_FLAGS_MASK_OLYMPICTORCH") || remoteFriendInfoField.getName().equals("MULTI_FLAGS_MASK_SHIELD")) continue;
				try
				{
                    Field localFriendInfoField = localFriendInfo.getClass().getField(remoteFriendInfoField.getName());
                    Object remoteFriendInfoFieldValue = remoteFriendInfoField.get(remoteFriendInfo);
                    localFriendInfoField.set(localFriendInfo, remoteFriendInfoFieldValue);
			    }
				catch (Exception exception)
				{
					Logger.e(TAG, "Set Field Value Exception", exception);
				}
            }
            return localFriendInfo;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "fromRemoteFriendInfoToLocalFriendInfo ->", throwable);
			return null;
        }
    }
}