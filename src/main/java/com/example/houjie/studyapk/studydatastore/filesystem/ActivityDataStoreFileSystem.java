package com.example.houjie.studyapk.studydatastore.filesystem;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ActivityDataStoreFileSystem extends AppCompatActivity implements View.OnClickListener {
    private EditText fileSystemEditText1;
    private EditText fileSystemEditText2;
    private Button fileSystemBtn1;
    private  Button fileSystemBtn2;
    private static final String FILENAME = "readme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store_file_system);

        fileSystemEditText1 = (EditText) findViewById(R.id.FileSystemEditText1);
        fileSystemEditText2 = (EditText) findViewById(R.id.FileSystemEditText2);
        fileSystemBtn1 = (Button) findViewById(R.id.FileSystemBtn1);
        fileSystemBtn1.setOnClickListener(this);
        fileSystemBtn2 = (Button) findViewById(R.id.FileSystemBtn2);
        fileSystemBtn2.setOnClickListener(this);
        Log.i("============"+ActivityDataStoreFileSystem.this.getFilesDir().getAbsolutePath(),"=======getFilesDir");
        Log.i("============"+ActivityDataStoreFileSystem.this.getFilesDir().getPath(),"=======getFilesDir");
        Log.i("============"+Environment.getExternalStorageDirectory().getAbsolutePath(),"=======ExternalStorageDirectory");
        Log.i("============"+Environment.getExternalStorageDirectory().getPath(),"=======ExternalStorageDirectory");
        Log.i("============"+Environment.getExternalStorageState(),"=======ExternalStorageState");
        Log.i("============"+Environment.getDataDirectory(),"=======DataDirectory");
        Log.i("============"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"=======ExternalStoragePublicDirectory");
        Log.i("============"+Environment.getRootDirectory(),"=======RootDirectory");


    }

    @Override
    public void onClick(View v) {
        File file = new File(Environment.getExternalStorageDirectory(),FILENAME);
        Toast.makeText(ActivityDataStoreFileSystem.this,Environment.getExternalStorageDirectory().getAbsolutePath(), Toast.LENGTH_SHORT).show();

        switch (v.getId()){
            case R.id.FileSystemBtn1:
                String str = Environment.getExternalStorageState();

                if(str.equals(Environment.MEDIA_MOUNTED)){
                    try {
                        OutputStream stream  =new FileOutputStream(file);
                        byte[] bytes = fileSystemEditText1.getText().toString().getBytes();
                        stream.write(bytes);
                        stream.flush();
                        stream.close();
                        Toast.makeText(ActivityDataStoreFileSystem.this, "写入成功", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.FileSystemBtn2:
                String str1 = Environment.getExternalStorageState();
                if (str1.equals(Environment.MEDIA_MOUNTED)){
                    try {
                        InputStream stream1 = new FileInputStream(file);
                        byte[] b = new byte[stream1.available()];
                        stream1.read(b);
                        fileSystemEditText2.setText(new String(b));
                        stream1.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
