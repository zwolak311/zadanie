package zwolinski.bartosz.zadanie.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import zwolinski.bartosz.zadanie.di.modules.RetrofitModule.Companion.BASE_URL
import javax.inject.Named
import javax.inject.Singleton

@Module
class FlavorModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun provideBaseUrl(): String = "https://api.openweathermap.org/data/2.5/"

    @Provides
    @Singleton
    fun provideOkHttp(okHttpBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

}