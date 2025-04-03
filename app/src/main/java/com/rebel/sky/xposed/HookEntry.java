package com.rebel.sky;

import com.rebel.sky.annotation.ClassInformation;
import com.rebel.sky.log.Logger;

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
    date = "2025.03.14",
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
	
    @Override /* 应用载入，此术监之，更其行为，改其路径，无中生有，有中化无。 */
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam packageParam) throws Throwable
	{
		//非目标则退出
		if (!packageParam.packageName.equals(TARGET_PACKAGE_NAME)) return;
		//上报加载日志
		Logger.i("Xposed", "Module Load Success.");
		//设置类加载器
		HookEnvironInfo.appClassLoader = packageParam.classLoader;
        //部署启动钩子
        BaseApplicationImplHook.init();
		
    }
	
    @Override /* 资源初启，图画文字，皆由此类握其枢机，易其风貌，变其内涵。*/
    public void handleInitPackageResources(InitPackageResourcesParam initPackageResourcesParam) throws Throwable
	{
		if (!initPackageResourcesParam.packageName.equals(TARGET_PACKAGE_NAME)) return;
		
		/* 
		 * -> 以下资源更改为"设置"功能中的字符串 <-
		 *
		 * 与此同时本人也期待任何参与者参与维护其有效性以避免最终之废弃。
	 	*/
		
        HashMap<String, String> hashMap = new HashMap<String, String>();
        // 设置
        hashMap.put("fsy", "乾坤枢机定");
        // 账号与安全
        hashMap.put("228", "玉牒锁金钥");
        // 消息通知
        hashMap.put("fsa", "青鸟衔云笺");
        // 模式选择
        hashMap.put("wjw", "阴阳两仪决");
        // 通用
        hashMap.put("frw", "四海通衢道");
        // 隐私设置
        hashMap.put("0yj", "秘阁掩玄机");
        // 个人信息收集清单
        hashMap.put("2an", "采薇录青简");
        // 第三方个人信息共享清单
        hashMap.put("2b8", "琼枝寄瑶台");
        // 个人信息保护设置
        hashMap.put("2ao", "金瓯护灵枢");
        // 关于QQ与帮助
        hashMap.put("fre", "青鸾扶摇鉴");
        // 退出当前账号
        hashMap.put("c6n", "拂袖别云阙");
		
        for (Map.Entry<String, String> entry : hashMap.entrySet())
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