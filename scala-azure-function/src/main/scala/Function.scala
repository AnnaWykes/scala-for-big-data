//package scala.azure.function

import java.util._

import com.microsoft.azure.functions.annotation._

import com.microsoft.azure.functions._

import scala.collection.JavaConversions._

class Function {
// to run: func host start
  @FunctionName("ScalaForBigData")
  def run(
           @HttpTrigger(
             name = "req",
             methods = Array(HttpMethod.GET, HttpMethod.POST),
             authLevel = AuthorizationLevel.ANONYMOUS) request: HttpRequestMessage[
             Optional[String]],
           context: ExecutionContext): HttpResponseMessage = {
    context.getLogger.info("Java HTTP trigger processed a request.")
    // Parse query parameter
   // val query: String = request.getQueryParameters.get("name")
    val body: String = request.getBody.orElse("error")
    println(body)
    if (body == "error") {
      request
        .createResponseBuilder(HttpStatus.BAD_REQUEST)
        .body("Please pass a request body")
        .build()
    } else { 
      val parser = new Parser()
      val result = parser(body)
      request
        .createResponseBuilder(HttpStatus.OK)
        .body(result)
        .build()
    }
  }

}