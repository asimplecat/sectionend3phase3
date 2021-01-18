package com.hcl.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl repo;
	
	@GetMapping("/add")
	public ModelAndView addUser()
	{	
		return new ModelAndView("newUser").addObject(repo);
	}
	
	@PostMapping("/add")
	public String addValid(@RequestParam("name") String name, @RequestParam("email") String email) {
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		repo.save(u);
		return "redirect:view/" + u.getAccountNum();
		
	}
	
	@GetMapping("/search")
	public ModelAndView getUser() {
		return new ModelAndView("search");
	}
	
	@PostMapping("/search")
	public String search2(@RequestParam("id") String id) {
		return "redirect:view/" + id;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		User u = repo.get(id);
		if (u == null)
		{
			return new ModelAndView("error");
		}
		return new ModelAndView("/view","user",u);
	}
	
//	@GetMapping("/edit")
//	public ModelAndView editUser(@RequestParam("id") Long id, ModelMap model)
//	{
//		User u = repo.get(id);
//		model.put("user", u);
//		return new ModelAndView("/edit");
//	}
	

	@PostMapping("/edit")
	public String saveUser(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("email") String email) {
		User user = repo.get(id);
		user.setName(name);
		user.setEmail(email);
		repo.save(user);
		
		return ("redirect:view/" + id);
	}
	
	
	@GetMapping("/edit")

	public ModelAndView editCustomerForm(@RequestParam long id) {

	    ModelAndView mav = new ModelAndView("edit");

	    User user = repo.get(id);

	    mav.addObject("user", user);

	    return mav;
	}
	
	@GetMapping("/error")
	public ModelAndView showError() {
		return new ModelAndView("error");
	}
}
