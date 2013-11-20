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
  @BeanProperty var source: Account = null
  @BeanProperty var destination: Account = null
  @BeanProperty var amount: Double = 0d
  
  def execute() {
    source.withdraw(amount)
    destination.deposit(amount)
  }

  def clear() {
    this.amount = 0;
    this.source = null;
    this.destination = null;
  }

  override def toString() = s"source: $source  destiny: $destination  amount: $amount"

}
