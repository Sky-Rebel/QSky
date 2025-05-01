package com.qsky.xposed.api.msg.impl;

import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;
import com.qsky.xposed.api.msg.IMessageService;
import com.qsky.xposed.utils.helpers.ClassHelper;
import com.qsky.xposed.utils.helpers.MethodHelper;

import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageServiceImpl implements IMessageService
{
    private static final String TAG = "Ntqq_Send_Message";
    
    private Object msgService;
	private Object msgUtilApi;
	
    private Class<?> contact;
	private Class<?> textElement;
	
    private Method generateMsgUniqueId;
	
    public void init()
	{
		try
		{
			Class<?> iMsgUtilApi = ClassHelper.loadClass("com.tencent.qqnt.msg.api.IMsgUtilApi");
			Class<?> iKernelService = ClassHelper.loadClass("com.tencent.qqnt.kernel.api.IKernelService");
			contact = ClassHelper.loadClass("com.tencent.qqnt.kernelpublic.nativeinterface.Contact");
			textElement = ClassHelper.loadClass("com.tencent.qqnt.kernel.nativeinterface.TextElement");
            Object kernelService = MethodHelper.invokeMethod
			(
				MethodHelper.findMethod
			    (
					ClassHelper.loadClass("mqq.app.AppRuntime"),
				    "getRuntimeService",
				    new Class<?>[]
				    {
					    Class.class,
						String.class
				    }
				),
			    HookEnv.appRuntime,
			    new Object[]
			    {
					iKernelService,
				    "all"
			    }
		    );
			msgService = MethodHelper.invokeMethod
			(
				MethodHelper.findMethod
			    (
					ClassHelper.loadClass("com.tencent.qqnt.kernel.api.impl.KernelServiceImpl"),
				    "getMsgService"
				),
			    kernelService,
			    null
		    );
			generateMsgUniqueId = MethodHelper.findMethod
			(
				msgService.getClass(),
			    "e0",
				new Class[]
				{
					int.class
				}
			);
			
			msgUtilApi = MethodHelper.invokeMethod
			(
				MethodHelper.findMethod
			    (
					ClassHelper.loadClass("com.tencent.mobileqq.qroute.QRoute"),
				    "api",
				    new Class[]
				    {
					    Class.class
				    }
				),
			    HookEnv.appRuntime,
			    new Object[]
			    {
					iMsgUtilApi
			    }
		    );
			
			return;
        }
		catch (Throwable throwable)
		{
            Logger.e(TAG, "init ->", throwable);
			return;
        }
    }
	
    @Override
	public void sendTroopMessage(String uin, String msg)
	{
		sendMessage(uin, msg, true);
		return;
	}
	
	@Override
	public void sendFriendMessage(String uin, String msg)
	{
		sendMessage(uin, msg, false);
		return;
	}
	
    private void sendMessage(String uin, String message, boolean isGroup)
	{
        try
		{
			String peerUid;
			if (isGroup) peerUid = uin;
			else
			{
				peerUid = "_" + uin;
			}
            Object contact = ClassHelper.newInstance
			(
				ClassHelper.findConstructor
			    (
				    this.contact,
				    new Class[]
				    {
					    int.class,
					    String.class,
					    String.class
				    }
				),
				new Object[]
				{
					isGroup ? 2 : 1,
					peerUid,
					""
				}
			);
            Object textElement = this.textElement.getConstructor().newInstance();
            XposedHelpers.setObjectField(textElement, "content", message);
			Object msgElement = MethodHelper.invokeMethod
			(
				MethodHelper.findMethod
			    (
					ClassHelper.loadClass("com.tencent.qqnt.msg.api.impl.MsgUtilApiImpl"),
				    "createTextElement",
				    new Class[]
				    {
					    this.textElement
				    }
				),
			    msgUtilApi,
			    new Object[]
			    {
					textElement
			    }
		    );
            ArrayList<Object> msgElements = new ArrayList<>();
            msgElements.add(msgElement);
            long msgUniqueId = (long) MethodHelper.invokeMethod
			(
				generateMsgUniqueId,
				msgService,
				new Object[]
				{
					isGroup ? 2 : 1
				}
			);
			MethodHelper.invokeMethod
			(
				MethodHelper.findMethod
			    (
					ClassHelper.loadClass("com.tencent.qqnt.kernel.api.impl.MsgService"),
				    "sendMsg",
				    new Class[]
				    {
					    long.class,
						ClassHelper.loadClass("com.tencent.qqnt.kernelpublic.nativeinterface.Contact"),
						ArrayList.class,
						HashMap.class,
						ClassHelper.loadClass("com.tencent.qqnt.kernel.nativeinterface.IOperateCallback")
				    }
				),
			    msgService,
			    new Object[]
			    {
					msgUniqueId,
					contact,
					msgElements,
					new HashMap<Integer, Object>(),
					null
			    }
		    );
		}	
		catch (Throwable throwable)
        {
            Logger.e(TAG, "sendMessage ->", throwable);
        }
    }
}