// Generated code from Butter Knife. Do not modify!
package com.exam.ph.examination.firstpage;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.exam.ph.examination.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131492992;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mIvLandscapeBanner = Utils.findRequiredViewAsType(source, R.id.ivLandscapeBanner, "field 'mIvLandscapeBanner'", ImageView.class);
    target.mIvBannerPortrait = Utils.findRequiredViewAsType(source, R.id.ivBannerPortrait, "field 'mIvBannerPortrait'", ImageView.class);
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'mTvName'", TextView.class);
    target.mTvGenre = Utils.findRequiredViewAsType(source, R.id.tvGenre, "field 'mTvGenre'", TextView.class);
    target.mTvAdvisory = Utils.findRequiredViewAsType(source, R.id.tvAdvisory, "field 'mTvAdvisory'", TextView.class);
    target.mTvDuration = Utils.findRequiredViewAsType(source, R.id.tvDuration, "field 'mTvDuration'", TextView.class);
    target.mTvReleaseDate = Utils.findRequiredViewAsType(source, R.id.tvReleaseDate, "field 'mTvReleaseDate'", TextView.class);
    target.mTvSynopsis = Utils.findRequiredViewAsType(source, R.id.tvSynopsis, "field 'mTvSynopsis'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnProceed, "field 'mBtnProceed' and method 'onViewClicked'");
    target.mBtnProceed = Utils.castView(view, R.id.btnProceed, "field 'mBtnProceed'", Button.class);
    view2131492992 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.mProgBar = Utils.findRequiredViewAsType(source, R.id.progBar, "field 'mProgBar'", ProgressBar.class);
    target.mTvCast = Utils.findRequiredViewAsType(source, R.id.tvCast, "field 'mTvCast'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIvLandscapeBanner = null;
    target.mIvBannerPortrait = null;
    target.mTvName = null;
    target.mTvGenre = null;
    target.mTvAdvisory = null;
    target.mTvDuration = null;
    target.mTvReleaseDate = null;
    target.mTvSynopsis = null;
    target.mBtnProceed = null;
    target.mProgBar = null;
    target.mTvCast = null;

    view2131492992.setOnClickListener(null);
    view2131492992 = null;
  }
}
