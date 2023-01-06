package parking


fun main() {
    data class Car(val regPlate: String, val color: String, val spotNum: Int)

    val parking = mutableListOf<Car?>()

    fun create(spotNum: Int): String {
        parking.clear()
        repeat(spotNum) { parking.add(null) }
        return "Created a parking lot with $spotNum spots."
    }

    fun printParkingStatus() {
        if (parking.isNotEmpty()) {
            val parkingNotNull = parking.filterNotNull()
            if (parkingNotNull.isEmpty()) println("Parking lot is empty.")
            else parkingNotNull.forEach { println("${it.spotNum} ${it.regPlate} ${it.color}") }
        } else println("Sorry, a parking lot has not been created.")
    }

    fun park(regPlate: String, color: String): String {
        val nullSpot = parking.indexOf(null)
        return when {
            parking.isNotEmpty() && nullSpot == -1 -> "Sorry, the parking lot is full."
            parking.isEmpty() && nullSpot == -1 -> "Sorry, a parking lot has not been created."
            else -> {
                parking[nullSpot] = Car(regPlate, color, nullSpot + 1)
                "$color car parked in spot ${nullSpot + 1}."
            }
        }
    }

    fun leave(spot: Int): String = when {
        spot <= parking.size && parking[spot - 1] != null -> {
            parking[spot - 1] = null
            "Spot $spot is free."
        }

        parking.isEmpty() -> "Sorry, a parking lot has not been created."
        else -> "There is no car in spot ${spot}."
    }

    fun regByColor(color: String): String {
        val matchingCars = parking.filterNotNull().filter { it.color.equals(color, ignoreCase = true) }
        return if (parking.isEmpty()) "Sorry, a parking lot has not been created."
        else if (matchingCars.isEmpty()) "No cars with color $color were found."
        else matchingCars.joinToString { it.regPlate }
    }

    fun spotByColor(color: String): String {
        val matchingCars = parking.filterNotNull().filter { it.color.equals(color, ignoreCase = true) }
        return if (parking.isEmpty()) "Sorry, a parking lot has not been created."
        else if (matchingCars.isEmpty()) "No cars with color $color were found."
        else matchingCars.joinToString { (it.spotNum).toString() }
    }

    fun spotByReg(regPlate: String): String {
        val matchingCar = parking.filterNotNull().firstOrNull { it.regPlate == regPlate }
        return if (parking.isEmpty()) "Sorry, a parking lot has not been created."
        else if (matchingCar == null) "No cars with registration number $regPlate were found."
        else (matchingCar.spotNum).toString()
    }

    while (true) {
        val input = readLine()!!.split(' ')
        when (input[0]) {
            "create" -> println(create(input[1].toInt()))
            "status" -> printParkingStatus()
            "park" -> println(park(input[1], input[2]))
            "leave" -> println(leave(input[1].toInt()))
            "reg_by_color" -> println(regByColor(input[1]))
            "spot_by_color" -> println(spotByColor(input[1]))
            "spot_by_reg" -> println(spotByReg(input[1]))
            "exit" -> return
        }
    }
}