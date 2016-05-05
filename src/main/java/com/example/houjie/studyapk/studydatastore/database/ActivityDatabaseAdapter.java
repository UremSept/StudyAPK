package com.example.houjie.studyapk.studydatastore.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.houjie.studyapk.R;

import java.util.List;


public class ActivityDatabaseAdapter extends AppCompatActivity {
    private ListView listView;
    private SQLiteDatabase db;
    private StudentsDatabase SDb;
    private List<Student> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store_database_adapter);
        listView = (ListView) findViewById(R.id.databaseadapterlistview);
        DatabasOpenHelper databasOpenHelper =new DatabasOpenHelper(this,"student",null,1);
        db = databasOpenHelper.getWritableDatabase();
        SDb = new StudentsDatabase(db);
        mList = SDb.query();
        Cursor cursor  =SDb.cQuery();
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(ActivityDatabaseAdapter.this,
                R.layout.layout_data_store_database_listview_adapter,cursor,new String[]{"name","sex","age"}
                ,new int[]{R.id.databaselistname,R.id.databaselistsex,R.id.databaselistage});
        listView.setAdapter(simpleCursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Intent intent = new Intent(ActivityDatabaseAdapter.this,ActivityDatabaseSerializable.class);

            }
        });
    }
}
