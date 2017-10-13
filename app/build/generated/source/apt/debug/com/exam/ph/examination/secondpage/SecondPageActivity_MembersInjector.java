package com.exam.ph.examination.secondpage;

import com.exam.ph.examination.restclient.restinterface.TestInterface;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SecondPageActivity_MembersInjector
    implements MembersInjector<SecondPageActivity> {
  private final Provider<TestInterface> mTestInterfaceProvider;

  private final Provider<SecondPagePresenter> mSecondPagePresenterImplProvider;

  public SecondPageActivity_MembersInjector(
      Provider<TestInterface> mTestInterfaceProvider,
      Provider<SecondPagePresenter> mSecondPagePresenterImplProvider) {
    assert mTestInterfaceProvider != null;
    this.mTestInterfaceProvider = mTestInterfaceProvider;
    assert mSecondPagePresenterImplProvider != null;
    this.mSecondPagePresenterImplProvider = mSecondPagePresenterImplProvider;
  }

  public static MembersInjector<SecondPageActivity> create(
      Provider<TestInterface> mTestInterfaceProvider,
      Provider<SecondPagePresenter> mSecondPagePresenterImplProvider) {
    return new SecondPageActivity_MembersInjector(
        mTestInterfaceProvider, mSecondPagePresenterImplProvider);
  }

  @Override
  public void injectMembers(SecondPageActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.exam.ph.examination.BaseActivity_MembersInjector.injectMTestInterface(
        instance, mTestInterfaceProvider);
    instance.mSecondPagePresenterImpl = mSecondPagePresenterImplProvider.get();
  }

  public static void injectMSecondPagePresenterImpl(
      SecondPageActivity instance, Provider<SecondPagePresenter> mSecondPagePresenterImplProvider) {
    instance.mSecondPagePresenterImpl = mSecondPagePresenterImplProvider.get();
  }
}
