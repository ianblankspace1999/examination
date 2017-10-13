package com.exam.ph.examination.dagger;

import com.exam.ph.examination.firstpage.MainActivityPresenter;
import com.exam.ph.examination.firstpage.MainActivityPresenterImpl;
import com.exam.ph.examination.secondpage.SecondPagePresenter;
import com.exam.ph.examination.secondpage.SecondPagePresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ian.blanco on 10/13/2017.
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenterImpl();
    }

    @Provides
    @Singleton
    SecondPagePresenter provideSecondPageActivityPresenter() {
        return new SecondPagePresenterImpl();
    }
}
