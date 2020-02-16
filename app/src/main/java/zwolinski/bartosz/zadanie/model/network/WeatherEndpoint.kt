package zwolinski.bartosz.zadanie.model.network

import retrofit2.http.GET
import retrofit2.http.Query
import zwolinski.bartosz.zadanie.di.modules.RetrofitModule.Companion.UNIT_METRIC
import zwolinski.bartosz.zadanie.di.modules.RetrofitModule.Companion.WEATHER_KEY
import zwolinski.bartosz.zadanie.model.network.networkModel.WeatherNetworkModel

interface WeatherEndpoint {

    @GET("weather?")
    suspend fun getTemperatureForLocation(
        @Query("q")  cityName: String,
        @Query("units")  units: String = UNIT_METRIC
        ,
        @Query("APPID")  key: String = WEATHER_KEY
    ): WeatherNetworkModel

}