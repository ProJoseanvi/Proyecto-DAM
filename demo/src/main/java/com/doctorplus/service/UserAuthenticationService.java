package com.doctorplus.service;

import com.doctorplus.dto.User;

public interface UserAuthenticationService {

	String login(String username, String password);

	User findByToken(String token);

	void logout(User user);
}
