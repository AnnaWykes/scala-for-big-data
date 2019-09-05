object Options extends App{

 val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
      
 println("show(capitals.get( \"Japan\")) : " + show(capitals.get( "Japan")) )
 println("show(capitals.get( \"India\")) : " + show(capitals.get( "India")) )

println(None.asInstanceOf[Option[Int]].flatMap(x => Some(x + 19)))
println(Some(10).flatMap(x => None))
println(List(Some(4), None, Some(5), None, None, Some(10)).flatMap(x => x))



def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
}

}