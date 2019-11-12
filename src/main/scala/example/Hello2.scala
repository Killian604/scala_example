package example

import scala.concurrent._
import duration._

object Hello2 extends App {
  override def main(args: Array[String]) = {
    println("You've reached main()")
    println("args length:", args.length)
    for (arg <- args) {
      println(arg)

    }
  }
}