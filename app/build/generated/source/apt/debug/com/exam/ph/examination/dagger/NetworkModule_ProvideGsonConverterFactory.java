package com.exam.ph.examination.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Converter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideGsonConverterFactory implements Factory<Converter.Factory> {
  private final NetworkModule module;

  public NetworkModule_ProvideGsonConverterFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Converter.Factory get() {
    return Preconditions.checkNotNull(
        module.provideGsonConverter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Converter.Factory> create(NetworkModule module) {
    return new NetworkModule_ProvideGsonConverterFactory(module);
  }
}
