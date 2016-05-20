package com.example.houjie.studyapk.studysensor;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

import java.sql.BatchUpdateException;
import java.util.List;

public class ActivitySensor extends AppCompatActivity {
    private Button sensorShowAllBtn,sensorCompassBtn;
    private TextView sensorShowAllTextView;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sensorShowAllBtn = (Button) findViewById(R.id.sensorShowAllBtn);
        sensorShowAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
                List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
                sensorShowAllTextView.setText("手机中传感器的数量"+sensorList.size()+"\n");
                for (Sensor s:sensorList){
                    String str = sensorShowAllTextView.getText().toString()+"传感器的名字"+s.getName()+
                            "传感器版本"+s.getVersion()+"传感器的供应商"+s.getVendor();
                    switch (s.getType()){
                        case Sensor.TYPE_ACCELEROMETER:
                            sensorShowAllTextView.setText(str);
                            break;
                    }
                }
            }
        });
        sensorShowAllTextView = (TextView) findViewById(R.id.sensorShowAllTextView);
        sensorCompassBtn = (Button) findViewById(R.id.sensorCompassBtn);
        sensorCompassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivitySensor.this,ActivityCompass.class);
                startActivity(intent);
            }
        });

    }
}
