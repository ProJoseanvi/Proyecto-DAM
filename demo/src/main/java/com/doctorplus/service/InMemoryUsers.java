package com.doctorplus.service;

import com.doctorplus.dto.User;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InMemoryUsers implements UserCrudService {

	Map<String, User> users = new HashMap<>();

	  @Override
	  public User save(final User user) {
	    return users.put(user.getId(), user);
	  }

	  @Override
	  public User find(final String id) {
	    return users.get(id);
	  }

	  @Override
	  public User findByUsername(final String username) {
		  boolean found = false;
		  Iterator<User> it = this.users.values().iterator();
		  User result = null;
		  while (!found && it.hasNext()) {
			  result = it.next();
			  found = result.getUsername().equals(username);
		  }
		  return result;
	  }
}
