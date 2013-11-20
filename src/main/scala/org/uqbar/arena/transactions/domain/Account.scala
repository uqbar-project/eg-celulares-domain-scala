package org.uqbar.arena.transactions.domain;

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.TransactionalAndObservable


@TransactionalAndObservable
class Account(var balance:Double, var owner:Client) extends Entity(){
	
	def this(balance:Double, owner:Client, id:Int){
	  this(balance, owner)
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
