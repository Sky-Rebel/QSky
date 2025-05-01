package com.qsky.xposed.actions.message;

import android.os.Handler;
import android.os.Looper;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.utils.helpers.ClassHelper;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class BaseMessageManagerHook
{
	private static final String TAG = "BaseMessageManagerHook";

    public static void startMessageListening()
	{
		
		new Handler(Looper.getMainLooper()).post
		(()->
		    {
				try
			    {
				    XC_MethodHook hookMethod = new XC_MethodHook()
				    {
					    @Override
                        protected void beforeHookedMethod(MethodHookParam methodHookParam) throws Throwable
					    {
					
						    Logger.i("钩子触发事件");
						    Object messageRecord = methodHookParam.args[0];
                            Logger.i(TAG, "发送者: " + XposedHelpers.getObjectField(messageRecord, "senderuin"));
                            Logger.i(TAG, "接收者: " + XposedHelpers.getObjectField(messageRecord, "selfuin"));
                            Logger.i(TAG, "消息1: " + XposedHelpers.getObjectField(messageRecord, "msg"));
                            Logger.i(TAG, "消息2: " + XposedHelpers.getObjectField(messageRecord, "msg2"));
                            Logger.i(TAG, "消息类型: " + XposedHelpers.getIntField(messageRecord, "msgtype"));
                            Logger.i(TAG, "消息ID: " + XposedHelpers.getLongField(messageRecord, "msgId"));
                            Logger.i(TAG, "消息UID: " + XposedHelpers.getLongField(messageRecord, "msgUid"));
                            Logger.i(TAG, "消息SEQ: " + XposedHelpers.getLongField(messageRecord, "msgseq"));
                            Logger.i(TAG, "extInt: " + XposedHelpers.getIntField(messageRecord, "extInt"));
                            Logger.i(TAG, "extLong: " + XposedHelpers.getLongField(messageRecord, "extLong"));
                            Logger.i(TAG, "extStr: " + XposedHelpers.getObjectField(messageRecord, "extStr"));
                            Logger.i(TAG, "extraflag: " + XposedHelpers.getIntField(messageRecord, "extraflag"));
                            Logger.i(TAG, "isread: " + XposedHelpers.getBooleanField(messageRecord, "isread"));
                            Logger.i(TAG, "issend: " + XposedHelpers.getIntField(messageRecord, "issend"));
                            Logger.i(TAG, "istroop: " + XposedHelpers.getIntField(messageRecord, "istroop"));
                            Logger.i(TAG, "长消息计数: " + XposedHelpers.getIntField(messageRecord, "longMsgCount"));
                            Logger.i(TAG, "长消息ID: " + XposedHelpers.getIntField(messageRecord, "longMsgId"));
                            Logger.i(TAG, "长消息索引: " + XposedHelpers.getIntField(messageRecord, "longMsgIndex"));
                            Logger.i(TAG, "消息数据: " + XposedHelpers.getObjectField(messageRecord, "msgData"));
                            Logger.i(TAG, "时间戳: " + XposedHelpers.getLongField(messageRecord, "time"));
                            Logger.i(TAG, "唯一序列: " + XposedHelpers.getLongField(messageRecord, "uniseq"));
                            Object extObj = XposedHelpers.getObjectField(messageRecord, "extObj");
                            Logger.i(TAG, "extObj类型: " + (extObj != null ? extObj.getClass().getSimpleName() : "null"));
                            JSONObject json = (JSONObject) XposedHelpers.getObjectField(messageRecord, "mExJsonObject");
                            Logger.i(TAG, "JSON内容: " + (json != null ? json.toString() : "null"));
							Logger.i("Message Info" + XposedHelpers.getObjectField(messageRecord, "mMessageInfo").getClass().getName());
						}
				    };
					for (Method method : ClassHelper.loadClass("com.tencent.imcore.message.BaseMessageManager").getMethods())
					{
					    if (method.getName().equals("a"))
						{
							Class<?>[] paramTypes = method.getParameterTypes();
							if (paramTypes[0].equals(ClassHelper.loadClass("com.tencent.mobileqq.data.MessageRecord")) &&
							    paramTypes[2].equals(boolean.class) &&
							    paramTypes[3].equals(boolean.class) &&
							    paramTypes[4].equals(boolean.class) &&
							    paramTypes[5].equals(boolean.class))
							    XposedBridge.hookMethod(method, hookMethod);
						}
					}
			    }
				catch (Throwable throwable)
				{
					Logger.e(TAG, "init ->", throwable);
				}
			}
		);
	}
}