package com.example.houjie.studyapk.studytocastdialogwindow.tocast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ActivityToast extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private  int i=0;
    private int[] image = {R.mipmap.ic_launcher,R.mipmap.helloword};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdw_toast);
        button1= (Button) findViewById(R.id.imageTocast);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(i>=image.length){
                        i=0;
                    }
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.layout_only_imageview,null);
                    ImageView imageView = (ImageView) layout.findViewById(R.id.OnlyImageView);
                    imageView.setImageResource(image[i]);
                    Toast toast = new Toast(getApplicationContext());
                    //toast.setText("你好");
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                    i++;
                }
        });
        button2= (Button) findViewById(R.id.testTocast);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast =Toast.makeText(getApplicationContext(),
                        "helloword!",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,120,120);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView imageViewCode = new ImageView(ActivityToast.this);
                imageViewCode.setImageResource(R.mipmap.ic_launcher);
                toastView.addView(imageViewCode,0);
                toast.show();
            }
        });
    }
}
