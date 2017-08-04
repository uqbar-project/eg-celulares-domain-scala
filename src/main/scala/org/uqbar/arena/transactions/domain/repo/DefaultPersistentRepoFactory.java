package org.uqbar.arena.transactions.domain.repo;

import java.util.Map;

import org.uqbar.arena.transactions.domain.Account;
import org.uqbar.arena.transactions.domain.Client;
import org.uqbar.commons.model.Repo;


public class DefaultPersistentRepoFactory implements RepoFactory {

	@SuppressWarnings("rawtypes")
	private void addRepo(Map<Class<?>, Repo<?>> Repos, Class... entityType) {
//		for (Class clazz : entityType) {
//			Repos.put(clazz, this.createRepo(clazz));
//		}
		Repos.put(Account.class, new AccountColeccionImpl());
		final ClientColeccionImpl clientDAO = new ClientColeccionImpl();
		Repos.put(Client.class, clientDAO);
		clientDAO.init();
	}

	public void addRepos(Map<Class<?>, Repo<?>> repos) {
		this.addRepo(repos, Client.class);
	}

}
