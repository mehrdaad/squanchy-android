package net.squanchy.venue.domain.view

import org.threeten.bp.ZoneId

@Suppress("LongParameterList") // This is just a big model - TODO refactor this to split it up
data class Venue(
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val mapUrl: String,
    val timeZone: ZoneId
)
