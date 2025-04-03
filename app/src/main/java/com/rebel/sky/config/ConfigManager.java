package com.rebel.sky.config;

import android.util.JsonReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.rebel.sky.log.Logger;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ConfigManager
{
	private static File configFile;
	
    private static final String TAG = "ConfigManager";
	
	private static final String DATA_ROOT_DIR = "/emulated/storage/0/QSky/";
	
	public static final synchronized void init() 
	{
		init("config.json");
		return;
	}
	
    public static final synchronized void init(String configFile)
	{
		ConfigManager.configFile = new File(DATA_ROOT_DIR, configFile);
		try
		{
		    if (!ConfigManager.configFile.exists() && (!ConfigManager.configFile.mkdirs() || !ConfigManager.configFile.createNewFile()))
		    {
			    Logger.d(TAG, "配置文件初始化失败");
		    }
			return;
		}	
		catch (IOException exception)
		{
			Logger.d(TAG, "配置文件初始化错误");
			Logger.e(TAG, exception);
			return;
		}
	}
	
	public static final String getStringConfig(String key)
	{
		try
		{
		    FileReader fileReader = new FileReader(configFile, StandardCharsets.UTF_8);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    if (bufferedReader.readLine() == null)
		    {
			    return "";
		    }
			String line;
			StringBuilder content = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null)
			{
				content.append(line);
			}
		    return null;
		}
		catch (IOException exception)
		{
			Logger.d(TAG, "字符串配置项读取失败");
			Logger.e(TAG, exception);
			return "";
		}	
	}	
}
