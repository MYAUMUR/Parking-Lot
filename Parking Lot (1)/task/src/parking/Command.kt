enum class Command(val text: String) {
    CreateParking("create"),
    ParkCar("park"),
    PrintStatus("status"),
    Leave("leave"),
    RegByColor("reg_by_color"),
    SpotByColor("spot_by_color"),
    SpotByReg("spot_by_reg"),
    Exit("exit")
}