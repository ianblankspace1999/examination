package com.exam.ph.examination.firstpage;

import android.util.Log;

import com.exam.ph.examination.Utils.BaseView;
import com.exam.ph.examination.repository.DataRepository;
import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    MainView mMainView;
    DataRepository mDataRepository;

    @Override
    public void loadData(TestInterface testInterface, LoadAction loadAction) {
    if(mMainView != null) {
        mDataRepository = new DataRepository();
        mMainView.showProgress();
        mDataRepository.getMovies(testInterface).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(result ->   mMainView.showSuccess(result),
                        throwable ->   mMainView.showError(throwable.toString()),
                        () -> Log.i("api", "api request completed --> " ));
    }
    }


    @Override
    public void attachView(MainView mainView) {
    mMainView = mainView;
    }

    @Override
    public void detachView() {
    mMainView = null;
    }
}
