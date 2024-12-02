package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CargoBookingRepositoryMongoDB: MongoRepository<CargoBookingEntity, UUID> {
}