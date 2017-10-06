package com.exam.ph.examination.secondpage;

import com.exam.ph.examination.BaseViewPresenter;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public interface SecondPagePresenter extends BaseViewPresenter{

    void attachView(SecondPageView secondPageView);
    void calculateTotal(int total, int price);

}
