package chapter1

data class TicketSeller(
    private val ticketOffice: TicketOffice
) {

    fun sellTo(audience: Audience) {
        ticketOffice.sellTicketTo(audience)
    }

}
