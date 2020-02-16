package zwolinski.bartosz.zadanie

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.danlew.android.joda.JodaTimeAndroid
import zwolinski.bartosz.zadanie.di.AppComponent
import zwolinski.bartosz.zadanie.di.DaggerAppComponent

class TaskApplication : DaggerApplication() {

    private lateinit var mainAppComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if (!::mainAppComponent.isInitialized) {
            mainAppComponent = DaggerAppComponent.builder().application(this).build()
        }
        return mainAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
    }

}