package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingDTO
import com.mrizki.cargomanagement.booking.model.CargoBookingInput

interface CargoBookingService {
    fun createBooking(cargoBookingInput: CargoBookingInput): CargoBookingDTO
}
