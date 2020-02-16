package zwolinski.bartosz.zadanie.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import zwolinski.bartosz.zadanie.di.daggerSupport.DaggerViewModelFactory
import zwolinski.bartosz.zadanie.di.daggerSupport.ViewModelKey
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.KatowiceTempViewModel
import zwolinski.bartosz.zadanie.ui.mainAcivity.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainActivityViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(KatowiceTempViewModel::class)
    abstract fun homeViewModel(viewModel: KatowiceTempViewModel): ViewModel

}