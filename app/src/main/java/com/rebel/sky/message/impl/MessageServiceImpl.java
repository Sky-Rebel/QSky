package com.rebel.sky.message;

import com.rebel.sky.HookEnvironInfo;
import com.rebel.sky.message.IMessageService;
import com.rebel.sky.utils.UinAndUidUtil;
import com.rebel.sky.log.Logger;

import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class MessageServiceImpl implements IMessageService
{
    private static final String TAG = "Ntqq_Send_Message";
    
    private Object msgService;
    private Object msgUtilApi;
	private Object kernelService;
    private Class<?> contactClass;
    private Class<?> operateCallbackInterface;
    private Method generateMsgUniqueIdMethod;
    private Method getMsgUniqueIdMethod;

    public void init()
	{
		try
		{
            Class<?> IKernelService = XposedHelpers.findClass
		    (
                "com.tencent.qqnt.kernel.api.IKernelService", 
                HookEnvironInfo.appClassLoader
            );
            Object appRuntime = HookEnvironInfo.appRuntime;
            kernelService = XposedHelpers.callMethod
		    (
                appRuntime, 
                "getRuntimeService", 
                IKernelService, 
                "all"
            );
		}
		catch (Throwable exception)
		{
			Logger.e(TAG, "获取内核服务失败", exception);
		}	
		try
		{
            this.msgService = XposedHelpers.callMethod(kernelService, "getMsgService");
        }
		catch (Throwable exception)
		{
			Logger.e(TAG, "获取消息服务失败", exception);
		}
		try
		{
            Class<?> msgServiceClass = msgService.getClass();
            this.generateMsgUniqueIdMethod = XposedHelpers.findMethodExact(msgServiceClass, "e0", int.class);
		}
		catch (Throwable exception)
		{
			Logger.e(TAG, "获取消息ID生成方法失败", exception);
		}	
		try
		{
            Class<?> IMsgUtilApi = XposedHelpers.findClass
		    (
                "com.tencent.qqnt.msg.api.IMsgUtilApi", 
                HookEnvironInfo.appClassLoader
            );
            this.msgUtilApi = XposedHelpers.callStaticMethod
		    (
                XposedHelpers.findClass("com.tencent.mobileqq.qroute.QRoute", HookEnvironInfo.appClassLoader),
                "api",
                IMsgUtilApi
            );
		}	
		catch (Throwable exception)	
		{
			Logger.e(TAG, "获取消息工具API失败", exception);
		}
        try
		{
            this.contactClass = XposedHelpers.findClass
			(
                "com.tencent.qqnt.kernelpublic.nativeinterface.Contact", 
                HookEnvironInfo.appClassLoader
            );
        }
		catch (Throwable exception)
		{
            Logger.e(TAG, "加载Contact类失败", exception);
        }
        Logger.d(TAG, "消息服务初始化完成");
    }

    @Override
    public void sendTextMessage(String uin, String message, boolean isGroup)
	{
        try
		{
            int chatType = isGroup ? 2 : 1;
            String peerUid = isGroup ? uin : UinAndUidUtil.getUidFromUin(uin);
            Object contact = XposedHelpers.newInstance
			(
                contactClass, 
                chatType, 
                peerUid, 
                ""
            );
            Object textElement = XposedHelpers.newInstance
			(
                XposedHelpers.findClass("com.tencent.qqnt.kernel.nativeinterface.TextElement", contactClass.getClassLoader())
            );
            XposedHelpers.setObjectField(textElement, "content", message);
            Object msgElement = XposedHelpers.callMethod
			(
                msgUtilApi, 
                "createTextElement", 
                textElement
            );
			
            ArrayList<Object> msgElements = new ArrayList<>();
            msgElements.add(msgElement);
            long msgUniqueId = getMsgUniqueId(chatType);
			
            XposedHelpers.callMethod
			(
                msgService,
                "sendMsg",
                msgUniqueId,
                contact,
                msgElements,
                new HashMap<Integer, Object>(),
                null
            );
        
		    
		}	
		catch (Throwable exception)
        {
            Logger.e(TAG, "消息发送失败：" + exception.getMessage());
        }
    }

    private long getMsgUniqueId(int chatType)
	{
        try
		{
            long msgUniqueId = (long) generateMsgUniqueIdMethod.invoke(msgService, chatType);
			return msgUniqueId;
		}
		catch (IllegalAccessException exception)
		{
			Logger.e(TAG, "非法方法调用", exception);
			return -0;
		}	
		catch (InvocationTargetException exception)
		{
			Logger.e(TAG, "目标调用失败", exception);
			return -0;
		}
    }

    private static class OperateCallbackImpl
	{
        private final CountDownLatch latch;

        public OperateCallbackImpl(CountDownLatch latch)
		{
            this.latch = latch;
        }

        public void onResult(int result, String msg)
		{
            if (result == 0) {
                Logger.d(TAG, "消息发送成功");
            } else {
                Logger.e(TAG, "消息发送失败：" + msg);
            }
            latch.countDown();
        }
    }
}