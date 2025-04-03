package com.rebel.sky.message;

public interface IMessageService
{
    public void sendTextMessage(String uin, String message, boolean isGroup);
	
	//public void sendGroupTextMessage(String groupUin, String message);
	
	//public void sendFriendTextMessage(String friendUin, String message);
}