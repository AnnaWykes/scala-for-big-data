import java.util.UUID
case class Employee(id: String, firstName: String, lastName:String, age:Int)

object compare extends App{

   val employeeId = UUID.randomUUID().toString();
   val newEmployee = new Employee(employeeId,"Firstname", "Lastname", 100);
   val exists = for (employee <- existingEmployees if (employee.hashCode == newEmployee.hashCode()))
   yield employee
   
   println(exists)
   println(exists.length)

    if(exists.length == 0)
    {
    //write to datalake as new record
    }
    else 
    {
        val exisitingRecord = for (employee <- existingEmployees if (employee.id == newEmployee.id))
        yield employee

        //update exisitingRecord in datalake
    }

    def existingEmployees:List[Employee] =
    {
     List(new Employee(employeeId, "Firstname", "Lastname", 100))
    }
}

