package org.haim.springframwork.stackoverflow;

public interface DaoLocator {
		public GenericDao<?> lookup(String serviceName);
}
