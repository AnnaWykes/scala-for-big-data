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


   it("fails if lastname node is missing") {
     parse("<employee/>").left.get.reason should
       startWith("Could not find element: Cannot find unique child")
   }

   it("fails if firstname node is missing") {
    parse("<employee/>").left.get.reason should
      startWith("Could not find element: Cannot find unique child")
  }

  it("fails if age node is missing") {
    parse("<employee/>").left.get.reason should
      startWith("Could not find element: Cannot find unique child")
  }

  }

}