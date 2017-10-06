// Generated code from Butter Knife. Do not modify!
package com.exam.ph.examination.secondpage;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import by.anatoldeveloper.hallscheme.view.ZoomableImageView;
import com.exam.ph.examination.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SecondPageActivity_ViewBinding implements Unbinder {
  private SecondPageActivity target;

  @UiThread
  public SecondPageActivity_ViewBinding(SecondPageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SecondPageActivity_ViewBinding(SecondPageActivity target, View source) {
    this.target = target;

    target.mTvTheater = Utils.findRequiredViewAsType(source, R.id.tvTheater, "field 'mTvTheater'", TextView.class);
    target.mSpnFirst = Utils.findRequiredViewAsType(source, R.id.spnFirst, "field 'mSpnFirst'", Spinner.class);
    target.mSpnSecond = Utils.findRequiredViewAsType(source, R.id.spnSecond, "field 'mSpnSecond'", Spinner.class);
    target.mSpnThird = Utils.findRequiredViewAsType(source, R.id.spnThird, "field 'mSpnThird'", Spinner.class);
    target.mZoomableImage = Utils.findRequiredViewAsType(source, R.id.zoomable_image, "field 'mZoomableImage'", ZoomableImageView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'mProgressBar'", ProgressBar.class);
    target.mLlContainer1 = Utils.findRequiredViewAsType(source, R.id.llContainer1, "field 'mLlContainer1'", LinearLayout.class);
    target.mLlContainer2 = Utils.findRequiredViewAsType(source, R.id.llContainer2, "field 'mLlContainer2'", LinearLayout.class);
    target.mTvTotal = Utils.findRequiredViewAsType(source, R.id.tvTotal, "field 'mTvTotal'", TextView.class);
    target.mTvLabelSeat = Utils.findRequiredViewAsType(source, R.id.tvLabelSeat, "field 'mTvLabelSeat'", TextView.class);
    target.mTvLabel = Utils.findRequiredViewAsType(source, R.id.tvLabel, "field 'mTvLabel'", TextView.class);
    target.mMainLayout = Utils.findRequiredViewAsType(source, R.id.mainLayout, "field 'mMainLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SecondPageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTheater = null;
    target.mSpnFirst = null;
    target.mSpnSecond = null;
    target.mSpnThird = null;
    target.mZoomableImage = null;
    target.mProgressBar = null;
    target.mLlContainer1 = null;
    target.mLlContainer2 = null;
    target.mTvTotal = null;
    target.mTvLabelSeat = null;
    target.mTvLabel = null;
    target.mMainLayout = null;
  }
}
