package com.example.houjie.studyapk.studyview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ViewSeekBar extends AppCompatActivity {
     private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_login_seekbar);
        seekBar = (SeekBar)findViewById(R.id.ViewSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(ViewSeekBar.this,"当前进度"+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewSeekBar.this,"开始拖动",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewSeekBar.this,"拖动结束",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
