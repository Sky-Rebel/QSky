package com.qsky.xposed.api.msg;

public interface IMessageService
{
	public void init();
	
	public void sendTroopMessage(String groupUin, String message);
	
	public void sendFriendMessage(String friendUin, String message);
}