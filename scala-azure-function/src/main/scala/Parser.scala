

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId}


import scala.util.Try
import scala.xml._

//Expects XML in following format
//<employee>
  //<firstname></firstname>
  //<lastname><lastname>
  //<age></age>
//</employee>

class Parser() {
  // 'def apply(payload: String)' is a function that takes the xml (payload) as a string
  // 'Either[Error, Employee]': Either allows the 'for' to return either an 'Error' or 'Employee' 
  def apply(payload: String): Either[Error, Employee] =
  //'for' in Scala is a good example of a Monad: if the population of xml, firstname, lastname or age fails the 'for' will return the result on the line it failed on  
  for {
      xml              <- parse(payload)
      firstname        <- findIn(xml, x => (x >> "firstname").text)
      lastname         <- findIn(xml, x => (x >> "lastname").text)
      age              <- findIn(xml, x => (x >> "age").text.toInt)
    } 
    //yield returns the end result if nothing failed in the for Monad
    yield Employee(firstName = firstname,lastName = lastname, age = age)
    
    //'def parse(payload: String)' is a function that will check the xml string is valid xml,  
    //'Either[Error, Elm]': Either allows the 'trywith' to return either an 'Error' or 'XML Element' 
    private def parse(payload: String): Either[Error, Elem] =
     tryWith(e => s"Invalid XML: ${e.getMessage}") {
       XML.loadString(payload)
     }

     //'def tryWith[T]' a higher order function that will try to return the result of f : => T
     private def tryWith[T](toErrorMessage: Throwable => String)(f: => T): Either[Error, T] =
    // 'Left' returns the left result (the error) over thew right
    // 'fold' flatterns the result
    // 'toEither' returns the result of 'Left'
     Try { f }.toEither.fold(e => Left(Error(toErrorMessage(e))), Right(_))

     //'def findIn[T]' trys to find the element 'T' using the above 'tryWith method'
     private def findIn[T](node: Node, path: Node => T): Either[Error, T] =
     tryWith(e => s"Could not find element: ${e.getMessage}") {
       path(node)
     }

  implicit class NodeOps(node: Node) {
    // Find unique child node
    // Note the use of >> as the function name which is used above in the 'apply' method
    def >>(name: String): Node = {
      val children = node \ name
      if (children.size != 1) throw new Exception(s"Cannot find unique child '$name'")
      children.head
    }
  }

 
}