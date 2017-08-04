package org.uqbar.arena.transactions.domain;

import java.util.ArrayList
import org.uqbar.commons.model.Entity
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.mutable.Buffer
import org.uqbar.commons.model.annotations.TransactionalAndObservable

@TransactionalAndObservable
class Client extends Entity {
  var dni: Long = _
  var name: String = _ 
  var password: String = _
  var email: String = _
  
  def this(dni: Long, name: String , password: String, email: String){
    this()
    this.dni = dni
    this.name = name
    this.password = password
    this.email = email
  }

  var accounts: java.util.List[Account] = Buffer[Account]()

  def addAccount(account: Account) {
    accounts = accounts += account
  }

  def removeAccount(account: Account) {
    accounts = accounts -= account
  }

  override def toString() = s"Cliente $name  dni: $dni"
}
