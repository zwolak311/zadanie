package zwolinski.bartosz.zadanie.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.KatowiceTempFragment
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.di.KatowiceTempFragmentModule

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [KatowiceTempFragmentModule::class])
    abstract fun homeFragment(): KatowiceTempFragment

}