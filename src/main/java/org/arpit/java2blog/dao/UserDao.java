package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.User;

public interface UserDao {
	
	public List<User> getAllUsers() ;

	public User getUser(int id) ;

	public User addUser(User user);

	public void updateUser(User user) ;

	public void deleteUser(int id) ;
}