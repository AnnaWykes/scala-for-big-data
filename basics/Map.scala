object map extends App {
    
    ////////       Map       //////////
    //Scala List
    val a = List(1,2,3,4,5)
    // map the values of 'a' to a list of lists
     println(a.map(x => List(x, 0)))
    //without map we would have to use a forloop that appends every item 
}
