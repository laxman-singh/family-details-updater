package com.laxman.updater.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laxman.updater.model.AppUser;
import com.laxman.updater.model.Role;
import com.laxman.updater.repository.RoleRepository;
import com.laxman.updater.repository.UserRepository;

/**
 * @author Laxman Singh ~ laxman.1390@gmail.com
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	/* (non-Javadoc)
	 * @see com.laxman.updater.service.UserService#findUserByEmail(java.lang.String)
	 */
	@Override
	public AppUser findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.laxman.updater.service.UserService#saveUser(com.laxman.updater.model.AppUser)
	 */
	@Override
	public void saveUser(AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
