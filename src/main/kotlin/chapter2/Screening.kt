package chapter2

import java.time.LocalDateTime

data class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    val startTime: LocalDateTime = whenScreened
    val movieFee: Money = movie.fee

    fun isSequence(
        sequence: Int
    ): Boolean {
        return this.sequence == sequence
    }

    fun reserve(
        customer: Customer,
        audienceCount: Int
    ): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(
        audienceCount: Int
    ): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }

}
