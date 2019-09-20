object FoldAndReduce extends App {
    val foldLeftResult = (1 to 10).foldLeft(0)((total:Int, next:Int) => total + next)
    //println(foldLeftResult)

    println("---------")

    val foldLeftResult2 = (1 to 10).foldLeft(0){(total:Int, next:Int) => 
    //println(s"Total: $total, Next: $next")
    total + next}
    //println(foldLeftResult)

    println("---------")

    val reduceLeftResult = (1 to 10).reduceLeft{(total:Int, next:Int) => 
        println(s"Total: $total, Next: $next")
        total + next}
        println(reduceLeftResult)

        println(List(1, 2, 3).foldLeft(0)(_ + _))
        println(List(1, 2, 3).foldRight(0)(_ + _))
}