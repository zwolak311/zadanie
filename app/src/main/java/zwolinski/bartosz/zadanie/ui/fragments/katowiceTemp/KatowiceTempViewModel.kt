package zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp

import androidx.lifecycle.ViewModel
import io.objectbox.android.ObjectBoxLiveData
import zwolinski.bartosz.zadanie.model.db.models.WeatherModel
import zwolinski.bartosz.zadanie.model.network.WeatherApiLocations.KATOWICE
import zwolinski.bartosz.zadanie.model.repository.WeatherRepository
import java.util.*
import javax.inject.Inject

class KatowiceTempViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    fun fetchKatowiceWeatherData() {
        weatherRepository.fetchTemperature(KATOWICE)
    }

    fun observeLastKatowiceTemperatures() : ObjectBoxLiveData<WeatherModel> {
        return weatherRepository.getLiveTemperatures(KATOWICE)
    }

    fun mapWeatherModelToString(weatherModelList: MutableList<WeatherModel>): List<String> {
        return weatherModelList.map {
            TEMP_PREFIX.plus(it.temperature)
                .plus(NEW_LINE_SEPARATOR)
                .plus(DATE_PREFIX).plus(it.date.toString(null, Locale.getDefault()))
        }
    }


    companion object {

        private const val TEMP_PREFIX = "TEMP: "
        private const val DATE_PREFIX = "DATE: "
        private const val NEW_LINE_SEPARATOR = "\n"

    }

}