package com.example.houjie.studyapk.studyuithread;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by houjie on 2016/4/21.
 */
class ProgressUIThread extends AsyncTask<String,Integer,String> {
    private int i = 0;
    private Button button;
    private ProgressBar progressBar;

    public ProgressUIThread(Button button, ProgressBar progressBar) {
        this.button = button;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(String... params) {
        while (i<100){
            i++;
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return "下载成功";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setProgress(0);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        button.setText(s);
        button.setClickable(true);
    }

}
