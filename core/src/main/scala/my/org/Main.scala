package my.org

import Utils.add

object Main {

  def main(args: Array[String]): Unit = {

    println(s"Hello, world with ${args.mkString("[", ", ", "]")}")

    val Int1 = 1
    val Int2 = 2
    val sum = add(Int1, Int2)

    println(s"add($Int1, $Int2) = $sum")

  }

}
