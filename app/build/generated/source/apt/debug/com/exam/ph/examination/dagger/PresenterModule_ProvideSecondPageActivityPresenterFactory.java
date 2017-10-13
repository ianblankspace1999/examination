package com.exam.ph.examination.dagger;

import com.exam.ph.examination.secondpage.SecondPagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PresenterModule_ProvideSecondPageActivityPresenterFactory
    implements Factory<SecondPagePresenter> {
  private final PresenterModule module;

  public PresenterModule_ProvideSecondPageActivityPresenterFactory(PresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SecondPagePresenter get() {
    return Preconditions.checkNotNull(
        module.provideSecondPageActivityPresenter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SecondPagePresenter> create(PresenterModule module) {
    return new PresenterModule_ProvideSecondPageActivityPresenterFactory(module);
  }
}
