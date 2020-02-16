package zwolinski.bartosz.zadanie.model

import android.content.Context
import io.objectbox.BoxStore
import zwolinski.bartosz.zadanie.model.db.models.MyObjectBox

object ObjectBox {

    private lateinit var boxStore: BoxStore

    fun init(context: Context): BoxStore {
        if (::boxStore.isInitialized && !boxStore.isClosed) {
            return boxStore
        }

        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
        return boxStore
    }
}