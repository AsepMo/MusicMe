package com.audio.story.application;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.audio.story.R;
import com.audio.story.engine.app.utils.MusicUtils;
import com.audio.story.engine.widget.VerticalTextSpinner;

public class WeekSelector extends Activity
{
    VerticalTextSpinner mWeeks;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weekpicker);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                    WindowManager.LayoutParams.WRAP_CONTENT);

        mWeeks = (VerticalTextSpinner)findViewById(R.id.weeks);
        mWeeks.setItems(getResources().getStringArray(R.array.weeklist));
        mWeeks.setWrapAround(false);
        mWeeks.setScrollInterval(200);
        
        int def = MusicUtils.getIntPref(this, "numweeks", 2); 
        int pos = icicle != null ? icicle.getInt("numweeks", def - 1) : def - 1;
        mWeeks.setSelectedPos(pos);
        
        ((Button) findViewById(R.id.set)).setOnClickListener(mListener);
        
        ((Button) findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
    
    @Override
    public void onSaveInstanceState(Bundle outcicle) {
        outcicle.putInt("numweeks", mWeeks.getCurrentSelectedPos());
    }
    
    @Override
    public void onResume() {
        super.onResume();
    }
    
    private View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View v) {
            int numweeks = mWeeks.getCurrentSelectedPos() + 1;
            MusicUtils.setIntPref(WeekSelector.this, "numweeks", numweeks);
            setResult(RESULT_OK);
            finish();
        }
    };
}
