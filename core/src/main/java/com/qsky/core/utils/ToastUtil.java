package com.qsky.core.utils;

import android.os.Looper;
import android.os.Handler;

import android.widget.Toast;
import android.content.Context;

public class ToastUtil
{
	public static void show(Context context, Object content)
	{
		new Handler(Looper.getMainLooper()).post
		(() ->
		    {
			    if (context != null)
			    {
				    String str = String.valueOf(content);
				    if (str != null && !str.equals(""))
				    {
					    Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
						return;
				    }	
				}	
			}
		);
	}
	
	public static void show(Context context, Object content, boolean isLong)
	{
		new Handler(Looper.getMainLooper()).post
		(() ->
		    {
			    if (context != null)
			    {
				    String str = String.valueOf(content);
				    if (str != null && !str.equals(""))
				    {
					    if (isLong)
					    {
							Toast.makeText(context, str, Toast.LENGTH_LONG).show();
							return;
					    }	
					    else
					    {
                            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
							return;
					    }	
					}	
				}
			}
        );
	}
}
