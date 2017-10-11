package com.exam.ph.examination.secondpage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.exam.ph.examination.BaseActivity;
import com.exam.ph.examination.R;
import com.exam.ph.examination.Utils.BaseUtil;
import com.exam.ph.examination.Utils.ModelUtil;
import com.exam.ph.examination.Utils.UiUtil;
import com.exam.ph.examination.Utils.scheme.SeatExample;
import com.exam.ph.examination.models.CreatedSeats;
import com.exam.ph.examination.models.ScheduleResponse;
import com.exam.ph.examination.models.SeatResponse;
import com.exam.ph.examination.models.schedulemodel.CinemaInfo;
import com.exam.ph.examination.models.schedulemodel.Cinemas;
import com.exam.ph.examination.models.schedulemodel.Dates;
import com.exam.ph.examination.models.schedulemodel.Times;
import com.exam.ph.examination.models.schedulemodel.TimesInfo;
import com.exam.ph.examination.restclient.LoadAction;

import java.util.ArrayList;

import butterknife.BindView;
import by.anatoldeveloper.hallscheme.hall.HallScheme;
import by.anatoldeveloper.hallscheme.hall.ScenePosition;
import by.anatoldeveloper.hallscheme.hall.Seat;
import by.anatoldeveloper.hallscheme.hall.SeatListener;
import by.anatoldeveloper.hallscheme.view.ZoomableImageView;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public class SecondPageActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, SecondPageView {


    @BindView(R.id.tvTheater)
    TextView mTvTheater;

    @BindView(R.id.spnFirst)
    Spinner mSpnFirst;

    @BindView(R.id.spnSecond)
    Spinner mSpnSecond;

    @BindView(R.id.spnThird)
    Spinner mSpnThird;

    @BindView(R.id.zoomable_image)
    ZoomableImageView mZoomableImage;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.llContainer1)
    LinearLayout mLlContainer1;

    @BindView(R.id.llContainer2)
    LinearLayout mLlContainer2;

    @BindView(R.id.tvTotal)
    TextView mTvTotal;

    @BindView(R.id.tvLabelSeat)
    TextView mTvLabelSeat;

    @BindView(R.id.tvLabel)
    TextView mTvLabel;

    @BindView(R.id.mainLayout)
    FrameLayout mMainLayout;


    private ScheduleResponse mScheduleResponse;
    private SeatResponse mSeatResponse;

    //String Array
    private ArrayList<String> mDateArr = new ArrayList<>();
    private ArrayList<String> mDateArrConverted = new ArrayList<>();
    private ArrayList<String> mCinemasArr = new ArrayList<>();
    private ArrayList<String> mTimesArr = new ArrayList<>();
    // Object Array
    private ArrayList<TimesInfo> timesInfo = new ArrayList<>();
    private ArrayList<CinemaInfo> cinemaInfos = new ArrayList<>();

    private SecondPagePresenterImpl mSecondPagePresenterImpl;

    //    storage of all selected seats
    ArrayList<CreatedSeats> mSelectedSeats = new ArrayList<>();

    //    Storage of all available seats
    ArrayList<CreatedSeats> mCreatedSeats = new ArrayList<>();

    ArrayList<View> mTextViews = new ArrayList<>();

    private int spnFirstPosition = 0, spnSecondPosition = 0, spnThirdPosition = 0;

    public static String ARGS_THEATER = "ARGS_THEATER";

    private String mTheater = "";

    String[] alphabetArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private DialogInterface.OnClickListener onClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mSecondPagePresenterImpl.loadData(mTestInterface, LoadAction.LOAD_SCHEDULE);
        }
    };

    public static Intent newIntent(Context context, String theater) {
        Intent intent = new Intent(context, SecondPageActivity.class);
        intent.putExtra(ARGS_THEATER, theater);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_second;
    }

    @Override
    protected DialogInterface.OnClickListener getListner() {
        return onClick;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSecondPagePresenterImpl = new SecondPagePresenterImpl();
        mSecondPagePresenterImpl.attachView(this);
        mTheater = getIntent().getExtras().getString(ARGS_THEATER);
        initialize();
    }


    private void initialize() {
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mSecondPagePresenterImpl.loadData(mTestInterface, LoadAction.LOAD_SCHEDULE);
                }
            });
            return;
        }

        mTvTheater.setText(mTheater);
        mSecondPagePresenterImpl.loadData(mTestInterface, LoadAction.LOAD_SCHEDULE);


