package org.uqbar.arena.transactions.domain.home;

import java.util.Map;

import org.uqbar.arena.transactions.domain.Account;
import org.uqbar.arena.transactions.domain.Client;
import org.uqbar.commons.model.Home;


public class DefaultPersistentHomeFactory implements HomeFactory {

	@SuppressWarnings("rawtypes")
	private void addHome(Map<Class<?>, Home<?>> homes, Class... entityType) {
//		for (Class clazz : entityType) {
//			homes.put(clazz, this.createHome(clazz));
//		}
		homes.put(Account.class, new AccountColeccionImpl());
		final ClientColeccionImpl clientDAO = new ClientColeccionImpl();
		homes.put(Client.class, clientDAO);
		clientDAO.init();
	}

	public void addHomes(Map<Class<?>, Home<?>> homes) {
		this.addHome(homes, Client.class);
	}

}
