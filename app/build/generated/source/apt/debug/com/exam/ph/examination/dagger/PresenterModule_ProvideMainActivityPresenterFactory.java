package com.exam.ph.examination.dagger;

import com.exam.ph.examination.firstpage.MainActivityPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PresenterModule_ProvideMainActivityPresenterFactory
    implements Factory<MainActivityPresenter> {
  private final PresenterModule module;

  public PresenterModule_ProvideMainActivityPresenterFactory(PresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MainActivityPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMainActivityPresenter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainActivityPresenter> create(PresenterModule module) {
    return new PresenterModule_ProvideMainActivityPresenterFactory(module);
  }
}
