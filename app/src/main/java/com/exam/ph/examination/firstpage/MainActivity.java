package com.exam.ph.examination.firstpage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.exam.ph.examination.BaseActivity;
import com.exam.ph.examination.R;
import com.exam.ph.examination.Utils.BaseUtil;
import com.exam.ph.examination.Utils.UiUtil;
import com.exam.ph.examination.models.MovieResponse;
import com.exam.ph.examination.repository.DataRepository;
import com.exam.ph.examination.restclient.LoadAction;
import com.exam.ph.examination.secondpage.SecondPageActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {


    @BindView(R.id.ivLandscapeBanner)
    ImageView mIvLandscapeBanner;

    @BindView(R.id.ivBannerPortrait)
    ImageView mIvBannerPortrait;

    @BindView(R.id.tvName)
    TextView mTvName;

    @BindView(R.id.tvGenre)
    TextView mTvGenre;

    @BindView(R.id.tvAdvisory)
    TextView mTvAdvisory;

    @BindView(R.id.tvDuration)
    TextView mTvDuration;

    @BindView(R.id.tvReleaseDate)
    TextView mTvReleaseDate;

    @BindView(R.id.tvSynopsis)
    TextView mTvSynopsis;

    @BindView(R.id.btnProceed)
    Button mBtnProceed;

    @BindView(R.id.progBar)
    ProgressBar mProgBar;

    private DataRepository mDataRepository;

    private MovieResponse mMovieResponse;

    private MainActivityPresenterImpl mMainActivityPresenter;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivityPresenter = new MainActivityPresenterImpl();
        mMainActivityPresenter.attachView(this);
        initialize();

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mMainActivityPresenter.loadData(mTestInterface, LoadAction.LOAD_MOVIE);
                }
            });
        }
    }

    private void initialize() {
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mMainActivityPresenter.loadData(mTestInterface, LoadAction.LOAD_MOVIE);
                }
            });
            return;
        }
        mMainActivityPresenter.loadData(mTestInterface, LoadAction.LOAD_MOVIE);
    }


    @Override
    public void showProgress() {
        mProgBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(Object result) {
        if (result instanceof MovieResponse) {
            hideProgress();
            mMovieResponse = (MovieResponse) result;
            if (mMovieResponse != null) {
                BaseUtil.setUpImageGlide(mMovieResponse.getPosterLandscape(), mIvLandscapeBanner, mContext);
                BaseUtil.setUpImageGlide(mMovieResponse.getPoster(), mIvBannerPortrait, mContext);
                mTvName.setText(mMovieResponse.getCanonicalTitle());
                mTvGenre.setText(mMovieResponse.getGenre());
                mTvAdvisory.setText(mMovieResponse.getAdvisoryRating());
                mTvDuration.setText(BaseUtil.convertTime(mMovieResponse.getRuntimeMins()));
                Log.i("laaaaaaaaaaaag", "ian" + BaseUtil.convertTime(mMovieResponse.getRuntimeMins()));
                mTvReleaseDate.setText(mMovieResponse.getReleaseDate());
                mTvSynopsis.setText(mMovieResponse.getSynopsis());
            }
        }
    }

    @Override
    public void showError(String error) {
        hideProgress();
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mMainActivityPresenter.loadData(mTestInterface, LoadAction.LOAD_MOVIE);
                }
            });
        }
    }

    @OnClick(R.id.btnProceed)
    public void onViewClicked() {
        if (mMovieResponse != null)
            startActivity(SecondPageActivity.newIntent(mContext, mMovieResponse.getTheater()));

    }
}
