package com.example.user.project1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    //kode untuk deklarasi nama user
    static final String nama_user = "a";

    //kode untuk shared preference
    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    //kode untuk membuat set registeret user
    public static void setRegisteredUser1(Context context, String username1){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(nama_user, username1);
        editor.apply();
    }
    //kode untuk membuat get registeret user
    public static String getRegisteredUser1(Context context){
        return getSharedPreference(context).getString(nama_user,"");
    }
}
