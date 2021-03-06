package com.laxman.updater.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laxman.updater.model.AppUser;
import com.laxman.updater.model.ChildrenDetails;
import com.laxman.updater.model.ParentDetails;
import com.laxman.updater.model.ChildrenDetails.Gender;
import com.laxman.updater.repository.ParentnChildRepository;
import com.laxman.updater.service.ParentnChildService;
import com.laxman.updater.service.UserService;

/**
 * 
 * @author laxman ~ laxman.1390@gmail.com
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private ParentnChildRepository parentChildRepo;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ParentnChildService parentChildService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		AppUser user = new AppUser();
		modelAndView.addObject("appUser", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid AppUser user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		AppUser userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("appUser", new AppUser());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("parentDetails", parentChildService.getAllParentChildDetails());
		modelAndView.setViewName("admin/home");
		
		return modelAndView;
	}
}
