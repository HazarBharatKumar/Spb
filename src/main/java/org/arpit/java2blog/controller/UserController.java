package org.arpit.java2blog.controller;

import java.util.List;
import org.arpit.java2blog.model.User;
import org.arpit.java2blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllUsers(Model model) {

		List<User> listOfUsers = userservice.getAllUsers();
		model.addAttribute("user", new User());
		model.addAttribute("listOfUsers", listOfUsers);
		return "UserRegistration";
	}

	@RequestMapping(value = "/userregistration", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllUsers";
	}
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return userservice.getUser(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user") User user) {	
		if(user.getId()==0)
		{
			
			userservice.addUser(user);
		}
		else
		{	
			userservice.updateUser(user);
		}

		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,Model model) {
		model.addAttribute("user", this.userservice.getUser(id));
		model.addAttribute("listOfUsers", this.userservice.getAllUsers());
		return "UserRegistration";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		userservice.deleteUser(id);
		return "redirect:/getAllUsers";

	}	
}
