package com.exam.ph.examination.secondpage;

import android.util.Log;

import com.exam.ph.examination.repository.DataRepository;
import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public class SecondPagePresenterImpl implements SecondPagePresenter {

    SecondPageView mSecondPageView;
    DataRepository mDataRepository;

    @Override
    public void attachView(SecondPageView secondPageView) {
        mSecondPageView = secondPageView;
    }

    @Override
    public void calculateTotal(int totalCount, int price) {
        if (mSecondPageView != null) {
            int total = totalCount * price;
            mSecondPageView.displayTotal(total);
        }
    }

    @Override
    public void loadData(TestInterface testInterface, LoadAction loadAction) {
        if (mSecondPageView != null) {

            mDataRepository = new DataRepository();
            if (loadAction.equals(LoadAction.LOAD_SCHEDULE)) {
                mSecondPageView.showProgress();
                mDataRepository.getSchedules(testInterface).
                        subscribeOn(Schedulers.newThread()).
                        observeOn(AndroidSchedulers.mainThread()).
                        subscribe(result -> mSecondPageView.showSuccess(result),
                                throwable -> mSecondPageView.showError(throwable.toString()),
                                () -> Log.i("api", "api request completed --> "));
            }
            if (loadAction.equals(LoadAction.LOAD_SEATMAP)) {
                mDataRepository.getSeats(testInterface).
                        subscribeOn(Schedulers.newThread()).
                        observeOn(AndroidSchedulers.mainThread()).
                        subscribe(result -> mSecondPageView.showSuccess(result),
                                throwable -> mSecondPageView.showError(throwable.toString()),
                                () -> Log.i("api", "api request completed --> "));
                mSecondPageView.hideProgress();
            }
        }
    }

    @Override
    public void detachView() {

    }
}
