package zwolinski.bartosz.zadanie.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zwolinski.bartosz.zadanie.model.network.WeatherEndpoint
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpBuilder(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
    }

    @Provides
    @Singleton
    @Named(API_RETROFIT)
    fun provideApiRetrofit(@Named(BASE_URL) baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherEndpoint(@Named(API_RETROFIT) retrofit: Retrofit): WeatherEndpoint {
        return retrofit.create(WeatherEndpoint::class.java)
    }

    companion object {
        const val BASE_URL = "base_url"
        const val API_RETROFIT = "API_RETROFIT"

        const val WEATHER_KEY = "bb4a23f1c7955a9bcba5d59211c78032"

        const val UNIT_METRIC = "metric"

        const val CONNECT_TIMEOUT = 10000L
        const val READ_TIMEOUT = 10000L
        const val WRITE_TIMEOUT = 10000L
    }

}