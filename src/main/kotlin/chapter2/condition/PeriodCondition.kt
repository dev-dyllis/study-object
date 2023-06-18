package chapter2.condition

import chapter2.Screening
import java.time.DayOfWeek
import java.time.LocalTime

data class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.startTime.dayOfWeek.equals(dayOfWeek)
                && startTime <= screening.startTime.toLocalTime()
                && endTime >= screening.startTime.toLocalTime()
    }

}
