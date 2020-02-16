package zwolinski.bartosz.zadanie.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseViewModelActivity<T : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModelClass(): Class<T>

    val viewModel: T by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }

}