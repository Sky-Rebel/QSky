package com.rebel.sky.data;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TroopInfo
{
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
}