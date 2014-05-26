package com.cme;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CustomPreferences {
	private static final String prefEmail = "email";
    private static final String prefCall = "call";
    private static final String prefMessage = "message";
    
    private Context ctx;
    private SharedPreferences.Editor editor;
    
    public CustomPreferences(Context ctx) {
        this.ctx = ctx;
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        this.editor = pref.edit();
    }
    
    private SharedPreferences loadPrefrences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        return pref;
    }
    
    public synchronized void setEmail(boolean isEmail) {
    	editor.putBoolean(prefEmail, isEmail);
    	editor.commit();
    }
    
    public synchronized void setMessage(boolean isMessage) {
    	editor.putBoolean(prefMessage, isMessage);
    	editor.commit();
    }
    
    public synchronized void setCall(boolean isCall) {
    	editor.putBoolean(prefCall, isCall);
    	editor.commit();
    }
    
    public boolean isEmail() {
        return loadPrefrences().getBoolean(prefEmail, false);
    }
    
    public boolean isMessage() {
        return loadPrefrences().getBoolean(prefMessage, false);
    }
    
    public boolean isCall() {
        return loadPrefrences().getBoolean(prefCall, false);
    }
}
