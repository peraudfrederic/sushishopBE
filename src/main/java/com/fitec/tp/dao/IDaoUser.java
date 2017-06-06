package com.fitec.tp.dao;

import com.fitec.tp.entity.User;

public interface IDaoUser extends IDao<User> {
	
	public User selectByEmail(String mail);
	
	public User insert(User user);
	
	
}
