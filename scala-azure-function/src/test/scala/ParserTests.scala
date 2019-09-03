import java.time.Instant

import org.scalatest.{FunSpec, Matchers}
//import test.utils.ResourceReader

//import scala.azure.function._

class ParseTest extends FunSpec with Matchers {

  val parse = new Parser()

  describe("Parser") {
    it("fails if XML is invalid") {
      parse("invalid xml").left.get.reason should startWith("Invalid XML:")
    }


   // it("fails if employee node is missing") {
   //   parse("<employee/>").left.get.reason should
    //    startWith("Could not find element: Cannot find unique child")
   // }

  }
//
//    it("fails if order code is missing") {
//      parse("<paymentService><notify><orderStatusEvent/></notify></paymentService>").left.get.reason should
//        startWith("Could not find element: Cannot find unique child")
//    }
//
//    it("fails if payment node is missing") {
//      val xml =
//        """<paymentService>
//          |  <notify>
//          |    <orderStatusEvent orderCode="20190101120000-ref"/>
//          |  </notify>
//          |</paymentService>""".stripMargin
//      parse(xml).left.get.reason should startWith(
//        "Could not find element: Cannot find unique child"
//      )
    //}
 // }
}