package com.qsky.core.data;

import com.qsky.core.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TroopInfo
{
	private static final String TAG = "Troop_Info";
	
    @Deprecated
	public String Administrator;

    public int activeMemberNum;

    public int allowMemberAtAll;

    public int allowMemberKick;

    public int allowMemberModifTroopName;

    public long appealDeadline;

    public long associatePubAccount;

    public short cGroupOption;

    public int cityId;

    public long cmdUinFlagEx2;

    public long cmduinFlagEx3Grocery;

    public long discussMaxSeq;

    public long discussToTroopTime;

    public String discussUin;

    public long dwAppPrivilegeFlag;

    public long dwAuthGroupType;

    public long dwCmdUinJoinTime;

    public long dwGagTimeStamp;

    public long dwGagTimeStamp_me;

    public long dwGroupClassExt;

    public long dwGroupFlag;

    public long dwGroupFlagExt;

    public long dwGroupFlagExt3;

    public long dwGroupInfoSeq;

    public long dwGroupLevelSeq;

    // private transient List<MemberLevelName> e;

    public int exitTroopReason;

    // public TroopExtDBInfo extDBInfo;

    public String fingertroopmemo;

    public int grade;

    public long groupAllianceid;

    public ArrayList<String> groupCardPrefix;

    public String groupCardPrefixIntro;

    // public transient GroupExt groupExt;

    public int groupFlagExt4;

    public int groupFreezeReason;

    // public transient GroupGameList groupGameList;

    // public GroupPermissions groupPermissions;

    // public GroupStatus groupStatus;

    public boolean hadInitDetail;

    public boolean hadInitExt;

    public boolean hasSetNewTroopHead;

    public boolean hasSetNewTroopName;

    public long hlGuildAppid;

    public int hlGuildBinary;

    public int hlGuildOrgid;

    public long hlGuildSubType;

    public int inviteNoAuthLimitNum;

    public int isAllowHistoryMsgFlag;

    public boolean isExitByJce;

    public boolean isNewTroop;

    public boolean isTop;

    public boolean isTroopBlocked;

    public String joinTroopAnswer;

    public String joinTroopQuestion;

    public int joinTroopSeq;

    public long lastMsgTime;

    public String location;

    private volatile ConcurrentHashMap<Integer, String> mCachedNewLevelMap;

    public boolean mCanSearchByKeywords;

    public boolean mCanSearchByTroopUin;

    public String mGroupClassExtText;

    public int mIsFreezed;

    public long mMemberCardSeq;

    public boolean mMemberInvitingFlag;

    public long mMemberNickIconSeq;

    public long mMemberNumSeq;

    public String mRichFingerMemo;

    public String mTags;

    @Deprecated(since = "付费群下架")
    public float mTroopNeedPayNumber;

    // public List<TroopClipPic> mTroopPicList;

    public Set<String> mTroopVerifyingPics;

    public int maxAdminNum;

    public int maxInviteMemNum;

    // public MemberRole memberRole;

    public int nMsgLimitFreq;

    public int nTroopGrade;

    public String school;

    public ArrayList<Integer> selectedGameId;

    public long setTopTime;

    public String strLocation;

    public String troopAuthenticateInfo;

    public long troopCreateTime;

    public long troopCreditLevel;

    public int troopLat;

    public int troopLon;

    public String troopNameFromNT;

    public String troopOwnerUid;

    public long troopPrivilegeFlag;

    public String troopRemark;

    public int troopTypeExt;

    @Deprecated public String troopcode;

    public short troopface;

    // public GroupMsgMask troopmask;

    public String troopmemo;

    @Deprecated(since = "用的地方太多，先保留字段，新需求統一使用troopNameFromNT")
    public String troopname;

    public String troopowneruin;

    public String troopuin;

    public long udwCmdUinRingtoneID;

    public int wMemberMax;

    public int wMemberNum;

    @Override
    public String toString()
	{
        return "TroopInfo[Administrator="
                + Administrator
                + ", activeMemberNum="
                + activeMemberNum
                + ", allowMemberAtAll="
                + allowMemberAtAll
                + ", allowMemberKick="
                + allowMemberKick
                + ", allowMemberModifTroopName="
                + allowMemberModifTroopName
                + ", appealDeadline="
                + appealDeadline
                + ", associatePubAccount="
                + associatePubAccount
                + ", cGroupOption="
                + cGroupOption
                + ", cityId="
                + cityId
                + ", cmdUinFlagEx2="
                + cmdUinFlagEx2
                + ", cmduinFlagEx3Grocery="
                + cmduinFlagEx3Grocery
                + ", discussMaxSeq="
                + discussMaxSeq
                + ", discussToTroopTime="
                + discussToTroopTime
                + ", discussUin="
                + discussUin
                + ", dwAppPrivilegeFlag="
                + dwAppPrivilegeFlag
                + ", dwAuthGroupType="
                + dwAuthGroupType
                + ", dwCmdUinJoinTime="
                + dwCmdUinJoinTime
                + ", dwGagTimeStamp="
                + dwGagTimeStamp
                + ", dwGagTimeStamp_me="
                + dwGagTimeStamp_me
                + ", dwGroupClassExt="
                + dwGroupClassExt
                + ", dwGroupFlag="
                + dwGroupFlag
                + ", dwGroupFlagExt="
                + dwGroupFlagExt
                + ", dwGroupFlagExt3="
                + dwGroupFlagExt3
                + ", dwGroupInfoSeq="
                + dwGroupInfoSeq
                + ", dwGroupLevelSeq="
                + dwGroupLevelSeq
                + ", exitTroopReason="
                + exitTroopReason
                + ", fingertroopmemo="
                + fingertroopmemo
                + ", grade="
                + grade
                + ", groupAllianceid="
                + groupAllianceid
                + ", groupCardPrefix="
                + groupCardPrefix
                + ", groupCardPrefixIntro="
                + groupCardPrefixIntro
                + ", groupFlagExt4="
                + groupFlagExt4
                + ", groupFreezeReason="
                + groupFreezeReason
                + ", hadInitDetail="
                + hadInitDetail
                + ", hadInitExt="
                + hadInitExt
                + ", hasSetNewTroopHead="
                + hasSetNewTroopHead
                + ", hasSetNewTroopName="
                + hasSetNewTroopName
                + ", hlGuildAppid="
                + hlGuildAppid
                + ", hlGuildBinary="
                + hlGuildBinary
                + ", hlGuildOrgid="
                + hlGuildOrgid
                + ", hlGuildSubType="
                + hlGuildSubType
                + ", inviteNoAuthLimitNum="
                + inviteNoAuthLimitNum
                + ", isAllowHistoryMsgFlag="
                + isAllowHistoryMsgFlag
                + ", isExitByJce="
                + isExitByJce
                + ", isNewTroop="
                + isNewTroop
                + ", isTop="
                + isTop
                + ", isTroopBlocked="
                + isTroopBlocked
                + ", joinTroopAnswer="
                + joinTroopAnswer
                + ", joinTroopQuestion="
                + joinTroopQuestion
                + ", joinTroopSeq="
                + joinTroopSeq
                + ", lastMsgTime="
                + lastMsgTime
                + ", location="
                + location
                + ", mCachedNewLevelMap="
                + mCachedNewLevelMap
                + ", mCanSearchByKeywords="
                + mCanSearchByKeywords
                + ", mCanSearchByTroopUin="
                + mCanSearchByTroopUin
                + ", mGroupClassExtText="
                + mGroupClassExtText
                + ", mIsFreezed="
                + mIsFreezed
                + ", mMemberCardSeq="
                + mMemberCardSeq
                + ", mMemberInvitingFlag="
                + mMemberInvitingFlag
                + ", mMemberNickIconSeq="
                + mMemberNickIconSeq
                + ", mMemberNumSeq="
                + mMemberNumSeq
                + ", mRichFingerMemo="
                + mRichFingerMemo
                + ", mTags="
                + mTags
                + ", mTroopNeedPayNumber="
                + mTroopNeedPayNumber
                + ", mTroopVerifyingPics="
                + mTroopVerifyingPics
                + ", maxAdminNum="
                + maxAdminNum
                + ", maxInviteMemNum="
                + maxInviteMemNum
                + ", nMsgLimitFreq="
                + nMsgLimitFreq
                + ", nTroopGrade="
                + nTroopGrade
                + ", school="
                + school
                + ", selectedGameId="
                + selectedGameId
                + ", setTopTime="
                + setTopTime
                + ", strLocation="
                + strLocation
                + ", troopAuthenticateInfo="
                + troopAuthenticateInfo
                + ", troopCreateTime="
                + troopCreateTime
                + ", troopCreditLevel="
                + troopCreditLevel
                + ", troopLat="
                + troopLat
                + ", troopLon="
                + troopLon
                + ", troopNameFromNT="
                + troopNameFromNT
                + ", troopOwnerUid="
                + troopOwnerUid
                + ", troopPrivilegeFlag="
                + troopPrivilegeFlag
                + ", troopRemark="
                + troopRemark
                + ", troopTypeExt="
                + troopTypeExt
                + ", troopcode="
                + troopcode
                + ", troopface="
                + troopface
                + ", troopmemo="
                + troopmemo
                + ", troopname="
                + troopname
                + ", troopowneruin="
                + troopowneruin
                + ", troopuin="
                + troopuin
                + ", udwCmdUinRingtoneID="
                + udwCmdUinRingtoneID
                + ", wMemberMax="
                + wMemberMax
                + ", wMemberNum="
                + wMemberNum
                + "]";
    }

    public JSONObject toJSONObject() throws JSONException
	{
        JSONObject json = new JSONObject();
        json.put("administrator", Administrator);
        json.put("activeMemberNum", activeMemberNum);
        json.put("allowMemberAtAll", allowMemberAtAll);
        json.put("allowMemberKick", allowMemberKick);
        json.put("allowMemberModifTroopName", allowMemberModifTroopName);
        json.put("appealDeadline", appealDeadline);
        json.put("associatePubAccount", associatePubAccount);
        json.put("cGroupOption", cGroupOption);
        json.put("cityId", cityId);
        json.put("cmdUinFlagEx2", cmdUinFlagEx2);
        json.put("cmduinFlagEx3Grocery", cmduinFlagEx3Grocery);
        json.put("discussMaxSeq", discussMaxSeq);
        json.put("discussToTroopTime", discussToTroopTime);
        json.put("discussUin", discussUin);
        json.put("dwAppPrivilegeFlag", dwAppPrivilegeFlag);
        json.put("dwAuthGroupType", dwAuthGroupType);
        json.put("dwCmdUinJoinTime", dwCmdUinJoinTime);
        json.put("dwGagTimeStamp", dwGagTimeStamp);
        json.put("dwGagTimeStamp_me", dwGagTimeStamp_me);
        json.put("dwGroupClassExt", dwGroupClassExt);
        json.put("dwGroupFlag", dwGroupFlag);
        json.put("dwGroupFlagExt", dwGroupFlagExt);
        json.put("dwGroupFlagExt3", dwGroupFlagExt3);
        json.put("dwGroupInfoSeq", dwGroupInfoSeq);
        json.put("dwGroupLevelSeq", dwGroupLevelSeq);
        json.put("exitTroopReason", exitTroopReason);
        json.put("fingertroopmemo", fingertroopmemo);
        json.put("grade", grade);
        json.put("groupAllianceid", groupAllianceid);
        if (groupCardPrefix != null) json.put("groupCardPrefix", new JSONArray(groupCardPrefix));
		else json.put("groupCardPrefix", JSONObject.NULL);
        json.put("groupCardPrefixIntro", groupCardPrefixIntro);
        json.put("groupFlagExt4", groupFlagExt4);
        json.put("groupFreezeReason", groupFreezeReason);
        json.put("hadInitDetail", hadInitDetail);
        json.put("hadInitExt", hadInitExt);
        json.put("hasSetNewTroopHead", hasSetNewTroopHead);
        json.put("hasSetNewTroopName", hasSetNewTroopName);
        json.put("hlGuildAppid", hlGuildAppid);
        json.put("hlGuildBinary", hlGuildBinary);
        json.put("hlGuildOrgid", hlGuildOrgid);
        json.put("hlGuildSubType", hlGuildSubType);
        json.put("inviteNoAuthLimitNum", inviteNoAuthLimitNum);
        json.put("isAllowHistoryMsgFlag", isAllowHistoryMsgFlag);
        json.put("isExitByJce", isExitByJce);
        json.put("isNewTroop", isNewTroop);
        json.put("isTop", isTop);
        json.put("isTroopBlocked", isTroopBlocked);
        json.put("joinTroopAnswer", joinTroopAnswer);
        json.put("joinTroopQuestion", joinTroopQuestion);
        json.put("joinTroopSeq", joinTroopSeq);
        json.put("lastMsgTime", lastMsgTime);
        json.put("location", location);
        if (mCachedNewLevelMap != null)
	    {
            JSONObject mapJson = new JSONObject();
            mCachedNewLevelMap.forEach
		    (
			    (key, value) ->
				{
					try
					{
					    mapJson.put(String.valueOf(key), value);
					}
					catch (JSONException exception)
                    {
						Logger.e(TAG, "toJSONObject", exception);
					}
				}	
            );
            json.put("mCachedNewLevelMap", mapJson);
        }
	    else json.put("mCachedNewLevelMap", JSONObject.NULL);
        json.put("mCanSearchByKeywords", mCanSearchByKeywords);
        json.put("mCanSearchByTroopUin", mCanSearchByTroopUin);
        json.put("mGroupClassExtText", mGroupClassExtText);
        json.put("mIsFreezed", mIsFreezed);
        json.put("mMemberCardSeq", mMemberCardSeq);
        json.put("mMemberInvitingFlag", mMemberInvitingFlag);
        json.put("mMemberNickIconSeq", mMemberNickIconSeq);
        json.put("mMemberNumSeq", mMemberNumSeq);
        json.put("mRichFingerMemo", mRichFingerMemo);
        json.put("mTags", mTags);
        json.put("mTroopNeedPayNumber", mTroopNeedPayNumber);
        if (mTroopVerifyingPics != null) json.put("mTroopVerifyingPics", new JSONArray(mTroopVerifyingPics));
		else json.put("mTroopVerifyingPics", JSONObject.NULL);
        json.put("maxAdminNum", maxAdminNum);
        json.put("maxInviteMemNum", maxInviteMemNum);
        json.put("nMsgLimitFreq", nMsgLimitFreq);
        json.put("nTroopGrade", nTroopGrade);
        json.put("school", school);
        if (selectedGameId != null) json.put("selectedGameId", new JSONArray(selectedGameId));
	    else json.put("selectedGameId", JSONObject.NULL);
        json.put("setTopTime", setTopTime);
        json.put("strLocation", strLocation);
        json.put("troopAuthenticateInfo", troopAuthenticateInfo);
        json.put("troopCreateTime", troopCreateTime);
        json.put("troopCreditLevel", troopCreditLevel);
        json.put("troopLat", troopLat);
        json.put("troopLon", troopLon);
        json.put("troopNameFromNT", troopNameFromNT);
        json.put("troopOwnerUid", troopOwnerUid);
        json.put("troopPrivilegeFlag", troopPrivilegeFlag);
        json.put("troopRemark", troopRemark);
        json.put("troopTypeExt", troopTypeExt);
        json.put("troopcode", troopcode);
        json.put("troopface", troopface);
        json.put("troopmemo", troopmemo);
        json.put("troopname", troopname);
        json.put("troopowneruin", troopowneruin);
        json.put("troopuin", troopuin);
        json.put("udwCmdUinRingtoneID", udwCmdUinRingtoneID);
        json.put("wMemberMax", wMemberMax);
        json.put("wMemberNum", wMemberNum);
        return json;
    }
}