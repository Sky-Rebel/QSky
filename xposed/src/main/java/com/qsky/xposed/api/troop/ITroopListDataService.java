package com.qsky.xposed.api.troopl;

import com.qsky.core.data.TroopInfo;

import java.util.List;

public interface ITroopListDataService
{
	void fetchTroopList();
	
	List<TroopInfo> getTroopInfoList();
	
	List<TroopInfo> getTopTroopInfoList();
	
	List<TroopInfo> getJoinedTroopInfoList();
	
	List<TroopInfo> getSortedJoinedTroopInfoList();
	
	List<TroopInfo> getSortedJoinedTopTroopInfoList();
	
	List<TroopInfo> getSortedJoinedValidTroopInfoList();
}