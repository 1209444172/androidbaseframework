package com.commonutils;

import android.util.Log;



public class LogUtils {
    private static final String LOGTAG = "yjn";
    public static final boolean DEBUG = true;

    public static void logi(String tag, String logmsg) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg);
        }
    }

    public static void logi(String tag, String logmsg, String logvalue) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg + " = " + logvalue);

        }

    }
    public static void logtolongi(String tag, String logmsg, String logvalue) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg + " = " + logvalue);
            if(logvalue.length() > 1000) {
                for(int i=0;i<logvalue.length();i+=1000){
                    if(i+1000<logvalue.length())
                        Log.i(LOGTAG+i,tag + ", " + logmsg + " = " + logvalue.substring(i, i+1000));
                    else
                        Log.i(LOGTAG+i,tag + ", " + logmsg + " = " + logvalue.substring(i, logvalue.length()));
                }
            } else
                Log.i(LOGTAG,tag + ", " + logmsg + " = " + logvalue);
        }

    }

    public static void log2i(String tag, String logmsg, String logvalue, String logmsg2, String logvalue2) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg + " = " + logvalue + ", " + logmsg2 + " = " + logvalue2);
        }
    }

    public static void log3i(String tag, String logmsg, String logvalue, String logmsg2, String logvalue2, String logmsg3, String logvalue3) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg + " = " + logvalue + ", " + logmsg2 + " = " + logvalue2 + ", " + logmsg3 + " = " + logvalue3);
        }
    }

    public static void log4i(String tag, String logmsg, String logvalue, String logmsg2, String logvalue2, String logmsg3, String logvalue3, String logmsg4, String logvalue4) {
        if (DEBUG) {
            Log.i(LOGTAG, tag + ", " + logmsg + " = " + logvalue + ", " + logmsg2 + " = " + logvalue2 + ", " + logmsg3 + " = " + logvalue3 + ", " + logmsg4 + " = " + logvalue4);
        }
    }
}
