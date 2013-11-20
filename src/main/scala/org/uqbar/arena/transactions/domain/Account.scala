package org.uqbar.arena.transactions.domain;

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.TransactionalAndObservable
import scala.reflect.BeanProperty

@TransactionalAndObservable
class Account() extends Entity {
	@BeanProperty var balance : Double = 0
	@BeanProperty var owner : Client = null
  
	def this(b: Double, o :Client) {
	  this()
	  balance = b
	  owner = o
	}
	
	def this(b: Double, o :Client, id:Int){
	  this(b, o)
	  owner.addAccount(this)
	  setId(id);
	}

	def withdraw(amount:Double) = {
		if(balance < amount){
			throw new UserException("Fondos insuficientes")			
		}
		balance -= amount
	}

	def deposit(amount:Double)  = balance += amount
	
	override def toString() =  s"Account -> owner: $owner balance: $balance"
	
}
