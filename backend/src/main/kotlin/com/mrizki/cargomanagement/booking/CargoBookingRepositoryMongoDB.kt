package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CargoBookingRepositoryMongoDB: MongoRepository<CargoBookingEntity, UUID> {
    fun findAllByNameIsContainingIgnoreCaseAndDestinationContainingIgnoreCase(
        name: String,
        destination: String,
        pageable: Pageable
    ): Page<CargoBookingEntity>

    fun findAllByNameContainingIgnoreCase(
        name: String,
        pageable: Pageable
    ): Page<CargoBookingEntity>

    fun findAllByDestinationContainingIgnoreCase(
        destination: String,
        pageable: Pageable
    ): Page<CargoBookingEntity>
}
