package org.uqbar.arena.transactions.domain;

import java.util.HashMap;
import java.util.Map;

import org.uqbar.arena.transactions.domain.repo.DefaultPersistentRepoFactory;
import org.uqbar.arena.transactions.domain.repo.RepoFactory;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Repo;
import org.uqbar.commons.model.application.Application;


public class Bank implements Application {
	private static Bank instance;
	private Map<Class<?>, Repo<?>> Repos;

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Repo<T> getRepo(Class<? extends T> type) {
		return (Repo<T>) this.Repos.get(type);
	}

	public static Bank  initialize(RepoFactory factory) {
		instance = new Bank ();
		//HARDCODED: coupled with in-memory Repos. 
		Map<Class<?>, Repo<?>> Repos = new HashMap<Class<?>, Repo<?>>();
		factory.addRepos(Repos);
		instance.Repos = Repos;
		return instance;
	}
	
	public static synchronized Bank initialize() {
		return initialize(new DefaultPersistentRepoFactory()); //default is to persist with db4o
//		return initialize(new InMemoryHomeFactory()); //default is to persist with db4o
	}
	
	public static synchronized Bank  getInstance() {
		if (instance == null) {
			instance = initialize();
		}
		return instance;
	}

}
