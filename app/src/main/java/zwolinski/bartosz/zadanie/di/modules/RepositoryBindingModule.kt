package zwolinski.bartosz.zadanie.di.modules

import dagger.Binds
import dagger.Module
import zwolinski.bartosz.zadanie.model.repository.WeatherRepository
import zwolinski.bartosz.zadanie.model.repository.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
abstract class RepositoryBindingModule {

    @Binds
    @Singleton
    abstract fun weatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

}