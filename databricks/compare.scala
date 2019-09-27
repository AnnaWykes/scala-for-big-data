import java.util.UUID
case class Employee(id: String, firstName: String, lastName:String, age:Int)

object compare extends App {

    val employeeId = UUID.randomUUID().toString();
    val newEmployee = new Employee(employeeId,"Firstname", "Lastname", 100);
    val exists = existingEmployees.filter { _.hashCode == newEmployee.hashCode() }
    
    println(exists)
    println(exists.length)
 
     if (exists.length == 0)
     {
       // write to datalake as new record
     }
     else 
     {
       val existingRecord = existingEmployees.filter { _.id == newEmployee.id }
       // update exisitingRecord in datalake
     }
 
     def existingEmployees = List(new Employee(employeeId, "Firstname", "Lastname", 100))
 
}

