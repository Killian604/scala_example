import example.Functions
import org.scalatest._

class TestExampleFunctions extends FunSuite with DiagrammedAssertions {
  val fib = List(1,1,2,3,5,8,13,21)
  val letters = List('a','b','b','c','c','d','d','d')
  val palindrome = List(1,2,3,4,5,6,5,4,3,2,1)
  val palindrome2 = List(1,2,3,3,2,1)
  val (multirepeating, multirepeating_solution) = (List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e), List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))

  test(testName="Flatten() - Flattening a nested list") {assert(Functions.flatten2(List(0,1,List(10, 11, List(100,101), List(102)))) == List(0,1,10,11,100,101,102))}
  test(testName="last() - Getting last element using LAST") {assert(Functions.last(fib) == 21)}
  test(testName="last() (recursive) - Getting last element using LAST-RECURSIVE") {assert(Functions.lastRecursive(fib) == 21)}
  test(testName="penultimate() - second-to-last element") {assert(Functions.penultimate(fib) == 13)}
  test(testName="nth()") {assert(Functions.nth(4, fib) == 5)}
  test(testName="nthRecursive()") {assert(Functions.nthRec(4, fib) == 5 & Functions.nthRec(3, fib) == 3)}
  test(testName="compress() - removing duplicates found in a row") {
    assert(Functions.compress(fib) == List(1,2,3,5,8,13,21)
      & Functions.compress(letters) == List('a','b','c','d')
      & Functions.compress(List()) == List()
  )}
  test(testName="reverse()") {assert(Functions.reverse(fib) == List(21,13,8,5,3,2,1,1))}
  test(testName="revFunc()") {assert(Functions.reverse_Functional(fib) == List(21,13,8,5,3,2,1,1))}
  test(testName="revTailRecursive()") {assert(Functions.revTailRecursive(fib) == List(21,13,8,5,3,2,1,1))}
  test(testName="isPalin() negative") {assert(!Functions.isPalin(fib))}
  test(testName="isPalin() positive") {assert(Functions.isPalin(palindrome))}
  test(testName="isPalin() positive2") {assert(Functions.isPalin(palindrome2))}

  test(testName="pack_elements()") {assert(Functions.pack_elements(palindrome2) == List(List(1),List(2),List(3,3),List(2),List(1)))}
  test(testName="encode()") {assert(Functions.encode(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}
  test(testName="encodeModified() 1") {assert(Functions.encodeModified(palindrome2) == List(1,2,(2,3),2,1))}
  test(testName="encodeModified() 2") {assert(Functions.encodeModified(multirepeating) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))}
  test(testName="encodeModifiedSolution() 1") {assert(Functions.encodeModifiedSolution(palindrome2) == List(1,2,(2,3),2,1))}
  test(testName="encodeModifiedSolution() 2") {assert(Functions.encodeModifiedSolution(multirepeating) == multirepeating_solution)}

  test(testName="decode()") {assert(Functions.decode(List((1,1),(2,2),(3,3))) == List(1,2,2,3,3,3))}
  test(testName="encodeDirect()") {assert(Functions.encodeDirect(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}
  test(testName="encodeDirectSolution()") {assert(Functions.encodeDirectSolution(palindrome2) == List((1, 1),(1,2),(2,3),(1, 2),(1,1)))}

  test(testName="duplicateN()") {assert(Functions.duplicateN(3, List(1,2,3)) == List(1,1,1,2,2,2,3,3,3))}
  test(testName="dropNth()") {assert( Functions.dropNth(2, List(1,2,3,4,5,6)) == List(1,3,5) )}
  test(testName="dropNth() 2") {assert(
    Functions.dropNth(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  )}
  test(testName="split()") {assert(Functions.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))}

  test(testName="removeAt()") {assert(Functions.removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))}
  test(testName="removeAt() 2") {assert(Functions.removeAt(0, List('a, 'b, 'c, 'd)) == (List('b, 'c, 'd),'a))}
  test(testName="insertAt()") {assert(Functions.insertAt('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))}
  test(testName="insertAt() 2") {assert(Functions.insertAt('new, 0, List('a, 'b, 'c, 'd)) == List('new, 'a, 'b, 'c, 'd))}
  test(testName="insertAtSolution()") {assert(Functions.insertAtSolution('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))}
  test(testName="insertAtSolution() 2") {assert(Functions.insertAtSolution('new, 0, List('a, 'b, 'c, 'd)) == List('new, 'a, 'b, 'c, 'd))}



}