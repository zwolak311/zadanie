package zwolinski.bartosz.zadanie.model.network.networkModel

import androidx.annotation.Keep
import org.joda.time.LocalDateTime
import zwolinski.bartosz.zadanie.model.db.models.WeatherModel

@Keep
data class WeatherNetworkModel(
    var main: TemperatureNetworkModel,
    var name: String
)

@Keep
data class TemperatureNetworkModel(
    var temp: Double
)

fun WeatherNetworkModel.toWeatherModel(date: LocalDateTime) : WeatherModel {
    return WeatherModel(
        temperature = this.main.temp,
        locationName = this.name,
        date = date
    )
}