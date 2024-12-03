package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingDTO
import com.mrizki.cargomanagement.booking.model.CargoBookingInput
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CargoBookingService {
    fun createBooking(cargoBookingInput: CargoBookingInput): CargoBookingDTO
    fun getAllBookings(pageable: Pageable, name: String?, destination: String?): Page<CargoBookingDTO>
}
