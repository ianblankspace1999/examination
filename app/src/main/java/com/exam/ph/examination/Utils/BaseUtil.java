package com.exam.ph.examination.Utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.layout.simple_spinner_item;

/**
 * Created by ian.blanco on 10/4/2017.
 */

public class BaseUtil {

    public static String convertTime(int time) {
        int hour = time / 60;

        int mins = time % 60;


        return mins == 0 ? hour + " Hrs" : hour + " " + mins + " Hrs";
    }


    public static void setSpinner(Context context, Spinner spinner, ArrayList<String> stringArr) {

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, simple_spinner_item, stringArr);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }




    public static void setUpImageGlide(String url, ImageView imageView, Context context) {

        Log.i("url", "url: " + url);


        Glide.with(context)
                .load(url)
//                    .error(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.d("error loading image", "erro " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        imageView.setImageDrawable(resource);
                        Log.d("error loading image", "success");
                        return false;
                    }
                })
                .into(imageView);


    }

    public static String convertStringWithComma(String price) {
        String original = "" + price;
        String converted = "";

        int counter = 0;
        for (int i = original.length() - 1; i >= 0; i--) {
            counter += 1;
            converted = counter % 3 == 0 ? "," + original.substring(i, i + 1) + converted  : "" + original.substring(i, i + 1) + converted;
        }

        converted = converted.substring(0, 1).equals(",") ? converted.substring(1) : converted;
        return converted + ".00";
    }


    public static String getDate(String getDate) {
        String dateString = getDate;
        Log.i("date", "getDate" + getDate);
        Date convertedDate = new Date();
        try {
            convertedDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String dateFormatted = (new SimpleDateFormat("yyyy-MM-dd-EEE")).format(convertedDate);

        String month = "";

        String[] dateExplode = dateFormatted.split("-");

        if (dateExplode[1].equals("01")) {
            month = "Jan";
        }

        if (dateExplode[1].equals("02")) {
            month = "Feb";
        }

        if (dateExplode[1].equals("03")) {
            month = "Mar";
        }

        if (dateExplode[1].equals("04")) {
            month = "Apr";
        }

        if (dateExplode[1].equals("05")) {
            month = "May";
        }

        if (dateExplode[1].equals("06")) {
            month = "Jun";
        }

        if (dateExplode[1].equals("07")) {
            month = "Jul";
        }

        if (dateExplode[1].equals("08")) {
            month = "Aug";
        }

        if (dateExplode[1].equals("09")) {
            month = "Sep";
        }

        if (dateExplode[1].equals("10")) {
            month = "Oct";
        }

        if (dateExplode[1].equals("11")) {
            month = "Nov";
        }

        if (dateExplode[1].equals("12")) {
            month = "Dec";
        }


        return month + " " + dateExplode[2] + ", " + dateExplode[3];
    }

}
