package com.qsky.xposed.api.troopl.impl;

import com.qsky.core.annotation.HookMethod;
import com.qsky.core.data.TroopInfo;
import com.qsky.core.logger.Logger;
import com.qsky.xposed.api.troopl.ITroopListDataService;
import com.qsky.xposed.utils.helpers.ClassHelper;

import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TroopListDataServiceImpl implements ITroopListDataService
{
	private static final String TAG = "QSky_Core_API_Troop_List_Repo_Api_Impl";
	
	private static Object troopListRepoApiImpl;

    public void init()
	{
		try
		{
		    Class<?> qRoute = ClassHelper.loadClass("com.tencent.mobileqq.qroute.QRoute");
		    if (qRoute == null) Logger.w(TAG, "类无所踪 -> QRoute");
		    Class<?> clazz = ClassHelper.loadClass("com.tencent.qqnt.troop.ITroopListRepoApi");
		    if (clazz == null) Logger.w(TAG, "类无所踪 -> TroopListRepoApiImpl");
		    troopListRepoApiImpl = XposedHelpers.callStaticMethod(qRoute, "api", clazz);
		    if (troopListRepoApiImpl == null) Logger.w(TAG, "不可得之实例 -> TroopListRepoApiImpl");
		    return;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "init ->", throwable);
			return;
		}	
	}
	
	@Override
	@HookMethod(introduction = "拉取群聊列表(增加心理作用)")
	public void fetchTroopList()
	{
		try
		{
			XposedHelpers.callMethod(troopListRepoApiImpl, "fetchTroopList", true);
			return;
		}
		catch (Throwable throwable)
		{
			Logger.e(TAG, "fetchTroopList ->", throwable);
			return;
		}
	}
	
    @Override
	@HookMethod(introduction = "获取群聊列表(所有群聊列表)")
	public List<TroopInfo> getTroopInfoList()
	{
		try
		{
		    List troopListFromCache = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getTroopListFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopListFromCache);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getTroopInfoList ->", throwable);
			return null;
		}
	}
	
    @Override
	@HookMethod(introduction = "获取群聊列表(置顶群聊列表)")
    public List<TroopInfo> getTopTroopInfoList()
	{
		try
		{
		    List troopList = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getTopTroopListFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopList);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getSortedJoinedTopTroopInfoList ->", throwable);
			return null;
		}
	}
	
    @Override
	@HookMethod(introduction = "获取群聊列表(已加入的群聊列表)")
    public List<TroopInfo> getJoinedTroopInfoList()
	{
		try
		{
		    List troopList = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getJoinedTroopInfoFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopList);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getJoinedTroopInfoList ->", throwable);
			return null;
		}
	}

    @Override
	@HookMethod(introduction = "获取群聊列表(排序后的已加入的群聊列表)")
    public List<TroopInfo> getSortedJoinedTroopInfoList()
	{
		try
		{
		    List troopList = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getSortedJoinedTroopInfoFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopList);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getSortedJoinedTroopInfoList ->", throwable);
			return null;
		}
	}

    @Override
	@HookMethod(introduction = "获取群聊列表(排序后的已加入的是置顶的群聊列表)")
    public List<TroopInfo> getSortedJoinedTopTroopInfoList()
	{
		try
		{
		    List troopList = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getSortedJoinedTopTroopListFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopList);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getJoinedTopTroopInfoList ->", throwable);
			return null;
		}
	}

    

    @Override
	@HookMethod(introduction = "获取群聊列表(有效的排序后的已加入的群聊列表)")
    public List<TroopInfo> getSortedJoinedValidTroopInfoList()
	{
		try
		{
		    List troopList = (List) XposedHelpers.callMethod(troopListRepoApiImpl, "getSortedJoinedValidTroopInfoFromCache");
			return fromRemoteTroopInfoListToLocalTroopInfoList(troopList);
		}	
		catch (Throwable throwable)
		{
			Logger.e(TAG, "getSortedJoinedValidTroopInfoList ->", throwable);
			return null;
		}
	}

	private static List<TroopInfo> fromRemoteTroopInfoListToLocalTroopInfoList(List troopInfoList)
	{
		if (troopInfoList == null || troopInfoList.isEmpty()) return new ArrayList<TroopInfo>();
		List<TroopInfo> localTroopInfoList = new ArrayList<TroopInfo>();
		for (Object remoteTroopInfo : troopInfoList)
		{
			TroopInfo localTroopInfo = fromRemoteTroopInfoToLocalTroopInfo(remoteTroopInfo);
			if (localTroopInfo != null)
			{
			    localTroopInfoList.add(localTroopInfo);
			}	
		}	
		return localTroopInfoList;
	}
	
    private static TroopInfo fromRemoteTroopInfoToLocalTroopInfo(Object remoteTroopInfo)
	{
        try
		{
            TroopInfo localTroopInfo = new TroopInfo();
            for (Field remoteTroopInfoField : remoteTroopInfo.getClass().getFields())
			{
                if (Modifier.isFinal(remoteTroopInfoField.getModifiers())) continue;
                String remoteTroopInfofieldName = remoteTroopInfoField.getName();
                if (remoteTroopInfofieldName.equals("e")
                    || remoteTroopInfofieldName.equals("extDBInfo")
                        || remoteTroopInfofieldName.equals("groupExt")
                            || remoteTroopInfofieldName.equals("groupGameList")
                                || remoteTroopInfofieldName.equals("groupPermissions")
                                || remoteTroopInfofieldName.equals("groupStatus")
                            || remoteTroopInfofieldName.equals("memberRole")
                        || remoteTroopInfofieldName.equals("troopmask")
                    || remoteTroopInfofieldName.equals("mTroopPicList"))
			    continue;
				try
				{
                    Field localTroopInfoField = localTroopInfo.getClass().getField(remoteTroopInfofieldName);
                    Object remoteTroopInfoFieldValue = remoteTroopInfoField.get(remoteTroopInfo);
                    localTroopInfoField.set(localTroopInfo, remoteTroopInfoFieldValue);
			    }
				catch (NoSuchFieldException exception)
				{
					Logger.e(TAG, "不可寻之字段 ->", exception);
					continue;
				}
				catch (IllegalAccessException exception)
				{
					Logger.e(TAG, "无法访问字段 ->", exception);
					continue;
				}
				catch (IllegalArgumentException exception)
				{
					Logger.e(TAG, "字段类型异同 ->", exception);
					continue;
				}
				catch (NullPointerException exception)
				{
					Logger.e(TAG, "空指针的字段 ->", exception);
					continue;
				}
				catch (SecurityException exception)
				{
					Logger.e(TAG, "不可访问字段 ->", exception);
					continue;
				}
            }
            return localTroopInfo;
        }
		catch (Throwable throwable)
		{
			Logger.e(TAG, "fromRemoteTroopInfoToLocalTroopInfo ->", throwable);
			return null;
        }
    }
}