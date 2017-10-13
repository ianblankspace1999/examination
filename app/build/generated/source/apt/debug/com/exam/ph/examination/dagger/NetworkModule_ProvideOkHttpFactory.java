package com.exam.ph.examination.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;

  public NetworkModule_ProvideOkHttpFactory(
      NetworkModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    assert module != null;
    this.module = module;
    assert httpLoggingInterceptorProvider != null;
    this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttp(httpLoggingInterceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      NetworkModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpFactory(module, httpLoggingInterceptorProvider);
  }
}
