package com.rain.sdk.di.module;

import com.google.gson.Gson;
import com.rain.api.UrlCollection;
import com.rain.sdk.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: HttpClientModule
 * @CreateDate: 2020/7/4 15:04
 * @Describe:
 */
@InstallIn(ApplicationComponent.class)
@Module
public abstract class HttpClientModule {

    public static final Long DEFAULT_TIME = 10L;


    @Singleton
    @Provides
    static Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client,Gson gson) {
        return builder
                .baseUrl(UrlCollection.UNSPLASH_NAPI_BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(BuildConfig.LOG_DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.BODY);
        return builder
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .removeHeader("User-Agent")
                                .addHeader("User-Agent",
                                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.7 Safari/537.36")

//                                .addHeader("Authorization","Client-ID " + UrlCollection.UNSPLASH_ACCESS_KEY)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    static OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }


}
