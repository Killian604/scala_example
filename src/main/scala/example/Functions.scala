package example

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

}