package com.example.houjie.studyapk.studyview.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ViewSpinner extends AppCompatActivity {
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spinner);
        mList = new ArrayList<>();
        mList.add("张三");
        mList.add("李四");
        mList.add("王五");
        mList.add("赵六");
        mList.add("石岐");
        mList.add("够吧");
        mList.add("老旧");
        Spinner spinner = (Spinner) findViewById(R.id.testspinner);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ViewSpinner.this,"选择了"+mList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
