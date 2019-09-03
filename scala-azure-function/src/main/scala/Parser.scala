//package scala.azure.function

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId}


import scala.util.Try
import scala.xml._

class Parser() {
  def apply(payload: String): Either[Error, Employee] =
    for {
      xml              <- parse(payload)
    //  employee <- findIn(xml, _ >> "notify" >> "orderStatusEvent")
//      // orderCode        <- findIn(employee, ose => (ose >> "@orderCode").text)
//      // payment          <- findIn(orderStatusEvent, _ >> "payment")
//      // amount           <- findIn(payment, p => (p >> "amount" >> "@value").text.toInt)
//      // exponent         <- findIn(payment, p => (p >> "amount" >> "@exponent").text.toInt)
//      // _                <- check(exponent, 2, "Exponent for amount must be 2")
//      // currency         <- findIn(payment, p => (p >> "amount" >> "@currencyCode").text)
//      // _                <- check(currency, "GBP", "Currency code must be GBP")
//      // timestamp        <- timestampFrom(orderCode)
//      // lastEvent        <- findIn(payment, p => (p >> "lastEvent").text)
//      // status <- tryWith(_ => "Could not parse status") {
//      //   statusFrom(
//      //     lastEvent,
//      //     maybeFindIn(
//      //       payment,
//      //       p => (p >> "paymentMethodDetail" >> "card" >> "@number").text.takeRight(4)
//      //     )
//      //   )
//      //}
    } yield Employee(
firstName = "",
lastName = "",
age = 0
    )

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

 // private def maybeFindIn[T](node: Node, path: Node => T): Option[T] = {
  //  Try { path(node) }.toOption
 // }


  // implicit class NodeOps(node: Node) {
  //   // Find unique child node
  //   def >>(name: String): Node = {
  //     val children = node \ name
  //     if (children.size != 1) throw new Exception(s"Cannot find unique child '$name'")
  //     children.head
  //   }
  // }


  // private def check[T](actual: T, expected: T, errorMessage: String): Either[Error, Unit] =
  //   if (actual == expected) Right(()) else Left(Error(errorMessage))

  // private val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
  // private def timestampFrom(orderCode: String): Either[Error, Instant] =
  //   tryWith(e => s"Could not retrieve timestamp from order code '$orderCode': ${e.getMessage}") {
  //     val dt = LocalDateTime.from(formatter.parse(orderCode.takeRight(14))).atZone(ZoneId.of("UTC"))
  //     Instant.from(dt)
  //   }
}