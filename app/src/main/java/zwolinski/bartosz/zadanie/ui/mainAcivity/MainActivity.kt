package zwolinski.bartosz.zadanie.ui.mainAcivity

import android.os.Bundle
import zwolinski.bartosz.zadanie.R
import zwolinski.bartosz.zadanie.ui.base.BaseViewModelActivity

class MainActivity : BaseViewModelActivity<MainViewModel>() {

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
