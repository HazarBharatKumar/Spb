package org.arpit.java2blog.controller;

import javax.validation.Valid;

import org.arpit.java2blog.model.Login;
import org.arpit.java2blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class LoginController {
	
	@Autowired
	UserService userservice;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin(Model model) { 
	    model.addAttribute("login", new Login()); 
	    return "Login"; 
	    
        }
	@RequestMapping(value = "/loginsuccess", method = RequestMethod.POST)
	public String loginUser(@Valid @ModelAttribute("login") Login login, BindingResult bindingresult) {
		System.out.println("-$@#" + login.getUsertype());
		if(bindingresult.hasErrors()) {
			return "login-user";
		}
			return "customerDetails";

		}
	}