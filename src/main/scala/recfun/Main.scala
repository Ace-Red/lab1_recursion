package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      val cOpt = if (c > r/2) r - c else c
      def loop(col: Int, row: Int, previous: Array[Int], current: Array[Int]): Int = {
        current(col) = (if (col > 0) previous(col - 1) else 0) + (if (col < row) previous(col) else 0)

        if ((col == cOpt) && (row == r)) current(col)
        else if (col < row) loop(col + 1, row, previous, current)
        else loop(0, row + 1, current, new Array(_length = row + 2))
      }

      if (c == 0 || c == r) 1
      else loop(0, 1, Array(1), new Array(_length = 2))
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balrec(chars: List[Char], accr: Int, accl: Int): Boolean = {
        chars match {
          case head :: tail =>
            if (head.equals('(')) balrec(tail, accr + 1, accl)
            else if (head.equals(')') && (accr > accl || accr == 0)) balrec(tail, accr, accl + 1)
            else balrec(tail, accr, accl)
          case Nil => if (accr == accl) true else false
        }
      }

      balrec(chars, 0, 0)
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
}
