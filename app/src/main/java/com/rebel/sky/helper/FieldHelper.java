package com.rebel.sky.helper;

import de.robv.android.xposed.XposedHelpers;

public class FieldHelper
{
	public static Object getFieldValue(Object obj, String fieldName, Class<?> type)
	{
        if (type == int.class || type == Integer.class)
		{
            return XposedHelpers.getIntField(obj, fieldName);
        }
	    else if (type == long.class || type == Long.class)
	    {
            return XposedHelpers.getLongField(obj, fieldName);
        }
	    else if (type == byte.class || type == Byte.class)
	    {
            return XposedHelpers.getByteField(obj, fieldName);
        }
	    else if (type == boolean.class || type == Boolean.class)
	    {
            return XposedHelpers.getBooleanField(obj, fieldName);
        }
		else if (type == short.class || type == Short.class)
	    {
            return XposedHelpers.getShortField(obj, fieldName);
        }
	    else if (type == double.class || type == Double.class)
	    {
            return XposedHelpers.getDoubleField(obj, fieldName);
        }
	    else
	    {
            return XposedHelpers.getObjectField(obj, fieldName);
        }
    }
}
