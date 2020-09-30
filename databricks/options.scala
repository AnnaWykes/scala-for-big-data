// Databricks notebook source
val a:Option[String] = Some("value")
val b:Option[String] = None

// COMMAND ----------

a.isEmpty
b.isEmpty

// COMMAND ----------

def showmatch(x:Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

// COMMAND ----------

showmatch(b)

// COMMAND ----------

a.getOrElse("?")
