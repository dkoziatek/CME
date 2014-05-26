package com.cme;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class CMEMainActivity extends Activity {
	private static final String TAG = CMEMainActivity.class.getSimpleName();
	private ToggleButton mMessageButton;
	private ToggleButton mCallButton;
	private ToggleButton mEmailButton;
	private CustomPreferences mCustomPreferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mCustomPreferences = new CustomPreferences(getApplicationContext());
		
		mMessageButton = (ToggleButton)findViewById(R.id.toggle_message_button);
		mCallButton = (ToggleButton)findViewById(R.id.toggle_call_button);
		mEmailButton = (ToggleButton)findViewById(R.id.toggle_email_button);
		mMessageButton.setChecked(mCustomPreferences.isMessage());
		mCallButton.setChecked(mCustomPreferences.isCall());
		mEmailButton.setChecked(mCustomPreferences.isEmail());
		
		setListeners();
	}
	
	private void setListeners() {
		mMessageButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Log.e(TAG, "isChecked="+isChecked);
				mCustomPreferences.setMessage(isChecked);
			}
		});
		mCallButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCustomPreferences.setCall(isChecked);
			}
		});
		mEmailButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCustomPreferences.setEmail(isChecked);
			}
		});
	}
	
	

}
