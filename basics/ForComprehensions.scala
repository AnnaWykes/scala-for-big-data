object forComprehensions extends App {
    for (i <- 1 to 10)
      println(i)
    
      val result1 = for(i <- 1 to 10) yield (i + 1)
      println(result1)
    
      // does the same as result 1
      val result2 = (1 to 10).map(_ + 1)
    
      println(result1)
    
      val result3 = for (i <- Some(100)) yield (i + 10)
      println(result3)
    
      val result4 = Some(100).map(i => i + 40)
      println(result4)
    
      val result5 = for (i <- List(1,2,3,4); j <- List(5,6,7,8)) yield (i, j)
      println(result5)
    
      val result6 = List(1,2,3,4).flatMap(i => List(5,6,7,8).map(j => (i, j)))
    
      println(result6)
    
      val result7 = for (i <- List(1,2,3,4) if(i % 2) == 0; j <- List(5,6,7,8)) yield (i,j)
      println(result7)
    
      val result8 = for (i <- List(1,2,3,4);
      j <- List(5,6,7,8) if (j < 7)) yield (i, j)
    
      println(result8)
    
      val result11 = List(1,2,3,4).filter(i => i % 2 ==0).flatMap(i => List(5,6,7,8).map(j =>(i, j)))
    println(result11)
    
      val result12 = List(1,2,3,4).flatMap(i => List(5,6,7,8).filter(j => j < 7).map(j => (i,j)))
    // withfilter can be used instead of filter, with filter is lazy
      println(result12)
    }