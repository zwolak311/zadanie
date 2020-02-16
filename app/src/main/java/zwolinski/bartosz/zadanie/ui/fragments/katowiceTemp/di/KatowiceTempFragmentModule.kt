package zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.di

import dagger.Module
import dagger.Provides
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.adapter.HomeTemperatureDataAdapter

@Module
class KatowiceTempFragmentModule {

    @Provides
    fun provideHomeTemperatureDataAdapter() : HomeTemperatureDataAdapter {
        return HomeTemperatureDataAdapter()
    }

}