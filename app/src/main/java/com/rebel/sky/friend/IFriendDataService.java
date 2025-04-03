package com.rebel.sky.friend;

import java.util.List;
import com.rebel.sky.data.FriendInfo;

public interface IFriendDataService
{
	int getFriendCount();
	
	boolean isFriend(String uin);
	
	List<FriendInfo> getFriendInfoList();
	
	FriendInfo deleteFriend(String targetUin);
	
	FriendInfo getFriendInfo(String targetUin);
	
	FriendInfo getFriendInfoFromCache(String targetUin);
	
	FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase);
	
	FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase, boolean isSkipCacheCheck);
	
	FriendInfo getFriendInfo(String targetUin, boolean isLoadFromDatabase, boolean isSkipCacheCheck, boolean isAutoCreateObject);
}