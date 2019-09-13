object CaseClasses extends App{
    val emp = new Employee("Ada", "Lovelace")
          println(emp)
          //println(emp.hashCode())
 }

 case class Employee(firstName: String, lastName:String)