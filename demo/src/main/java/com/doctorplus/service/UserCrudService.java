package com.doctorplus.service;

import com.doctorplus.dto.User;

public interface UserCrudService {

  User save(User user);

  User find(String id);

  User findByUsername(String username);
}
