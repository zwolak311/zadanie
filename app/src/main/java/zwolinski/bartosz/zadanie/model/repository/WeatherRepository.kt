package zwolinski.bartosz.zadanie.model.repository

import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.joda.time.LocalDateTime
import zwolinski.bartosz.zadanie.model.db.models.WeatherModel
import zwolinski.bartosz.zadanie.model.db.models.WeatherModel_
import zwolinski.bartosz.zadanie.model.network.WeatherEndpoint
import zwolinski.bartosz.zadanie.model.network.networkModel.toWeatherModel
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherEndpoint: WeatherEndpoint,
    private val weatherBox: Box<WeatherModel>
) : WeatherRepository {

    override fun fetchTemperature(location: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                weatherBox.put(
                    weatherEndpoint
                        .getTemperatureForLocation(location)
                        .toWeatherModel(LocalDateTime())
                )
            } catch (ex: Exception) {}
        }
    }

    override fun getLiveTemperatures(location: String): ObjectBoxLiveData<WeatherModel> {
        return ObjectBoxLiveData(
            weatherBox
                .query()
                .equal(WeatherModel_.locationName, location)
                .orderDesc(WeatherModel_.date)
                .build()
        )
    }
}

interface WeatherRepository {

    fun fetchTemperature(location: String)

    fun getLiveTemperatures(location: String): ObjectBoxLiveData<WeatherModel>

}