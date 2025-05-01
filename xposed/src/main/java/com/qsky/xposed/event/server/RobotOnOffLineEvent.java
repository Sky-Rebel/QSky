package com.qsky.xposed.event.server;

import com.qsky.core.data.TroopInfo;
import com.qsky.core.logger.Logger;
import com.qsky.xposed.api.msg.impl.MessageServiceImpl;
import com.qsky.xposed.api.troopl.impl.TroopListDataServiceImpl;

import java.util.List;

public class RobotOnOffLineEvent
{
	public static void onOnline()
    {
		Logger.i("Robot Online Event.");
		MessageServiceImpl messageServiceImpl = new MessageServiceImpl();
		messageServiceImpl.init();
		try
		{
		    messageServiceImpl.sendTroopMessage("634447585", "Robot上线啦！");
		    Thread.sleep(2000);
		    messageServiceImpl.sendTroopMessage("634447585", "即将加载群聊列表...");
		    TroopListDataServiceImpl troopListRepoApiImpl = new TroopListDataServiceImpl();
			troopListRepoApiImpl.init();
			troopListRepoApiImpl.fetchTroopList();
			StringBuilder troopList = new StringBuilder();
			List<TroopInfo> troopInfoList = troopListRepoApiImpl.getSortedJoinedValidTroopInfoList();
			for (TroopInfo troopInfo : troopInfoList)
			{
				troopList.append("Group Name: " + troopInfo.troopname).append("\n\n");
				troopList.append("Group Code: " + troopInfo.troopcode).append("\n");
			}
			messageServiceImpl.sendTroopMessage("634447585", troopList.toString());
		}
		catch (Exception exception)
		{
			messageServiceImpl.sendTroopMessage("634447585", "群列表加载失败!");
			Logger.e("onOnline ->", exception);
		}
			
		
	}
	
	public static void onOffline()
	{
		Logger.i("Robot Offline Event.");
		return;
	}
}