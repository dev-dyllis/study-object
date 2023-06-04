package chapter1
data class TicketOffice(
    var amount: Long,
    val tickets: MutableList<Ticket> = mutableListOf()
) {

    constructor(
        amount: Long,
        vararg tickets: Ticket
    ): this(amount, tickets.toMutableList())

    private fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

}