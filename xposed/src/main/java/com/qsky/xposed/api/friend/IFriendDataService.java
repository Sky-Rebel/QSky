package com.qsky.xposed.api.friend;

import com.qsky.core.data.FriendInfo;

import java.util.List;

public interface IFriendDataService
{
	int getFriendCount();
	
	boolean isFriend(String uin);
	
	List<FriendInfo> getFriendInfoList();
	
	FriendInfo getFriendInfo(String targetUin);
}