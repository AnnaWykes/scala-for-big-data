 class examle_monad extends App
 {
 def apply()
 {
 val data:String = "one,two,three,four"
  
  for {
      xml              <- parse(xmlData)
      firstname        <- findIn(xml, x => (x >> "firstname").text)
      lastname         <- findIn(xml, x => (x >> "lastname").text)
      age              <- findIn(xml, x => (x >> "age").text.toInt)
    } 
    yield (firstname,lastname,age)
 }
}

object example_monad {
  def main(args: Array[String]): Unit = {
     val data:String = "one,two,three,four"
  
  for {
      xml              <- parse(xmlData)
      firstname        <- findIn(xml, x => (x >> "firstname").text)
      lastname         <- findIn(xml, x => (x >> "lastname").text)
      age              <- findIn(xml, x => (x >> "age").text.toInt)
    } 
    yield (firstname,lastname,age)
 }
}