package org.uqbar.arena.transactions.domain;

import org.uqbar.commons.utils.TransactionalAndObservable;
import scala.reflect.BeanProperty

object Transaction {
  val SOURCE = "source"
  val DESTINATION = "destination"
  val AMOUNT = "amount"

}
@TransactionalAndObservable
class Transaction {
  
  var source: Account=_
  var destination: Account =_
  var amount: Double = _

  def execute() {
    source.withdraw(amount)
    destination.deposit(amount)
  }

  override def toString() = s"source: $source  destiny: $destination  amount: $amount"

}
