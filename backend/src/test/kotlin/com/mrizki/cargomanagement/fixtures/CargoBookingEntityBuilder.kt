package com.mrizki.cargomanagement.fixtures

import com.mrizki.cargomanagement.booking.model.CargoBookingEntity
import com.mrizki.cargomanagement.booking.model.CargoType
import java.time.OffsetDateTime
import java.util.*

class CargoBookingEntityBuilder {
    var id: UUID = UUID.randomUUID()
    var name: String = "Test Booking"
    var cargoTypes: Set<CargoType> = setOf(CargoType.FRAGILE, CargoType.PERISHABLE)
    var cargoWeight: Double = 500.0
    var destination: String = "Jakarta"
    var bookingTime: OffsetDateTime = OffsetDateTime.now()

    fun build(): CargoBookingEntity {
        return CargoBookingEntity(
            id = id,
            name = name,
            cargoTypes = cargoTypes,
            cargoWeight = cargoWeight,
            destination = destination,
            bookingTime = bookingTime
        )
    }
}
