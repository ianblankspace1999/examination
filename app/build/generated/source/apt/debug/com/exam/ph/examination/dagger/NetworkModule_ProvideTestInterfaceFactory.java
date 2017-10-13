package com.exam.ph.examination.dagger;

import com.exam.ph.examination.restclient.restinterface.TestInterface;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideTestInterfaceFactory implements Factory<TestInterface> {
  private final NetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideTestInterfaceFactory(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TestInterface get() {
    return Preconditions.checkNotNull(
        module.provideTestInterface(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TestInterface> create(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideTestInterfaceFactory(module, retrofitProvider);
  }
}
