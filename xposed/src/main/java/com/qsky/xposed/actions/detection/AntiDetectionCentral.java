package com.qsky.xposed.actions.detection;

import com.qsky.xposed.actions.detection.AntiPackageManagerDetection;

public class AntiDetectionCentral
{
	public static void startAntiDetection()
	{
		AntiPackageManagerDetection.start();
	}
}
