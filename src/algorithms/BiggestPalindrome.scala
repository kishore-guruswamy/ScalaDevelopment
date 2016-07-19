package algorithms

/**
  * Created by Kishore on 7/14/16.
  * Given a string, find the biggest palindrome substring
  */

object BiggestPalindrome {

  def main(args:Array[String]):Unit = {
    val inputString: String = "AABCDCBA"
    val palindromeInstance: BiggestPalindrome = new BiggestPalindrome
    val output: Option[String]= palindromeInstance.findBiggestPalindrome(inputString)
    if (output.isEmpty) {
      println(s"no palindrome found for $inputString")
    } else {
      println(s"for input $inputString biggest palindrome is ${output.get}")
    }
  }
}

class BiggestPalindrome {

  //lets take a iterative approach first
  def findBiggestPalindrome(inputString: String): Option[String] = {
    var outputString: Option[String] = Option.empty
    if (inputString != null) {
      var outputValue:String = ""
      val formattedInput = inputString.trim()
      for (i <- 0 to formattedInput.length - 1) {
        for (j <- i+1 to formattedInput.length) {
          val str = formattedInput.substring(i,j)
          val strReverse = str.reverse
          if (str.equals(strReverse)) {
            //current string is a palindrome
            if (str.length > outputValue.length) {
              outputValue = str
            }
          }
        }
      }
      if (outputValue.length > 0) {
        outputString = Option.apply(outputValue)
      }
    }
    return outputString;
  }


}


