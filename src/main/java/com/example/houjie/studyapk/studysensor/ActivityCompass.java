package com.example.houjie.studyapk.studysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityCompass extends AppCompatActivity implements SensorEventListener {
    private ImageView onlyImageView;
    private SensorManager sensorManager;
    private float currentDegree = 0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_imageview);
        onlyImageView = (ImageView) findViewById(R.id.OnlyImageView);
        onlyImageView.setBackgroundResource(R.mipmap.compass);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //传感器管理器
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //注册传感器（sensor.TYPE_ORIENTATION（方向传感器）；SENSOR_DELAY_GAME(20，000延时)；
        // SENSOR_DELAY_GAME(20,000毫秒延迟)、SENSOR_DELAY_UI(60,000毫秒延迟))）
        sensorManager.registerListener(ActivityCompass.this,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
               SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float degree = event.values[0];

            /*
            RotateAnimation类：旋转变化动画类

            参数说明:

            fromDegrees：旋转的开始角度。
            toDegrees：旋转的结束角度。
            pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
            pivotXValue：X坐标的伸缩值。
            pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
            pivotYValue：Y坐标的伸缩值
            */

            RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            //旋转过程持续时间
            ra.setDuration(200);
            //罗盘图片使用旋转动画
            //ra.setFillAfter(true);
            onlyImageView.startAnimation(ra);


            currentDegree = -degree;
        }
        int x = (int) event.values[sensorManager.DATA_X];
        int y = (int) event.values[sensorManager.DATA_Y];
        int z = (int) event.values[sensorManager.DATA_Z];
        Log.e("指南针","---------------X+Y+Z==="+x+"==="+y+"==="+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
