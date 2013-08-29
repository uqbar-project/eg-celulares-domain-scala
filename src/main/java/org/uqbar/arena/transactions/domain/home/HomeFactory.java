package org.uqbar.arena.transactions.domain.home;

import java.util.Map;

import org.uqbar.commons.model.Home;

public interface HomeFactory {

	void addHomes(Map<Class<?>, Home<?>> homes);

}
