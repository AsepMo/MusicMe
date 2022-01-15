package com.audio.story;
 
import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.audio.story.application.MusicBrowserActivity;
public class SplashActivity extends Activity { 
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new CountDownTimer(2000, 2000){
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                //Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();       

                Intent mIntent = new Intent(SplashActivity.this, MusicBrowserActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mIntent);
                SplashActivity.this.finish();
            }  
        }.start();
    }
	
} 
/*don't forget to subscribe my YouTube channel for more Tutorial and mod*/
/*
https://youtube.com/channel/UC_lCMHEhEOFYgJL6fg1ZzQA */
