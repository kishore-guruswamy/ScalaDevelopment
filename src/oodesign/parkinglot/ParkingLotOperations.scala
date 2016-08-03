package oodesign.parkinglot

/**
  * Created by z001p0v on 7/28/16.
  */
object ParkingLotOperations {

  def main(args:Array[String]): Unit = {
    println("hello parking lot")
    testPark()
  }

  //test method to park a vehicle in a parking lot
  def testPark(): Unit = {
    val parkingLotOperations: ParkingLotOperations = new ParkingLotOperations
    parkingLotOperations.parkingLotMap.put(1, new ParkingLot(1, "SMALL", "A"))
    parkingLotOperations.parkingLotMap.put(2, new ParkingLot(2, "LARGE", "P"))
    parkingLotOperations.park(1, new Vehicle("SMALL"))
    parkingLotOperations.park(2, new Vehicle("lARGE"))
    parkingLotOperations.park(2, new Vehicle("SMALL"))
    parkingLotOperations.park(1, new Vehicle("SMALL"))
  }
}

class ParkingLotOperations {
  private var parkingLotMap = scala.collection.mutable.Map[Int, ParkingLot]()

  def park(parkingLotId:Int, vehicle:Vehicle):Unit = {
    var parkingLotOption = parkingLotMap.get(parkingLotId)
    if (parkingLotOption.isEmpty) {
      println("parking lot id not valid")
    } else if (!parkingLotOption.get.size.equalsIgnoreCase(vehicle.size)) {
      println("vehicle cannot be parked")
    } else if (!parkingLotOption.get.state.equalsIgnoreCase("A")) {
      println("parking lot not available")
    } else {
      println(s"parking vehicle in parking lot number:$parkingLotId")
      parkingLotOption.get.state = "P"
    }
  }

  def release():Unit = {

  }
}
