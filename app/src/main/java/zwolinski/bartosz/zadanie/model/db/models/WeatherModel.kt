package zwolinski.bartosz.zadanie.model.db.models

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import org.joda.time.LocalDateTime
import zwolinski.bartosz.zadanie.model.db.converters.DateConverter

@Entity
data class WeatherModel(
    @Id var id: Long = 0,
    var temperature: Double,
    var locationName: String,
    @Convert(converter = DateConverter::class, dbType = Long::class) var date: LocalDateTime
)