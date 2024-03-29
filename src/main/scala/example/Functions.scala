package example

import java.util.NoSuchElementException

import annotation.tailrec

object Functions {

  def last[A<: List[AnyVal]](x: A): AnyVal = x.last

  @tailrec
  def lastRecursive[A](ls: Seq[A]): A = {
    ls match {
      case elem :: Nil => elem
      case elem :: tail => lastRecursive(tail)
      case _ => throw new NoSuchElementException
    }
  }
  def flatten2[C <: List[Any]](list: C): List[Any] =
    list flatMap {
      case ms: List[_] => flatten2(ms)
      case e => List(e)
    }
  def penultimate[A](ls: List[A]): A = {
    if (ls.length < 2) throw new NoSuchElementException
    else ls.apply(ls.length-2)
  }
  def nth[A](n: Int, ls: Seq[A]):A  = ls.apply(n)
  // add an nthRecursive option
  @tailrec
  def nthRec[A](n: Int, ls: Seq[A]): A ={
    if (n == 0) ls.head
    else nthRec(n-1, ls.slice(1, ls.length))
  }

  def compress[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case e :: tail => e :: compress(tail.dropWhile(_ == e))
  }

  def reverse[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case head :: tail => reverse(tail) :+ head
  }
  def reverseBI[A](ls: List[A]): List[A] = ls.reverse

  def revTailRecursive[A](ls: List[A]): List[A] = {
    @scala.annotation.tailrec
    def revRec(input:List[A], res:List[A]=List()): List[A] = input match {
      case Nil => res
      case head::tail => revRec(tail, head +: res)
    }
    revRec(ls)
  }

  def reverse_Functional[A](ls: List[A]): List[A] = ls.foldLeft(List[A]())((a, b) => b :: a)

  @scala.annotation.tailrec
  def isPalin[A](ls: List[A]): Boolean = {
    if (ls.length < 2)  true
    else if (ls.head != ls.last) false
    else isPalin(ls.slice(1, ls.length-1))
  }

  def pack_elements[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span {_ == ls.head}
      if (next == Nil) List(packed)
      else packed :: pack_elements(next)
    }
  }
  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack_elements(ls) map {e => (e.length, e.head)}
  }

  def encodeModified[A](ls: List[A]): List[Any] =
    pack_elements(ls) map {e => {if (e.length == 1) e.head else (e.length, e.head)}}

  /*Why does the below Right and Left not work?*/
//  def encodeModifiedSolution[A](ls: List[A]): List[Either[A, (Int, A)]] =
//    encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }

  def encodeModifiedSolution[A](ls: List[A]): List[Any] =
    encode(ls) map { t => if (t._1 == 1) t._2 else t }

  def decode[B](ls: List[(Int, B)]): List[B] =
    ls flatMap { e => List.fill(e._1)(e._2) }

  @tailrec
  def encodeDirect[A](ls: List[A], enc: List[(Int, A)] = List()): List[(Int, A)] =
    ls match {
      case Nil => enc
      case _ =>
        val (left, right) = ls span (_ == ls.head)
        encodeDirect(right, enc :+ (left.length, left.head))
    }

  def encodeDirectSolution[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { _ == ls.head }
      (packed.length, packed.head) :: encodeDirectSolution(next)
    }

  def duplicateN[A](n: Int, ls: List[A]): List[A] =
    ls flatMap { e => List.fill(n)(e) }

  def slice[A](start: Int, end: Int, ls: List[A]): List[A] =
    ls slice (start, end)

  def rotate[A](n: Int, ls: List[A]): List[A] = {
    var n1 = n
    while (n1 < 0)
      n1 = n + ls.length
    val (left,right) = ls splitAt (n1 % ls.length)
    right ++ left
  }

  def range(start: Int, end: Int):List[Int] = List.range[Int](start,end+1)

  @tailrec
  def dropNth[A](n: Int, ls: List[A], dropped: List[A]=List()): List[A] = {
    if (n > ls.length) dropped
    else {
      val (left, right) = ls.splitAt(n-1)
      dropNth(n, right.tail, dropped ++ left)
    }
  }

  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = ls splitAt n

  def slice[A](start: Int, end: Int, ls: List[A]): List[A] = {List()}

  def rotate[A](n: Int, ls: List[A]): List[A] = {List()}

  def removeAt[A](n: Int, ls: List[A]): (List[A], A) =
    ls splitAt n match {
      case (Nil, _) if n < 0 => throw new NoSuchElementException
      case (pre, e::post) => (pre ++ post, e)
  }

  def insertAt[A](x: A, idx: Int, ls: List[A]): List[A] = {
    val (left, right) = ls splitAt idx
    left ++ List(x) ++ right
  }
  def insertAtSolution[A](e: A, idx: Int, ls:List[A]): List[A] =
    ls splitAt idx match {
      case (pre, post) => pre ::: e :: post
  }
//  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
//
//  }

}
package arithmetic {
  class S99Int(val start: Int) {
    import S99Int._
    def isPrime: Boolean =
      (start > 1) && (primes takeWhile { _ <= Math.sqrt(start) } forall { start % _ != 0 })
  }
  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
    val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
  }

}