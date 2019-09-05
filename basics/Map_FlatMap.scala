
object flatmap2 extends App {
    
    ////////       Map       //////////
    val a = List(1,2,3,4,5)
     println(a.map(x => List(x, 0)))

     val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
      
     println("capitals.get( \"France\" ) : " +  capitals.get( "France" ))
     println("capitals.get( \"India\" ) : " +  capitals.get( "India" ))

     ///////////   Flat Map  ////////
     println(a.map(x => List(x, 0)).flatten)
     println(a.flatMap(x => List(x, 0)))
   
     val b:List[List[List[Int]]] = List(List(List(1,2,3),List(4,5,6)),
                                   List(List(7,8,9), List(10,11,12)))
     println(b.flatMap(c => c).flatMap(c =>c).flatMap(c => List(-c, c)))
   
     println(Set(2,4,10,11).flatMap(x => Set(x, x * 5)))
   
    val orgMap = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
   
    println(orgMap.flatMap(t => Map(t._1 -> t._2, (t._1 * 100) -> (t._2 + "Hundred"))))

   }