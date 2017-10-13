package com.exam.ph.examination.firstpage;

import com.exam.ph.examination.restclient.restinterface.TestInterface;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<TestInterface> mTestInterfaceProvider;

  private final Provider<MainActivityPresenter> mMainActivityPresenterProvider;

  public MainActivity_MembersInjector(
      Provider<TestInterface> mTestInterfaceProvider,
      Provider<MainActivityPresenter> mMainActivityPresenterProvider) {
    assert mTestInterfaceProvider != null;
    this.mTestInterfaceProvider = mTestInterfaceProvider;
    assert mMainActivityPresenterProvider != null;
    this.mMainActivityPresenterProvider = mMainActivityPresenterProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<TestInterface> mTestInterfaceProvider,
      Provider<MainActivityPresenter> mMainActivityPresenterProvider) {
    return new MainActivity_MembersInjector(mTestInterfaceProvider, mMainActivityPresenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.exam.ph.examination.BaseActivity_MembersInjector.injectMTestInterface(
        instance, mTestInterfaceProvider);
    instance.mMainActivityPresenter = mMainActivityPresenterProvider.get();
  }

  public static void injectMMainActivityPresenter(
      MainActivity instance, Provider<MainActivityPresenter> mMainActivityPresenterProvider) {
    instance.mMainActivityPresenter = mMainActivityPresenterProvider.get();
  }
}
