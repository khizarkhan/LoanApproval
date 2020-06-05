package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;
import com.service.UserService;
import com.vo.User;

import groovy.transform.builder.InitializerStrategy.UNSET;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> save(User user) {
		if(getuserByname(user.getName())) {
			return null;
		}
		userRepository.save(user);
		return getAlluser();
	}

	private boolean getuserByname(String username) {
		Optional<Long>opt = userRepository.findByUserName(username);
		if(opt.isPresent())
			return true;
		return false;
		
	}

	@Override
	public List<User> update(long id) {
		//userRepository.up
		return getAlluser();
	}

	@Override
	public List<User> delete(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return getAlluser();
	}

	@Override
	public User getUser(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAlluser() {
		
		List<User>user = new ArrayList<User>();
				userRepository.findAll().forEach( e-> user.add(e));
		return user;
	}

	@Override
	public String validatUser(String uName, String pass) {
		Optional<Long>opt =   userRepository.valiidate(uName, pass);
		if(opt.isPresent())
		return "success";
		else
		return "fail";
	}

	
}
