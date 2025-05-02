package com.qsky.core.config;

import android.annotation.SuppressLint;

import com.qsky.core.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ConfigManager
{
	private static File configFile;
	
	private static JSONObject configJson;
	
	private static volatile boolean isInited = false;
	
	private static volatile boolean isLoaded = false;
	
    private static final String TAG = "ConfigManager";
	
	private static final String CONFIG_FILE_NAME = "config.json";
	
	private static final String DATA_ROOT_DIR = "/storage/emulated/0/QSky/";

    @SuppressLint("SuspiciousIndentation")
    private static void init()
	{
		try
		{
			if (!configFile.getParentFile().exists()) configFile.getParentFile().mkdirs();
		    configFile.createNewFile();
			isInited = true;
			return ;
		}	
		catch (Exception exception)
		{
			Logger.e(TAG, "init", exception);
			return;
		}
	}
	
	public static synchronized void loadConfig()
	{
		configFile = new File(DATA_ROOT_DIR, CONFIG_FILE_NAME);
		if (!configFile.exists()) init();
		else isInited = true;
		if (!isInited)
		{
			Logger.e(TAG, "loadConfig", "!isInited");
			return;
		}	
		try
		{
			String content = new String(Files.readAllBytes(configFile.toPath()));
			if (content == null || content.equals("") || content.isEmpty())
				configJson = new JSONObject("{}");
			else
			    configJson = new JSONObject(content);
			isLoaded = true;
		    return;
		}
		catch (Exception exception)
		{
			Logger.e(TAG, "loadConfig", exception);
			return;
		}	
	}	
	
	public static void putStringConfig(String key, String value)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getStringConfig", "!isLoaded");
			return;
		}
		try
		{
		    configJson.putOpt(key, value);
	    }
		catch (JSONException exception)
		{
			if (!isLoaded) Logger.e(TAG, "getStringConfig", exception);
		}	
	}
	
	public static String getStringConfig(String key, String def)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getStringConfig", "!isLoaded");
			return def;
		}	
		return configJson.optString(key, def);
	}
	
	public static void putIntConfig(String key, int value)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "putIntConfig", "!isLoaded");
			return;
		}
		try
		{
		    configJson.putOpt(key, value);
	    }
		catch (JSONException exception)
		{
			if (!isLoaded) Logger.e(TAG, "putIntConfig", exception);
		}	
	}
	
	public static int getIntConfig(String key, int def)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getIntConfig", "!isLoaded");
			return def;
		}	
		return configJson.optInt(key, def);
	}
	
	public static void putLongConfig(String key, long value)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "putLongConfig", "!isLoaded");
			return;
		}
		try
		{
		    configJson.putOpt(key, value);
	    }
		catch (JSONException exception)
		{
			if (!isLoaded) Logger.e(TAG, "putLongConfig", exception);
		}	
	}
	
	public static long getLongConfig(String key, long def)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getLongConfig", "!isLoaded");
			return def;
		}	
		return configJson.optLong(key, def);
	}
	
	public static void putDoubleConfig(String key, double value)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "putDoubleConfig", "!isLoaded");
			return;
		}
		try
		{
		    configJson.putOpt(key, value);
	    }
		catch (JSONException exception)
		{
			if (!isLoaded) Logger.e(TAG, "putDoubleConfig", exception);
		}	
	}
	
	public static double getDoubleConfig(String key, double def)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getDoubleConfig", "!isLoaded");
			return def;
		}	
		return configJson.optDouble(key, def);
	}
	
	public static synchronized void putBooleanConfig(String key, boolean value)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "putBooleanConfig", "!isLoaded");
			return;
		}
		try
		{
		    configJson.putOpt(key, value);
	    }
		catch (JSONException exception)
		{
			if (!isLoaded) Logger.e(TAG, "putBooleanConfig", exception);
		}	
	}
	
	public static synchronized boolean getBooleanConfig(String key, boolean def)
	{
		if (!isLoaded)
		{
			Logger.e(TAG, "getBooleanConfig", "!isLoaded");
			return def;
		}	
		return configJson.optBoolean(key, def);
	}
	
	public static synchronized void updateConfig()
	{
		try
		(
		    FileWriter writer = new FileWriter(configFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
		)
		{
			bufferedWriter.write(new String(configJson.toString(4).getBytes(StandardCharsets.UTF_8)));
			bufferedWriter.newLine();
		}
		catch (Exception exception)
		{
			Logger.e(TAG, "updateConfig", exception);
		}
	}
	
	public static synchronized void deleteConfig()
	{
        configFile.delete();
		Logger.i(TAG, "deleteConfig");
		return;
	}
}