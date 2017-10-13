package com.exam.ph.examination.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideInterceptotFactory
    implements Factory<HttpLoggingInterceptor> {
  private final NetworkModule module;

  public NetworkModule_ProvideInterceptotFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return Preconditions.checkNotNull(
        module.provideInterceptot(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HttpLoggingInterceptor> create(NetworkModule module) {
    return new NetworkModule_ProvideInterceptotFactory(module);
  }
}
