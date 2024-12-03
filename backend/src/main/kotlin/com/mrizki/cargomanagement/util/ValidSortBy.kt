package com.mrizki.cargomanagement.util

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [SortByValidator::class])
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidSortBy(
    val message: String = "Invalid sortBy parameter",
    val target: KClass<*> = Any::class, // Specify the target class
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)