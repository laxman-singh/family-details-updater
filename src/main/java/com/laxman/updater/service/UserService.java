package com.laxman.updater.service;

import com.laxman.updater.model.AppUser;


public interface UserService {
	
	public AppUser findUserByEmail(String email);
	public void saveUser(AppUser user);

}
