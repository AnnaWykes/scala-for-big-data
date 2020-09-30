// Databricks notebook source
case class Employee(firstname: String, lastname:String)

// COMMAND ----------

val emp = Employee("Ada", "Lovelace")

// COMMAND ----------

emp.hashCode()

// COMMAND ----------

val emp2 = emp.copy()


// COMMAND ----------

val emp3 = emp.copy(firstname= "Dave")

// COMMAND ----------

emp2.firstname = "dave"

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC emp = True
// MAGIC emp
// MAGIC 
// MAGIC emp = "Dave"
// MAGIC emp
