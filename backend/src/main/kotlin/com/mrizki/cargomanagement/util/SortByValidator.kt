package com.mrizki.cargomanagement.util

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure


class SortByValidator : ConstraintValidator<ValidSortBy, String?> {
    private lateinit var targetClass: KClass<*>

    override fun initialize(annotation: ValidSortBy) {
        targetClass = annotation.target
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true // Null is valid

        val properties = value.split(".")
        var currentClass: KClass<*> = targetClass

        for (property in properties) {
            val member = currentClass.memberProperties.find { it.name == property } ?: return false

            // Handle nullable properties safely
            val memberType = member.returnType.classifier as? KClass<*> ?: return false
            if (member.returnType.isMarkedNullable) {
                // If the property is nullable, continue checking but assume it can be null
                return true
            }

            // Handle collections (e.g., List<NodeDTO>)
            if (member.returnType.jvmErasure == Collection::class) {
                val elementType = member.returnType.arguments.firstOrNull()?.type?.classifier as? KClass<*>
                if (elementType != null) {
                    currentClass = elementType
                    continue
                }
                return false
            }

            currentClass = memberType
        }
        return true
    }
}