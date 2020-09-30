import scala.collection.immutable.Nil
object map extends App
{
val a = List(1,2,3,4,5)

a match {
    case Nil => 
    case head :: tl => List(a)
} 

val c:Option[String] = Some("value")
val b:Option[String] = None 


}