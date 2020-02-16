package zwolinski.bartosz.zadanie.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import zwolinski.bartosz.zadanie.model.ObjectBox
import zwolinski.bartosz.zadanie.model.db.models.WeatherModel
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun cashFlowObjectBox(application: Application) : BoxStore {
        return ObjectBox.init(application)
    }

    @Provides
    fun weatherModelBox(boxStore: BoxStore) : Box<WeatherModel> {
        return boxStore.boxFor(WeatherModel::class)
    }

}