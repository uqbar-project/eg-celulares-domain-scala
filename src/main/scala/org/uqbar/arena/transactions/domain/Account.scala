package org.uqbar.arena.transactions.domain;

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.TransactionalAndObservable
import scala.reflect.BeanProperty

@TransactionalAndObservable
class Account extends Entity {
  var balance: Double = _
  var owner: Client = _

  def this(balance: Double, owner: Client, id: Int) {
    this()
    this.balance = balance
    this.owner = owner
    owner.addAccount(this)
    setId(id);
  }

  def this(owner: Client) {
    this(0, owner, 0)
  }

  def withdraw(amount: Double) = {
    if (balance < amount) {
      throw new UserException("Fondos insuficientes")
    }
    balance -= amount
  }

  def deposit(amount: Double) = balance += amount

  override def toString() = s"Account -> owner: $owner balance: $balance"

}
