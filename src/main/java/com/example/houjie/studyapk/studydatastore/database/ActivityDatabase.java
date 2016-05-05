package com.example.houjie.studyapk.studydatastore.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityDatabase extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd;
    private Button buttonDelete;
    private Button buttonUpdate;
    private Button buttonQuery;
    private Button buttonAdapter;
    private ListView listView;
    private SQLiteDatabase db;
    private StudentsDatabase SDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store_database);
        buttonAdd = (Button) findViewById(R.id.btnDatabaseAdd);
        buttonAdd.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.btnDatabaseDelete);
        buttonDelete.setOnClickListener(this);
        buttonUpdate = (Button) findViewById(R.id.btnDatabaseUpdate);
        buttonUpdate.setOnClickListener(this);
        buttonQuery = (Button) findViewById(R.id.btnDatabaseQuery);
        buttonQuery.setOnClickListener(this);
        buttonAdapter = (Button) findViewById(R.id.btnDatabaseAdapter);
        buttonAdapter.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listviewDatabase);
        DatabasOpenHelper databasOpenHelper =new DatabasOpenHelper(this,"student",null,1);
        db = databasOpenHelper.getWritableDatabase();
        SDb = new StudentsDatabase(db);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDatabaseAdd:Add();break;
            case R.id.btnDatabaseDelete:Delete();break;
            case R.id.btnDatabaseUpdate:Update();break;
            case R.id.btnDatabaseQuery:Query();break;
            case R.id.btnDatabaseAdapter:Adapter();break;

        }
    }

    private void Adapter() {
        Intent i = new Intent(ActivityDatabase.this,ActivityDatabaseAdapter.class);
        startActivity(i);

    }

    private void Query() {
        List<Student> ls = new ArrayList<>();
        ls=SDb.query();
        DatabaseListViewAdapter dlv = new DatabaseListViewAdapter(this,ls);
        listView.setAdapter(dlv);
    }

    private void Update() {
        Student student1 =new Student("张三5","男","298");
        SDb.update(student1);
        Toast.makeText(ActivityDatabase.this, "更新成功", Toast.LENGTH_SHORT).show();
    }

    private void Delete() {
        Student student1 =new Student("张三1","男","25");
        SDb.delete(student1);
        Toast.makeText(ActivityDatabase.this, "删除成功", Toast.LENGTH_SHORT).show();
    }

    private void Add() {
        Student student =new Student("张三","男","25");
        Student student1 =new Student("张三1","男","25");
        Student student2 =new Student("张三2","男","25");
        Student student3 =new Student("张三3","男","25");
        Student student4 =new Student("张三4","男","25");
        Student student5 =new Student("张三5","男","25");
        Student student6 =new Student("张三6","男","25");
        Student student7 =new Student("张三7","男","25");
        Student student8 =new Student("张三8","男","25");
        SDb.add(student);
        SDb.add(student1);
        SDb.add(student2);
        SDb.add(student3);
        SDb.add(student4);
        SDb.add(student5);
        SDb.add(student6);
        SDb.add(student7);
        SDb.add(student8);
        Toast.makeText(ActivityDatabase.this, "添加成功", Toast.LENGTH_SHORT).show();

    }
}
