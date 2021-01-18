package com.hcl.controller;
import java.util.List;

import com.hcl.model.User;

public interface UserService {

	public void save(User user);

	public List<User> listAll();
	
	public void delete(Long id);

	public User get(Long id);

}