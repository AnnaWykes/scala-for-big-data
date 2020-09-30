// Databricks notebook source
import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId}
import java.util._
import scala.collection.JavaConversions._


import scala.util._ //.{Try, Success, Failure, Either}
import scala.xml._

// COMMAND ----------

case class Employee(firstName: String, lastName:String, age: Int)

// COMMAND ----------

//Expects XML in following format
val payload = """<employee>
  <firstname></firstname>
  <lastname></lastname>
  <age></age>
</employee>"""

// COMMAND ----------

     def tryWith[T](toErrorMessage: Throwable => String)(f: => T): Try[T] =
       Try { f }

// COMMAND ----------

    def parse(pl: String): Try[scala.xml.Elem] =
    tryWith(e => s"Invalid XML: ${e.getMessage}") {
      XML.loadString(pl)
    }

// COMMAND ----------

      def findIn[T](node: Node, path: Node => T): Try[T] =
     tryWith(e => s"Could not find element: ${e.getMessage}") {
       path(node)
     }

// COMMAND ----------

  implicit class NodeOps(node: Node) {
    // Find unique child node
    // Note the use of >> as the function name which is used above in the 'apply' method
    def >>(name: String): Node = {
      val children = node \ name
      if (children.size != 1) throw new Exception(s"Cannot find unique child '$name'")
      children.head
    }
  }

// COMMAND ----------

def transformXML(payload:String): Try[Employee] = {
  for {
    xml <- parse(payload)
    firstname <- findIn(xml, x => (x >> "firstname").text)
    lastname  <- findIn(xml, x => (x >> "lastname").text)
    age       <- findIn(xml, x => (x >> "age").text.toInt)
  }
  yield Employee(firstName = firstname,lastName = lastname, age = age)

  
}

// COMMAND ----------

val payload2 = """<employee>
  <firstname>Anna</firstname>
  <lastname>Wykes</lastname>
  <age>1</age>
</employee>"""

val result = transformXML(payload2)

// COMMAND ----------

result.getOrElse(0)

// COMMAND ----------

result.map(f => f)
    .recover {
      case e: Exception => 0
    }

// COMMAND ----------

val returnedVal = transformXML(payload2) match {
      case Success(v) => v
      case Failure(e) =>
        println(e)
    }
