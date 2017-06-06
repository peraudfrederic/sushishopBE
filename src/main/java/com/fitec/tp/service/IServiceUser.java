package com.fitec.tp.service;

import com.fitec.tp.entity.User;

public interface IServiceUser extends IService<User>{

	public User ajouterUser(User user);
	
	public User seConnecter(User user);
}
