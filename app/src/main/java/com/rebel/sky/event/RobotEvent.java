package com.rebel.sky.event;

import android.os.Handler;
import android.os.Looper;

import com.rebel.sky.message.MessageServiceImpl;
import java.util.List;

public class RobotEvent
{
	public static void onLine()
	{
		MessageServiceImpl msgSender = new MessageServiceImpl();
		msgSender.init();
	    msgSender.sendTextMessage("634447585", "[Robot on Line - QSky]\nRobot上线!", true);
		/*
		StringBuffer msg = new StringBuffer("[Friend List - QSky]\n");
		
		try
		{
			FriendDataServiceImpl service = new FriendDataServiceImpl();
            List<FriendInfo> friendInfoList = service.getFriendInfoList();
			if (friendInfoList == null)
			{
			    msgSender.sendTextMessage("634447585", "[Robot on Line - QSky]\n获取到的好友列表为空，将强制退出程序", true);
			    return;
			}	
            for (FriendInfo friend : friendInfoList)
			{
				msg.append("昵称: " + friend.name).append("\n");
				msg.append("账号: " + friend.uin).append("\n");
				msg.append("备注: " + friend.remark).append("\n\n");
			}
			LogUtil.i(msg.toString());
			msgSender.sendTextMessage("634447585", msg.toString(), true);
		}
		catch (Throwable throwable)
        {
			msgSender.sendTextMessage("634447585", "[Robot on Line - QSky]\n好友列表加载成功！但出现不知名错误，详情请查询日志文件", true);
		    LogUtil.e("好友列表处理异常",throwable);
		}
		*/
	}
	
	public static void onOff()
	{
		return;
	}
}