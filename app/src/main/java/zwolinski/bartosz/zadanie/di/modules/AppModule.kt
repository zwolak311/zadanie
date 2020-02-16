package zwolinski.bartosz.zadanie.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    private val application: Application? = null

    @Provides
    @Singleton
    fun provideContext(): Context? {
        return application
    }

}