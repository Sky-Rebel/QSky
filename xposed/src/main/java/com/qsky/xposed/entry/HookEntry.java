package com.qsky.xposed.entry;

import android.os.Handler;
import android.os.Looper;

import com.qsky.core.annotation.ClassInformation;
import com.qsky.core.config.ConfigManager;
import com.qsky.core.logger.Logger;
import com.qsky.xposed.HookEnv;
import com.qsky.xposed.actions.detection.AntiDetectionCentral;
import com.qsky.xposed.actions.loading.BaseApplicationHook;
import com.qsky.xposed.actions.loading.QFixApplicationHook;
import com.qsky.xposed.actions.message.BaseMessageManagerHook;
import com.qsky.xposed.event.server.RobotOnOffLineEvent;
import com.qsky.xposed.utils.version.TargetVersionInfo;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import java.util.HashMap;
import java.util.Map;

/*
 * 也许有一天你不再记得我，关于我们之间所有的所有，没关系只要你幸福就好。
 * Maybe one day you'll no longer remember me, or anything about us. It's okay, as long as you're happy.
 */

@ClassInformation
(
	author = "Sky-Rebel",
    /* 如果您作为本项目的参与者，你有权利在此键入您的名字 */
    contributor = 
    {
		/* "Sky-Rebel" */
	}, 
    date = "2025.04.07",
    version = "1.0.1",
    introduction = "Hook主类/入口"
)

/* 故友之文案，本人不曾有过对于异性的此等深情，却仍不免深有感触。
 *
 * -> 我曾经喜欢你，
 * -> 我曾经那么喜欢你，	
 * -> 可惜你自始至终都不知道，
 * -> 可幸你自始至终都不知道。
 *
 * @final 声明不可继承，无任何实际作用，却有表明其独特性之意义。
 */

public final class HookEntry implements IXposedHookLoadPackage, IXposedHookInitPackageResources
{
	public static final String TAG = "Hook_Entry";
	
	public static final String TARGET_PACKAGE_NAME = "com.tencent.mobileqq";
	
	public static final HashMap<String, String> STRING_RES_HASH_MAP = new HashMap<String, String>();
	
	static
    {
        STRING_RES_HASH_MAP.put("fsy", "乾坤枢机定");
        STRING_RES_HASH_MAP.put("228", "玉牒锁金钥");
        STRING_RES_HASH_MAP.put("fsa", "青鸟衔云笺");
        STRING_RES_HASH_MAP.put("wjw", "阴阳两仪决");
        STRING_RES_HASH_MAP.put("frw", "四海通衢道");
        STRING_RES_HASH_MAP.put("0yj", "秘阁掩玄机");
        STRING_RES_HASH_MAP.put("2an", "采薇录青简");
        STRING_RES_HASH_MAP.put("2b8", "琼枝寄瑶台");
        STRING_RES_HASH_MAP.put("2ao", "金瓯护灵枢");
        STRING_RES_HASH_MAP.put("fre", "青鸾扶摇鉴");
        STRING_RES_HASH_MAP.put("c6n", "拂袖别云阙");
	}	

    @Override /* 应用载入，此术监之，更其行为，改其路径，无中生有，有中化无。 */
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam packageParam) throws Throwable
	{
		//非目标则退出
		if (!packageParam.packageName.equals(TARGET_PACKAGE_NAME)) return;
		//避免重复加载
		if (!packageParam.isFirstApplication) return;
		//启动堆栈日志
		Logger.startStackTrace();
		//清理日志文件
		Logger.deleteLogFile();
		//上报加载日志
		Logger.i("Xposed", "Module Load Success.");
		//设置类加载器
		HookEnv.appClassLoader = packageParam.classLoader;
		//启动消息监听
	    BaseMessageManagerHook.startMessageListening();
		//设置数据目录(Host)
		HookEnv.appDataPath = packageParam.appInfo.dataDir;
		//设置数据目录(Module)
		HookEnv.moduleDataPath = HookEnv.appDataPath + "/QSky";
		//替换类加载器
		QFixApplicationHook.hookOnCreate();
		//获取必要实例
        BaseApplicationHook.hookOnCreate();
		//启动欺骗检测
		AntiDetectionCentral.startAntiDetection();
    }
	
    @Override /* 资源初启，图画文字，皆由此类握其枢机，易其风貌，变其内涵。*/
    public void handleInitPackageResources(InitPackageResourcesParam initPackageResourcesParam) throws Throwable
	{
		//非目标则退出
		if (!initPackageResourcesParam.packageName.equals(TARGET_PACKAGE_NAME)) return;
		//变更字符资源
        for (Map.Entry<String, String> entry : STRING_RES_HASH_MAP.entrySet())
		{
            initPackageResourcesParam.res.setReplacement
			(
                TARGET_PACKAGE_NAME,
                "string",
                entry.getKey(),
                entry.getValue()
            );
        }
	}
}