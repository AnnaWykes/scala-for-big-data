//package scala.azure.function

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId}


import scala.util.Try
import scala.xml._



class Parser() {
  def apply(payload: String): Either[Error, Employee] =
    for {
      xml              <- parse(payload)
      firstname     <-   findIn(xml, fn => (fn >> "firstname").text)
      lastname     <-    findIn(xml, ln => (ln >> "lastname").text)
      age     <-    findIn(xml, ln => (ln >> "age").text.toInt)
    } yield Employee(firstName = firstname,lastName = lastname, age = age)

    private def parse(payload: String): Either[Error, Elem] =
     tryWith(e => s"Invalid XML: ${e.getMessage}") {
       XML.loadString(payload)
     }

     private def tryWith[T](toErrorMessage: Throwable => String)(f: => T): Either[Error, T] =
     Try { f }.toEither.fold(e => Left(Error(toErrorMessage(e))), Right(_))

     private def findIn[T](node: Node, path: Node => T): Either[Error, T] =
     tryWith(e => s"Could not find element: ${e.getMessage}") {
       path(node)
     }

  implicit class NodeOps(node: Node) {
    // Find unique child node
    def >>(name: String): Node = {
      val children = node \ name
      if (children.size != 1) throw new Exception(s"Cannot find unique child '$name'")
      children.head
    }
  }

 
}