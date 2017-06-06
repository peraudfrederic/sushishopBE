package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.User;

public interface IDao<IEntity> {

	public List<IEntity> selectAll();
	
	
}
