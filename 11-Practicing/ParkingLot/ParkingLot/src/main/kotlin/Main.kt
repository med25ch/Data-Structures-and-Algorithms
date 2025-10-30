package org.example

fun main() {
    println("Hello World!")
}

enum class SpotType { SMALL, MEDIUM, LARGE }

data class Spot(val type: SpotType, var isTaken: Boolean = false)

sealed class Vehicle
object Motorcycle : Vehicle()
object Car : Vehicle()
object Van : Vehicle()

class ParkingLot(private val spots: MutableList<Spot>) {

    fun remainingSpots() = spots.count { !it.isTaken }
    fun totalSpots() = spots.size
    fun isFull() = spots.none { !it.isTaken }
    fun isEmpty() = spots.all { !it.isTaken }
    fun isSpotTypeFull(type: SpotType) = spots.none { it.type == type && !it.isTaken }

    fun park(vehicle: Vehicle): Boolean {
        return when (vehicle) {
            is Motorcycle -> parkInAnySpot()
            is Car -> parkInFirstAvailable(SpotType.MEDIUM, SpotType.LARGE)
            is Van -> parkVan()
        }
    }

    private fun parkInAnySpot(): Boolean {
        val spot = spots.find { !it.isTaken } ?: return false
        spot.isTaken = true
        return true
    }

    private fun parkInFirstAvailable(vararg types: SpotType): Boolean {
        val spot = spots.find { it.type in types && !it.isTaken } ?: return false
        spot.isTaken = true
        return true
    }

    private fun parkVan(): Boolean {
        val large = spots.find { it.type == SpotType.LARGE && !it.isTaken }
        if (large != null) {
            large.isTaken = true
            return true
        }
        val regulars = spots.withIndex()
            .filter { it.value.type == SpotType.MEDIUM && !it.value.isTaken }
            .take(3)
        if (regulars.size == 3) {
            regulars.forEach { it.value.isTaken = true }
            return true
        }
        return false
    }
}