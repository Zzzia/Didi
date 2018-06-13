package com.zia.didi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by zia on 2018/6/13.
 */
public class UserHelper {

    private static final String NAME = "setting";

    public static void saveData(Context context, @NonNull String username, @NonNull String password) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public static String getUsername(Context context) {
        return getSharedPreferences(context).getString("username", "");
    }

    public static boolean checkLogin(Context context) {
        return !getSharedPreferences(context).getString("username", "").equals("");
    }

    public static String getPassword(Context context) {
        return getSharedPreferences(context).getString("password", "");
    }

    public static void clear(Context context) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(NAME, 0);
    }
}
