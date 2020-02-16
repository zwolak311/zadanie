package zwolinski.bartosz.zadanie.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import zwolinski.bartosz.zadanie.TaskApplication
import zwolinski.bartosz.zadanie.di.modules.*
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        DatabaseModule::class,
        RetrofitModule::class,
        FlavorModule::class,
        RepositoryBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<TaskApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}