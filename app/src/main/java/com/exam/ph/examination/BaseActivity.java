package com.exam.ph.examination;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.exam.ph.examination.Utils.NetworkHelper;
import com.exam.ph.examination.Utils.UiUtil;
import com.exam.ph.examination.restclient.Rest;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import butterknife.ButterKnife;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected Context mContext;
    protected TestInterface mTestInterface;

    protected NetworkHelper networkHelper;


    protected abstract int getLayoutResource();


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        networkHelper = new NetworkHelper(mContext);
        mTestInterface = Rest.create(mContext, TestInterface.class);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);


    }



}
