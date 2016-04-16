package com.example.houjie.studyapk.studyintent.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.houjie.studyapk.R;

public class BackActivity extends AppCompatActivity {
    private Button btn;
    private EditText ett;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_back);
        btn = (Button) findViewById(R.id.IntentBackButton1);
        ett = (EditText) findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=ett.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("text",str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
