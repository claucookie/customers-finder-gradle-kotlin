package domain

import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

object DistanceCalculator {

    fun distanceBetweenCoordinates(
        lat1: Double,
        lon1: Double,
        lat2: Double,
        lon2: Double,
        unit: String = "" // Empty for miles
    ): Double {
        if (lat1 == lat2 && lon1 == lon2) return 0.0

        val theta = lon1 - lon2
        var dist =
            sin(Math.toRadians(lat1)) * sin(Math.toRadians(lat2)) + cos(
                Math.toRadians(lat1)
            ) * cos(Math.toRadians(lat2)) * cos(
                Math.toRadians(theta)
            )
        dist = acos(dist)
        dist = Math.toDegrees(dist)
        dist *= 60 * 1.1515 // Miles
        if (unit == "K") { // Kms
            dist *= 1.609344
        } else if (unit == "N") { // Nautical Miles
            dist *= 0.8684
        }
        return dist
    }
}