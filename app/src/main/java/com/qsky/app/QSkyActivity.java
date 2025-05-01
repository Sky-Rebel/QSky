package com.qsky.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.qsky.core.R;
import com.qsky.core.logger.Logger;

import java.util.Random;

public class QSkyActivity extends AppCompatActivity
{
	private static final String TAG = "qsky_main_activity";
    
	private static boolean isActive = false;
	
	@Override
	protected void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		Logger.d(TAG, "onCreate");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams
		(
			new LinearLayout.LayoutParams
			(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                (int)TypedValue.applyDimension
				(
					TypedValue.COMPLEX_UNIT_DIP, 80, this.getResources().getDisplayMetrics()
			    )
            )
		);
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView appTitle = new TextView(this);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams
		(
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 100,
				 appTitle.getResources().getDisplayMetrics()
			),
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 40,
				 appTitle.getResources().getDisplayMetrics())
        );
        params1.topMargin = (int) TypedValue.applyDimension
		(
			TypedValue.COMPLEX_UNIT_DIP,
			 10,
			 this.getResources().getDisplayMetrics()
		);
        appTitle.setLayoutParams(params1);
        appTitle.setGravity(Gravity.CENTER);
        appTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        appTitle.setTextColor(0xFF484747);
        appTitle.setTypeface(Typeface.DEFAULT_BOLD);
		String[] appTitleArray = this.getResources().getStringArray(R.array.app_title);
        appTitle.setText(appTitleArray[new Random().nextInt(appTitleArray.length)]);
        TextView appSubTitle = new TextView(this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams
		(
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 150,
				 this.getResources().getDisplayMetrics()
			),
            LinearLayout.LayoutParams.MATCH_PARENT
        );
        params2.setMargins
		(
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 -100,
				 this.getResources().getDisplayMetrics()
			),
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 40,
				 this.getResources().getDisplayMetrics()
			),
            0,
            (int) TypedValue.applyDimension
			(
				TypedValue.COMPLEX_UNIT_DIP,
				 10, this.getResources().getDisplayMetrics()
			)
        );
        appSubTitle.setLayoutParams(params2);
        appSubTitle.setGravity(Gravity.CENTER);
        appSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        appSubTitle.setTextColor(0xFF777777);
        appSubTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC);
		String[] appSubTitleArray = this.getResources().getStringArray(R.array.app_sub_title);
        appSubTitle.setText(appSubTitleArray[new Random().nextInt(appSubTitleArray.length)]);
        linearLayout.addView(appTitle);
        linearLayout.addView(appSubTitle);
		setContentView(linearLayout);
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