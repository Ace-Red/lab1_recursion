package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }


    println(indTask(3, 1.1f))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || (c == r)) 1
    else
      pascal(c-1, r-1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def checkBalance(array: List[Char], count: Int): Int =
      if (array.isEmpty)
        count
      else if (array.head == '(')
        checkBalance(array.tail, count + 1)
      else if (array.head == ')' && count > 0)
        checkBalance(array.tail, count - 1)
      else
        checkBalance(array.tail, count)

    if (chars.count(_.equals('(')) == chars.count(_.equals(')'))) checkBalance(chars, 0) == 0
    else false
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0)
      1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }

  /**
   * Exercise 4
   */
  def indTask(x: Float, a: Float): Float =
    if (x < 2)
      a
    else if (x > 2) {
      if(x % 1 == 0){

      def factorial(n: Int): Int = {
        if (n <= 0) 1
        else n * factorial(n - 1)
      }

      val res = a * factorial(x.toInt)
        (res * 10).toInt / 10F
      }
      else {
        throw new Exception("X не целое число!")
      }
    }
    else {
      throw new Exception("X выходит за границы!")
    }


}
