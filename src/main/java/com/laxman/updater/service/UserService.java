package com.laxman.updater.service;

import com.laxman.updater.model.AppUser;


public interface UserService {
	
	AppUser findUserByEmail(String email);
	void saveUser(AppUser user);

}
