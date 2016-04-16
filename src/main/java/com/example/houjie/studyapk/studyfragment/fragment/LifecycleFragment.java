package com.example.houjie.studyapk.studyfragment.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houjie.studyapk.R;

/**
 * Created by houjie on 2016/4/10.
 */
public class LifecycleFragment extends Fragment{
    private  final String TAG ="LifecycleFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"Fragment onCreateView");
        return inflater.inflate(R.layout.layout_only_textview,null);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG,"Fragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"Fragment onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"Fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"Fragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"Fragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Fragment onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"Fragment onDetach");
    }

}
