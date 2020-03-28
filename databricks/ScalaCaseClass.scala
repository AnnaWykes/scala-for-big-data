// Databricks notebook source
spark.conf.set("fs.azure.createRemoteFileSystemDuringInitialization", "true")
dbutils.fs.ls("abfss://scala-for-big-data@scalaforbigdatasa.dfs.core.windows.net/")
spark.conf.set("fs.azure.createRemoteFileSystemDuringInitialization", "false")

// COMMAND ----------

// You can also use OAuth 2 with Databricks Runtime 5.1 or above to authenticate the filesystem initialization.
spark.conf.set("fs.azure.account.key.scalaforbigdatasa.dfs.core.windows.net", dbutils.secrets.get(scope = "scalaforbigdata", key = "storageacountkeysa"))

// COMMAND ----------

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "14f51b30-18ab-40e4-9999-4414fec9e0d5",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "scalaforbigdata", key = "clientsecret"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/5a817c6b-586d-4c36-ae1f-45feb48cbf2d/oauth2/token")



// COMMAND ----------

// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://scala-for-big-data@scalaforbigdatasa.dfs.core.windows.net/",
  //what ever you want to call your mount point
  mountPoint = "/mnt/employeedata",
  extraConfigs = configs)

// COMMAND ----------

case class Employee(id: String, firstName: String, lastName:String, age:String)    
      
val newEmployeeDs = spark.read.json("/mnt/employeedata/Raw/2019/10/01").as[Employee];
def existingEmployeesDs = List(new Employee("123456", "Anna", "Wykes", "21"));

val exists = existingEmployeesDs.filter { _.hashCode == newEmployeeDs.first().hashCode() }


 if (exists.length == 0)
 {
   //write to datalake as new record
   newEmployeeDs.write.mode("overwrite").format("Employee.json").json("/mnt/employeedata/Refined/")
 }
 else 
 {
   
   val existingRecord = existingEmployeesDs.filter { _.id == newEmployeeDs.first().id }
   //here you can perform custom logic on existing data vs new data
   //update record in datalake
   newEmployeeDs.write.mode("overwrite").format(s"Employee.json").json("/mnt/employeedata/Refined")

 }

display(newEmployeeDs)
 


// COMMAND ----------

dbutils.fs.unmount("/mnt/employeedata")
