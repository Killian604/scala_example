package example
import java.util

import scala.concurrent._
import duration._
import scala.collection.TraversableOnce
import core.Weather

object Hello extends App {
  def getWeather() = {
    val w = Await.result(Weather.weather, 10.seconds)
    println(s"Hello! The weather in New York is $w.")
    Weather.http.close()
  }

  def functional_foreach[A <: Seq[AnyVal], B](sequence: A, f: AnyVal=>Unit): Unit = sequence.foreach(f)

  override def main(args: Array[String]): Unit = {
    println("You've reached main()")
    println("args length:", args.length)
    for (arg <- args) {
      println(arg)

    }
  }
}