package com.brownx.a2d0.util
import java.util.UUID

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
class GenerateUuid {
    operator fun invoke(): String {
        return UUID.randomUUID().toString()
    }
}