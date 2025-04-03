package com.rebel.sky;

import android.os.Looper;
import android.os.Handler;

import android.widget.Toast;
import android.content.Context;

public class ToastUtil
{
	public static void show(Object content)
	{
		new Handler(Looper.getMainLooper()).post
		(() ->
		    {
			    if (HookEnvironInfo.appContext != null)
			    {
				    String str = String.valueOf(content);
				    if (str != null && !str.equals(""))
				    {
					    Toast.makeText(HookEnvironInfo.appContext, str, Toast.LENGTH_SHORT).show();
						return;
				    }	
				}	
			}
		);
	}
	
	public static void show(Object content, boolean isLong)
	{
		new Handler(Looper.getMainLooper()).post
		(() ->
		    {
			    if (HookEnvironInfo.appContext != null)
			    {
				    String str = String.valueOf(content);
				    if (str != null && !str.equals(""))
				    {
					    if (isLong)
					    {
							Toast.makeText(HookEnvironInfo.appContext, str, Toast.LENGTH_LONG).show();
							return;
					    }	
					    else
					    {
                            Toast.makeText(HookEnvironInfo.appContext, str, Toast.LENGTH_SHORT).show();
							return;
					    }	
					}	
				}
			}
        );
	}
}
