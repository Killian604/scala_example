import org.scalatest._
import example.Functions

class TestHello extends FunSuite with DiagrammedAssertions {
  val fib = List(1,1,2,3,5,8,13,21)
  val letters = List('a','b','b','c','c','d','d','d')
  val palindrome = List(1,2,3,4,5,6,5,4,3,2,1)
  val palindrome2 = List(1,2,3,3,2,1)

  test("Flatten() - Flattening a nested list") {assert(Functions.flatten2(List(0,1,List(10, 11, List(100,101), List(102)))) == List(0,1,10,11,100,101,102))}
  test("last() - Getting last element using LAST") {assert(Functions.last(fib) == 21)}
  test("last() (recursive) - Getting last element using LAST-RECURSIVE") {assert(Functions.lastRecursive(fib) == 21)}
  test("penultimate() - second-to-last element") {assert(Functions.penultimate(fib) == 13)}
  test("nth()") {assert(Functions.nth(4, fib) == 5)}
  test("nthRecursive()") {assert(Functions.nthRec(4, fib) == 5 & Functions.nthRec(3, fib) == 3)}
  test("compress() - removing duplicates found in a row") {
    assert(Functions.compress(fib) == List(1,2,3,5,8,13,21)
      & Functions.compress(letters) == List('a','b','c','d')
      & Functions.compress(List()) == List()
  )}
  test("reverse()") {assert(Functions.reverse(fib) == List(21,13,8,5,3,2,1,1))}
  test("revFunc()") {assert(Functions.reverse_Functional(fib) == List(21,13,8,5,3,2,1,1))}
  test("revTailRecursive()") {assert(Functions.revTailRecursive(fib) == List(21,13,8,5,3,2,1,1))}
  test("isPalin() negative") {assert(!Functions.isPalin(fib))}
  test("isPalin() positive") {assert(Functions.isPalin(palindrome))}
  test("isPalin() positive2") {assert(Functions.isPalin(palindrome2))}


}