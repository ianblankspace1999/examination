package com.exam.ph.examination.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<Converter.Factory> converterProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<String> baseUrlProvider;

  public NetworkModule_ProvideRetrofitFactory(
      NetworkModule module,
      Provider<Converter.Factory> converterProvider,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<String> baseUrlProvider) {
    assert module != null;
    this.module = module;
    assert converterProvider != null;
    this.converterProvider = converterProvider;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
    assert baseUrlProvider != null;
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(
            converterProvider.get(), okHttpClientProvider.get(), baseUrlProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      NetworkModule module,
      Provider<Converter.Factory> converterProvider,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<String> baseUrlProvider) {
    return new NetworkModule_ProvideRetrofitFactory(
        module, converterProvider, okHttpClientProvider, baseUrlProvider);
  }
}
