package org.uqbar.arena.transactions.domain.repo;

import org.apache.commons.collections15.Predicate;
import org.uqbar.arena.transactions.domain.Account;
import org.uqbar.commons.model.CollectionBasedRepo;

public class AccountColeccionImpl extends CollectionBasedRepo<Account> {


	public Class<Account> getEntityType() {
		return Account.class;
	}

	public Account createExample() {
		throw new UnsupportedOperationException("no");
	}

	@Override
	protected Predicate<Account> getCriterio(Account example) {
		throw new UnsupportedOperationException("No se puede crear un criterio ");
	}

}
