package zwolinski.bartosz.zadanie.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseViewModelFragment<T : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModelClass(): Class<T>

    val viewModel: T by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }


    fun <X : ViewModel> getActivityViewModel(clazz: Class<X>): X {
        return ViewModelProviders.of(activity!!, viewModelFactory).get(clazz)
    }

}