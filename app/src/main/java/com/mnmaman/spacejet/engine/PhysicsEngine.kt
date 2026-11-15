package com.mnmaman.spacejet.engine

object PhysicsEngine {
    init {
        System.loadLibrary("spacejet")
    }

    external fun nativeValidateDesign(
        totalMass: Float,
        fuelAmount: Float,
        availablePower: Float,
        budget: Float
    ): Boolean

    external fun nativeCalculateTelemetry(
        totalMass: Float,
        fuelAmount: Float,
        availablePower: Float,
        budget: Float
    ): String
}