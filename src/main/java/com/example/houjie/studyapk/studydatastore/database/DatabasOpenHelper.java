package com.example.houjie.studyapk.studydatastore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by houjie on 2016/4/24.
 */
public class DatabasOpenHelper extends SQLiteOpenHelper{

    private static final String DbName = "student";
    private static  final String CTEATE_ATUDENT = "create table students("
            +"_id integer primary key autoincrement, "
            +"name text, "
            +"sex text, "
            +"age text)";
    public DatabasOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(CTEATE_ATUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
