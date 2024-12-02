package com.mrizki.cargomanagement.fixtures

import com.mrizki.cargomanagement.booking.model.CargoBookingDTO
import java.time.OffsetDateTime
import java.util.*

class CargoBookingDTOBuilder {
    var id: String = UUID.randomUUID().toString()
    var name: String = "Default Booking"
    var cargoTypes: Set<String> = setOf("FRAGILE", "PERISHABLE")
    var cargoWeight: Double = 500.0
    var destination: String = "Jakarta"
    var bookingTime: OffsetDateTime = OffsetDateTime.now()

    fun build(): CargoBookingDTO {
        return CargoBookingDTO(
            id = id,
            name = name,
            cargoTypes = cargoTypes,
            cargoWeight = cargoWeight,
            destination = destination,
            bookingTime = bookingTime
        )
    }
}
