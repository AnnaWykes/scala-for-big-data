object FlatMap extends App {
    
    ////////       Map       //////////
    //Scala List
    val a = List(1,2,3,4,5)
    // map the values of 'a' to a list of lists
    println(a.flatMap(x => List(x, 0)))
    //flatterns everything into one List
}