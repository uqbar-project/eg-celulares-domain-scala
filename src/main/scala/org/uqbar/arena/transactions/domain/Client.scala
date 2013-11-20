package org.uqbar.arena.transactions.domain;

import java.util.ArrayList
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.TransactionalAndObservable
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.mutable.Buffer

@TransactionalAndObservable
class Client(var dni: Long = 0, var name: String = "", var password: String = "", var email: String = "") extends Entity {

  def this() {
    this(0)
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
