import org.scalatest._
import example.Functions

class TestHello extends FunSuite with DiagrammedAssertions {
  val fib = List(1,1,2,3,5,8,13,21)
  val letters = List('a','b','b','c','c','d','d','d')
  val palindrome = List(1,2,3,4,5,6,5,4,3,2,1)
  val palindrome2 = List(1,2,3,3,2,1)
  val (multirepeating, multirepeating_solution) = (List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e), List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))

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

  test("pack_elements()") {assert(Functions.pack_elements(palindrome2) == List(List(1),List(2),List(3,3),List(2),List(1)))}
  test("encode()") {assert(Functions.encode(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}
  test("encodeModified() 1") {assert(Functions.encodeModified(palindrome2) == List(1,2,(2,3),2,1))}
  test("encodeModified() 2") {assert(Functions.encodeModified(multirepeating) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))}
  test("encodeModifiedSolution() 1") {assert(Functions.encodeModifiedSolution(palindrome2) == List(1,2,(2,3),2,1))}
  test(testName="encodeModifiedSolution() 2") {assert(Functions.encodeModifiedSolution(multirepeating) == multirepeating_solution)}

  test("decode()") {assert(Functions.decode(List((1,1),(2,2),(3,3))) == List(1,2,2,3,3,3))}
  test("encodeDirect()") {assert(Functions.encodeDirect(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}
  test("encodeDirectSolution()") {assert(Functions.encodeDirectSolution(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}




}