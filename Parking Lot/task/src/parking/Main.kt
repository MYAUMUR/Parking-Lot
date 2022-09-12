package parking

fun main() {
    val parking = Parking()
    while(true) parking.readInput()
}

/*
package parking

import parking.Command.*
import kotlin.system.exitProcess

enum class Command(val type: String) {
    Create("create"),
    Park("park"),
    Leave("leave"),
    Status("status"),
    Exit("exit")
}

fun main() {
    val parking = Parking()
    while (true) {
        parking.readCommand()
    }
}

class Parking {
    private var input = mutableListOf<String>()
    private var parkingLot = MutableList(0) { "Empty" }

    fun readCommand() {
        input = readln().split(" ").toMutableList()
        when (input.first()) {
            Create.type -> createParkingLot()
            Park.type -> parkCar()
            Leave.type -> leaveTheSpot()
            Status.type -> printStatus()
            Exit.type -> exitProcess(0)
        }
    }

    private fun createParkingLot() {
        val spots = input[1].toInt()
        parkingLot = MutableList(spots) { "Empty" }
        println("Created a parking lot with $spots spots.")
    }

    private fun parkCar() {
        val carColor = input[2]
        if (!isCreated()) return
        if (isFull()) {
            println("Sorry, the parking lot is full.")
            return
        } else for (i in parkingLot.indices) {
            if (parkingLot[i] == "Empty") {
                parkingLot[i] = "${input[1]}&${input[2]}"
                println("$carColor car parked in spot ${i + 1}.")
                return
            }
        }
    }

    private fun leaveTheSpot() {
        if (!isCreated()) return
        val spot = input[1].toInt()
        val spotIndex = spot - 1
        if (parkingLot[spotIndex] == "Empty") {
            println("There is no car in spot $spot.")
        } else {
            parkingLot[spotIndex] = "Empty"
            println("Spot $spot is free.")
        }
    }

    private fun printStatus() {
        if (!isCreated()) return
        if (isEmpty()) {
            println("Parking lot is empty.")
            return
        }
        for (i in parkingLot.indices) if (parkingLot[i] != "Empty") {
            println("""${i + 1} ${parkingLot[i].split("&").joinToString(" ")}""")
        }
    }

    private fun isCreated(): Boolean {
        if (parkingLot.size == 0) {
            println("Sorry, a parking lot has not been created.")
            return false
        }
        return true
    }

    private fun isFull(): Boolean {
        for (i in parkingLot) {
            if (i == "Empty") return false
        }
        return true
    }

    private fun isEmpty(): Boolean {
        for (i in parkingLot) {
            if (i != "Empty") return false
        }
        return true
    }
}
 */