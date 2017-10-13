package com.exam.ph.examination.dagger;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.exam.ph.examination.BaseActivity;
import com.exam.ph.examination.firstpage.MainActivity;
import com.exam.ph.examination.secondpage.SecondPageActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ian.blanco on 10/13/2017.
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(SecondPageActivity activity);

    void inject(BaseActivity activity);
}
