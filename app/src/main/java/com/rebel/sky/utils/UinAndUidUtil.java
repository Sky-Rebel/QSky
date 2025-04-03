package com.rebel.sky.utils;

import com.rebel.sky.helper.ClassHelper;
import com.rebel.sky.log.Logger;
import de.robv.android.xposed.XposedHelpers;

public class UinAndUidUtil
{
	private static final String TAG = "NTQQ_Uin_And_Uid_Api";
	
	private static Object relationNTUinAndUidApiImpl;
	
	public static void init()
	{
		Class<?> loadClass = ClassHelper.loadClass("com.tencent.relation.common.api.impl.RelationNTUinAndUidApiImpl");
		if (loadClass == null)
		    return;
		else
		    relationNTUinAndUidApiImpl = loadClass;
	}
	
	public static String getUinFromUid(String uid)
	{
		return (String) XposedHelpers.callMethod(relationNTUinAndUidApiImpl, "getUinFromUid", uid);
	}
	
	public static String getUidFromUin(String uin)
	{
		return (String) XposedHelpers.callMethod(relationNTUinAndUidApiImpl, "getUidFromUin", uin);
	}
}
