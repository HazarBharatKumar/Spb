package org.arpit.java2blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.UserDao;
import org.arpit.java2blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserService {
	
	@Autowired
	UserDao userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public void addUser(User user) {
		
		userDao.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	
    }

}