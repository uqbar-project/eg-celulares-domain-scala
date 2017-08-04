package org.uqbar.arena.transactions.domain.repo;

import java.util.Map;

import org.uqbar.commons.model.Repo;

public interface RepoFactory {

	void addRepos(Map<Class<?>, Repo<?>> repos);

}
