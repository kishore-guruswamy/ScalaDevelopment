package datastructures

import scala.util.control.Breaks._
/**
  * Created by Kishore on 7/1/16.
  * hash set implementation
  * uses an array for storage
  */
object HashSetImpl {

  def main(args:Array[String]): Unit = {
    println("Begin HashSet Impl in Scala")
    var hashSetInstance: HashSetImpl = new HashSetImpl
    println("hash set fixed length: "+hashSetInstance.hashSetArray.length)
    var input :List[Int] = List(1,2,3,4,5,6)
    //try to add input into hashset
    for (i <- input) {
      val pos: Int = hashSetInstance.add(int2Integer(i))
      if (pos != -1) {
        println("pos= "+pos+" value= "+hashSetInstance.getHashSet()(pos))
      }
    }

    //retrieve value from hashset
    input = List(1,4,6)
    for (i <- input) {
      val output:Option[Object] = hashSetInstance.get(int2Integer(i))
      if (output.isEmpty) {
        println("value "+i+" does not exist")
      } else {
        println("value "+i+" exists")
      }
    }

  }
}

class HashSetImpl {
  private var hashSetArray: Array[Object] = new Array[Object](5)

  def getHashSet(): Array[Object] = {
    return hashSetArray
  }

  def add(value: Object) :Int = {
    val position:Int = findPosition(value)
    if (position != -1) {
      hashSetArray(position) = value
    } else {
      println(s"unable to add $value in hash set")
    }
    return position
  }

  def get(value: Object) :Option[Object] = {
    val pos :Int = findPosition(value)
    if (pos != -1) {
      return Some.apply(hashSetArray(pos))
    }
    return None;
  }

  private def findPosition(value: Object): Int = {
    val inputHash: Int = value.hashCode() % hashSetArray.length
    var pos:Int = findIndex(inputHash, hashSetArray.length, value)
    if (pos >= hashSetArray.length) {
      //search position from 0 to lowerbound
      pos = findIndex(0, inputHash, value)
      if (pos >= inputHash) {
        pos = -1
      }
    }
    return pos
  }

  private def findIndex(lowerBound: Int, upperBound: Int, value: Object) :Int = {
    var pos: Int = lowerBound
    breakable {
      while (pos < upperBound) {
        if (hashSetArray(pos) != null && !hashSetArray(pos).equals(value)) {
          pos += 1
        } else {
          break
        }
      }
    }
    return pos
  }
}