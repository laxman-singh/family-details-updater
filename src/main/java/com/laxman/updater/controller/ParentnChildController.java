package com.laxman.updater.controller;

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
import com.laxman.updater.model.ParentDetails;
import com.laxman.updater.service.ParentnChildService;
import com.laxman.updater.service.UserService;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
@Controller
public class ParentnChildController {
	
	@Autowired
	private ParentnChildService parentChildService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/admin/addParentDetails", method=RequestMethod.GET)
	public ModelAndView addParentDetail() {
		
		ModelAndView modelAndView = new ModelAndView();
		ParentDetails parentDetails = new ParentDetails();
		modelAndView.addObject("parentDetails", parentDetails);
		modelAndView.setViewName("admin/addParentDetail");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/addParentDetails", method=RequestMethod.POST)
	public ModelAndView addParentDetail(@Valid ParentDetails parentDetails, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/addParentDetail");
		} else {
			//parentDetails.getChildrenDetails().stream().forEach(u -> u.setChildGender(u.getChildGender().getGenderName()));
			parentDetails.getChildrenDetails().stream().forEach(u -> u.setParentDetails(parentDetails));
			parentChildService.saveParentnChildDetail(parentDetails);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			AppUser user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName",
					"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
			modelAndView.addObject("parentDetails", parentChildService.getAllParentChildDetails());
			modelAndView.addObject("msg", "Details added successfully");
			modelAndView.setViewName("admin/home");
		}
		return modelAndView;
	}

}
