package zwolinski.bartosz.zadanie.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zwolinski.bartosz.zadanie.ui.mainAcivity.MainActivity
import zwolinski.bartosz.zadanie.ui.mainAcivity.di.MainActivityModule

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

}