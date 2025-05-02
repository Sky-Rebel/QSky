package com.qsky.app;

import android.app.Activity;
import android.os.Bundle;

import com.qsky.core.logger.Logger;

public class QSkyActivity extends Activity
{
	private static final String TAG = "qsky_main_activity";
    
	private static boolean isActive = false;
	
	@Override
	protected void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		Logger.d(TAG, "onCreate");
		setContentView(com.qsky.core.R.layout.activity_main);
	}

	@Override
	protected void onResume()
	{
		Logger.d(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onDestroy()
	{
		Logger.d(TAG, "onDestroy");
		super.onDestroy();
	}
}