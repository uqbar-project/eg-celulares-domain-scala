package org.uqbar.arena.transactions.domain;

import org.uqbar.commons.utils.TransactionalAndObservable;

object Transaction {
  val SOURCE = "source"
  val DESTINATION = "destination"
  val AMOUNT = "amount"

}
@TransactionalAndObservable
class Transaction(var source: Account = null, var destination: Account = null, var amount: Double = 0) {

  def this(){
    this(null)
  }
  
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
