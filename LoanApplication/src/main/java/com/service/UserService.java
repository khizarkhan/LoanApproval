package com.service;
import java.util.List;

import com.vo.User;

public interface UserService {
	
	public List<User> update(long id);
	public List<User> delete(long id);
	public User getUser(long id);
	public List<User> getAlluser();
	List<User> save(User user);
	public String validatUser(String uName, String pass);

}
