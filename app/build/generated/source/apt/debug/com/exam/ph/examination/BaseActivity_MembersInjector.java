package com.exam.ph.examination;

import com.exam.ph.examination.restclient.restinterface.TestInterface;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final Provider<TestInterface> mTestInterfaceProvider;

  public BaseActivity_MembersInjector(Provider<TestInterface> mTestInterfaceProvider) {
    assert mTestInterfaceProvider != null;
    this.mTestInterfaceProvider = mTestInterfaceProvider;
  }

  public static MembersInjector<BaseActivity> create(
      Provider<TestInterface> mTestInterfaceProvider) {
    return new BaseActivity_MembersInjector(mTestInterfaceProvider);
  }

  @Override
  public void injectMembers(BaseActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mTestInterface = mTestInterfaceProvider.get();
  }

  public static void injectMTestInterface(
      BaseActivity instance, Provider<TestInterface> mTestInterfaceProvider) {
    instance.mTestInterface = mTestInterfaceProvider.get();
  }
}
