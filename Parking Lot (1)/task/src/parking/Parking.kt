package parking

import Car
import Command.*
import kotlin.system.exitProcess

class Parking {
    private lateinit var input: MutableList<String>
    private lateinit var parking: MutableList<Any>

    fun readInput() {
        input = readln().split(" ").toMutableList()
        when (input[0]) {
            CreateParking.text -> createParking()
            ParkCar.text -> {
                if (!isCreated()) return
                parkCar()
            }

            Leave.text -> {
                if (!isCreated()) return
                leaveParking()
            }

            PrintStatus.text -> {
                if (!isCreated()) return
                printStatus()
            }

            RegByColor.text -> {
                if (!isCreated()) return
                printByColor("number")
            }

            SpotByColor.text -> {
                if (!isCreated()) return
                printByColor("spot")
            }

            SpotByReg.text -> {
                if (!isCreated()) return
                printSpotByReg()
            }

            Exit.text -> exitProcess(0)
        }
    }
    private fun createParking() {
        val size = input[1].toInt()
        parking = MutableList(size) { "Empty" }
        println("Created a parking lot with $size spots.")
    }

    private fun parkCar() {
        for (i in parking.indices) {
            if (parking[i] == "Empty") {
                val number = input[1]
                val color = input[2]
                val spot = i + 1
                parking[i] = Car(number, color, spot)
                println("$color car parked in spot $spot.")
                return
            }
        }
        println("Parking lot is full")
        return
    }

    private fun leaveParking() {
        val spot = input[1].toInt()
        val spotIndex = spot - 1
        if (parking[spotIndex] == "Empty") {
            println("There is no car in spot $spot.")
        } else {
            parking[spotIndex] = "Empty"
            println("Spot $spot is free.")
        }
    }

    private fun isCreated(): Boolean {
        return if (::parking.isInitialized) true else {
            println("Sorry, a parking lot has not been created.")
            false
        }
    }

    private fun printStatus() {
        for (i in parking.indices) if (parking[i] != "Empty") println(parking[i])
    }

    private fun printByColor(argument: String) {
        val inputColor = input[1]
        val carList = mutableListOf<Car>()
        for (i in parking.indices) {
            if (parking[i] != "Empty") {
                val car = parking[i] as Car
                if (car.color.uppercase() == inputColor.uppercase()) carList.add(car)
            }
        }
        when {
            carList.isEmpty() -> {
                println("No cars with color $inputColor were found.")
                return
            }
            argument == "number" -> println(carList.joinToString { it.number })
            argument == "spot" -> println(carList.joinToString { it.spot.toString() })
        }
    }

    private fun printSpotByReg() {
        val inputNumber = input[1]
        for (i in parking.indices) {
            if (parking[i] != "Empty") {
                val car = parking[i] as Car
                if (inputNumber == car.number) {
                    println(car.spot)
                    return
                }
            }
        }
        println("No cars with registration number $inputNumber were found.")
    }
}