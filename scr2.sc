def pack_elements[A](ls: List[A]): List[List[A]] = {
  if (ls.isEmpty) List(List())
  else {
    val (packed, next) = ls span {_ == ls.head}
    if (next == Nil) List(packed)
    else packed :: pack_elements(next)
  }
}
pack_elements(List(1,2,3,3,3,4))

//val xs = List(
//  Set(1, 2, 3),
//  Set(1, 2, 3)
//).flatten
//xs == List(1, 2, 3, 1, 2, 3)
//
//val y = List(0,1,List(10,11, List(100,101)))
//def flatten2[C <: List[Any]](list: C): List[Any] =
//  list flatMap {
//    case ms: List[_] => flatten2(ms)
//    case e => List(e)
//  }
//
//println("flatten(y) = " + flatten2(y))
//val isFlattenWorking = flatten2(y) == List(0,1,10,11,100,101)