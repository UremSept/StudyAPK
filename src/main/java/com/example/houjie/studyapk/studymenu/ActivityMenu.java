package com.example.houjie.studyapk.studymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ActivityMenu extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_menu);
        mTextView = (TextView) findViewById(R.id.MenuHello);
        registerForContextMenu(mTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(ActivityMenu.this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(ActivityMenu.this,"设置",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(ActivityMenu.this,"删除",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("我是上下文菜单");
        menu.addSubMenu(0,Menu.FIRST,Menu.NONE,"第一条");
        menu.addSubMenu(0,Menu.FIRST+1,Menu.NONE,"第二条");
        menu.addSubMenu(0,Menu.FIRST+2,Menu.NONE,"第三条");
        menu.addSubMenu(0,Menu.FIRST+3,Menu.NONE,"第四条");
        menu.addSubMenu(0,Menu.FIRST+4,Menu.NONE,"第五条");



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:
                Toast.makeText(ActivityMenu.this,"第一条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+1:
                Toast.makeText(ActivityMenu.this,"第二条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+2:
                Toast.makeText(ActivityMenu.this,"第三条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+3:
                Toast.makeText(ActivityMenu.this,"第四条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+4:
                Toast.makeText(ActivityMenu.this,"第五条",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
