package zwolinski.bartosz.zadanie.model.db.converters

import io.objectbox.converter.PropertyConverter
import org.joda.time.LocalDateTime

class DateConverter : PropertyConverter<LocalDateTime, Long> {

    override fun convertToDatabaseValue(entityProperty: LocalDateTime?): Long {
        return entityProperty?.toDate()?.time ?: 0L
    }

    override fun convertToEntityProperty(databaseValue: Long?): LocalDateTime {
        return LocalDateTime(databaseValue ?: 0L)
    }

}