//        Setup spinner
        mSpnFirst.setOnItemSelectedListener(this);
        mSpnSecond.setOnItemSelectedListener(this);
        mSpnThird.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;

        if (spinner.getId() == R.id.spnFirst) {
            if (mScheduleResponse != null) {
//            For Cinema
                spnFirstPosition = position;
                cinemaInfos = new ArrayList<>();
                for (Cinemas cinemas : mScheduleResponse.getCinemas()) {
                    if (cinemas.getParent().equals(mDateArr.get(position).replace("-", ""))) {
                        cinemaInfos = new ArrayList<>(cinemas.getCinemaInfos());
                    }
                }
                mCinemasArr = new ArrayList<>();
                try {
                    for (CinemaInfo cinemaInfo : cinemaInfos) {
                        mCinemasArr.add(cinemaInfo.getLabel());
                    }
                }catch (NullPointerException ex) {
//                    Nullpointer
                }
                BaseUtil.setSpinner(mContext, mSpnSecond, mCinemasArr);

//             For Times
                timesInfo = new ArrayList<>();
                for (Times times : mScheduleResponse.getTimes()) {
                    try {
                        if (times.getParent().equals(cinemaInfos.get(0).getId())) {
                            timesInfo = new ArrayList<>(times.getTimesInfos());
                        }
                    } catch (IndexOutOfBoundsException ex) {
//                        Do nothing
                    }
                }
                mTimesArr = new ArrayList<>();
                try {
                    mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(0).getPrice());
                }catch (IndexOutOfBoundsException ex) {
//                    do nothing
                }
                for (TimesInfo timesInfo1 : timesInfo) {
                    mTimesArr.add(timesInfo1.getLabel());
                }

                BaseUtil.setSpinner(mContext, mSpnThird, mTimesArr);

            }
        }

        if (spinner.getId() == R.id.spnSecond) {
            spnSecondPosition = position;
//             For Times
            timesInfo = new ArrayList<>();
            for (Times times : mScheduleResponse.getTimes()) {
                try {
                    if (times.getParent().equals(cinemaInfos.get(spnFirstPosition).getId())) {
                        timesInfo = new ArrayList<>(times.getTimesInfos());
                    }
                } catch (IndexOutOfBoundsException ex) {
//                        Do nothing
                }
            }
            mTimesArr = new ArrayList<>();
            mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(0).getPrice());
            try {
                for (TimesInfo timesInfo1 : timesInfo) {
                    mTimesArr.add(timesInfo1.getLabel());
                }
            }catch (NullPointerException ex) {
//                Do nothing
            }
            BaseUtil.setSpinner(mContext, mSpnThird, mTimesArr);

        }

        if (spinner.getId() == R.id.spnThird) {
            mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(position).getPrice());
            spnThirdPosition = position;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void showSuccess(Object result) {
        if (result instanceof ScheduleResponse) {
            mScheduleResponse = (ScheduleResponse) result;
            mDateArr = new ArrayList<>();
            mDateArrConverted = new ArrayList<>();
            for (Dates date : mScheduleResponse.getDates()) {
                mDateArr.add(date.getDate());
                mDateArrConverted.add(BaseUtil.getDate(date.getDate()));
            }

            BaseUtil.setSpinner(mContext, mSpnFirst, mDateArrConverted);
            mSecondPagePresenterImpl.loadData(mTestInterface, LoadAction.LOAD_SEATMAP);
        }

        if (result instanceof SeatResponse) {
            mSeatResponse = (SeatResponse) result;

            Log.i("Result", ModelUtil.toJsonString(mSeatResponse));
            if (mSeatResponse != null) {
                HallScheme scheme = new HallScheme(mZoomableImage, schemeWithScene(mSeatResponse), mContext);
                scheme.setSceneName("    Movie Screen   ");
                scheme.setSceneBackgroundColor(mContext.getResources().getColor(R.color.white));
                scheme.setBackgroundColor(mContext.getResources().getColor(R.color.white));
                scheme.setChosenSeatBackgroundColor(Color.parseColor("#ed1515"));
                scheme.setUnavailableSeatBackgroundColor(Color.parseColor("#134fc6"));
                scheme.setScenePosition(ScenePosition.NORTH);
                scheme.setMaxSelectedSeats(10);
                scheme.setMaxSeatsClickListener(max -> UiUtil.showToastLong(mContext, "seats max 10"));
                scheme.setSeatListener(new SeatListener() {


                    @Override
                    public void selectSeat(int id) {

                        for (CreatedSeats createdSeats : mCreatedSeats)
                            if (createdSeats.getId() == id) {

                                if (mLlContainer1.getChildCount() < 5) {
                                    mLlContainer1.addView(createdSeats.getViewDisplay(mContext));
                                    mSelectedSeats.add(createdSeats);
                                    mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(spnThirdPosition).getPrice());
                                    mTvLabelSeat.setVisibility(mSelectedSeats.size() > 0 ? View.VISIBLE : View.GONE);
                                    return;
                                }
                                mLlContainer2.addView(createdSeats.getViewDisplay(mContext));
                                mSelectedSeats.add(createdSeats);
                                mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(spnThirdPosition).getPrice());
                                mTvLabelSeat.setVisibility(mSelectedSeats.size() > 0 ? View.VISIBLE : View.GONE);

                            }


                    }

                    @Override
                    public void unSelectSeat(int id) {
                        int i = 0;
                        for (CreatedSeats createdSeats : mSelectedSeats) {
                            i++;

                            if (createdSeats.getId() == id) {
//                                mLlContainer1.removeView(findViewById(id));
//                                mLlContainer2.removeView(findViewById(id));
                                mLlContainer1.removeAllViews();
                                mLlContainer2.removeAllViews();

                                mSelectedSeats.remove(createdSeats);
                                mSecondPagePresenterImpl.calculateTotal(mSelectedSeats.size(), timesInfo.get(spnThirdPosition).getPrice());
                                for (CreatedSeats createdSeats1 : mSelectedSeats) {
                                    int sample = mLlContainer1.getChildCount();
                                    if (mLlContainer1.getChildCount() < 5) {
                                        mLlContainer1.addView(createdSeats1.getViewDisplay(mContext));

                                    } else {
                                        mLlContainer2.addView(createdSeats1.getViewDisplay(mContext));
                                    }
                                }
                                mTvLabelSeat.setVisibility(mSelectedSeats.size() > 0 ? View.VISIBLE : View.GONE);
                                break;
                            }
                        }
                    }

                });

            }
        }

    }

    @Override
    public void showError(String error) {
        if (!networkHelper.isNetworkAvailable()) {
            UiUtil.dialogWithOnClick(mContext, "No Internet connection!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mSecondPagePresenterImpl.loadData(mTestInterface, LoadAction.LOAD_SCHEDULE);
                }
            });
            return;
        }
    }


    public Seat[][] schemeWithScene(SeatResponse seatResponse) {
        Seat seats[][];
        try {
            seats = new Seat[seatResponse.getSeatmap().size()][seatResponse.getSeatmap().get(0).size() + 2];
        } catch (IndexOutOfBoundsException ex) {
            seats = new Seat[0][0];
        }

        int k = 0;
        for (int i = 0; i < seats.length; i++)
            for (int j = 0; j < seats[i].length; j++) {

                SeatExample seat = new SeatExample();
                seat.id = ++k;
                seat.selectedSeatMarker = "✓";
                seat.status = HallScheme.SeatStatus.EMPTY;

                if (j == 0 || j == seats[i].length - 1) {
                    try {
                        seat.marker = alphabetArr[i];
                    }catch (IndexOutOfBoundsException ex) {
                        seat.marker = "";
                    }
                    seat.status = HallScheme.SeatStatus.INFO;
                } else {
                    if (!seatResponse.getSeatmap().get(i).get(j - 1).contains("(")) {
                        CreatedSeats createdSeats = new CreatedSeats(seat.id, seatResponse.getSeatmap().get(i).get(j - 1));
                        mCreatedSeats.add(createdSeats);
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.rgb(137, 138, 140);

                        if (!seatResponse.getAvailable().getSeats().contains(seatResponse.getSeatmap().get(i).get(j - 1)))
                            seat.status = HallScheme.SeatStatus.BUSY;

                    }

                }
                seats[i][j] = seat;
            }


        return seats;
    }

    @Override
    public void displayTotal(int total) {
        mTvTotal.setText(BaseUtil.convertStringWithComma("" + total));
        mTvTotal.setVisibility(total == 0 ? View.GONE : View.VISIBLE);
        mTvLabel.setVisibility(total == 0 ? View.GONE : View.VISIBLE);
    }
}
