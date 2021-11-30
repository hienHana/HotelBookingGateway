package com.synex.controller;
//
//import java.security.Principal;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.synex.domain.GuestDetail;
//import com.synex.domain.Role;
//import com.synex.domain.User;
//import com.synex.services.RoleService;
//import com.synex.services.UserService;
//
//@Controller
//public class UserController {
//	@Autowired UserService userService;
//	@Autowired BCryptPasswordEncoder bCryptEncoder;
//	@Autowired RoleService roleService;
//	
////	@RequestMapping(value="createUser", method=RequestMethod.GET)
////	public ResponseEntity<User> createUser(){
////		Role roleAdmin = new Role("Admin");
////		Role roleUser = new Role("User");
////		roleService.save(roleAdmin);
////		roleService.save(roleUser);
////		
////		Set<Role> rolesKate = new HashSet<>();
////		rolesKate.add(roleAdmin);
////		rolesKate.add(roleUser);
////		
////		User user = new User("kate","kate","kate@gmail.com","1234567");	
////		user.setRoles(rolesKate);
////		user.setPassword(encoder.encode(user.getPassword()));
////		userService.save(user);
////		return new ResponseEntity<User>(user, HttpStatus.CREATED);
////		
////	}
//
////	@RequestMapping(value="/", method=RequestMethod.GET)
////	public String welcome(){
////		return "home";
////	}
////	
////	
//	
//	
//	
//	@RequestMapping(value="userSignUpForm")
//	public String createUserSignUpForm() {
//		return "userSignUpForm";
//	}
//	
//	@RequestMapping(value="createUserSignUp" , method = RequestMethod.POST)
//	public String createUserSignUp(@Valid @ModelAttribute User user, BindingResult br) {
//		System.out.println("get user..." + user);
//		
//		if(!br.hasErrors()) {
//			String pw = bCryptEncoder.encode(user.getPassword());
//			user.setPassword(pw);
//			System.out.println("user + <your password>..." + user);
//			Set<Role> roles = new HashSet<>();
//			roles.add(roleService.findRoleByName("user"));
//			System.out.println("get roles..." + roles);
//			user.setRoles(roles);
//			System.out.println("save role..." + user);
//			user = userService.saveUser(user);
//			System.out.println("save user..." + user);
////			model.addAttribute("users", user);
//			return "home";
//		}
//		System.out.println("Fail to sign up");
//		return "userSignUpForm";
//	}
//	
//	
//	
//	@RequestMapping(value="/login")
//	public String logIn(
//			@RequestParam(value="logout", required=false) String logout,
//			@RequestParam(value="error", required=false) String error,
//			HttpServletRequest req, HttpServletResponse res, Model model
//			
//			){
//		
//		String errorMessage = null;
//		if(error!=null){
//			errorMessage = "Either the username or the <your password> is not correct.";
//		}
//		if(logout !=null){
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			
//			Collection<?> authorities  = auth.getAuthorities();
//			for (Object obj :  authorities){
//				if (obj instanceof GrantedAuthority )
//				System.out.println("****"+ ((GrantedAuthority) obj).getAuthority());
//			}
//			
//			if(auth != null){
//				System.out.println("inside auth != null: "+ auth);
//				new SecurityContextLogoutHandler().logout(req, res, auth);
//			}
//			System.out.println("1. auth: "+ auth);
//			System.out.println("2. auth: "+ SecurityContextHolder.getContext().getAuthentication());
//			return "redirect:/login";
//		}
//		
//		model.addAttribute("errorMessage", errorMessage);
//		return "login";
//	}
//	
//	@RequestMapping(value="accessDenied")
//	public String denyAccess(Model model, Principal principal){
//		String message =  "<strong> Hi " + principal.getName() + "</strong> !"+ "<br> You do not have access rights. Please return to home by clicking the below link";
//		model.addAttribute("message", message);
//		return "accessDenied";
//	}
//	
//	@RequestMapping(value= {"/home","/"})
//	public String home() {
//		
//		return "home";
//		
//	}
//}

/////////////////////////////////////////////////////////////////
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.synex.domain.Role;
import com.synex.domain.User;
import com.synex.services.RoleService;
import com.synex.services.UserService;



@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired UserService userService;
	@Autowired RoleService roleService;	
	@Autowired BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		if(error!=null) { //if authentication fails 
			message="Invalid Credentials";
		}
		if(logout!=null) { //if logout
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message="Logout";
			return "login";
		}
		model.addAttribute("Message", message);
		return "login";
		
	}
	
	@RequestMapping(value="/accessDeniedPage")
	public String accessDenied(Principal principal, Model model) {
		String message = "<strong> Hi " + principal.getName() + "</strong> !"
				+ "<br> You do not have access rights. Please return to home by clicking the link below";
		model.addAttribute("Message", message);
		return "accessDenied";
		
	}
	
	@RequestMapping(value="getUserSignUpForm")
	public String createUserForm(User user) {
		return "userSignUpForm";
	}
	
	@RequestMapping(value="createUser" , method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user, BindingResult br, Model model) {
		if(!br.hasErrors()) {
			String pw = bcryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(pw);
			Set<Role> roles = new HashSet<>();
			roles.add(roleService.findRoleByName("user"));
//			roles.add(roleService.findRoleByName("admin"));
			user.setRoles(roles);
			user = userService.saveUser(user);
			model.addAttribute("users", user);
			return "redirect:getGuestDetailForm";
		}
		return "userSignUpForm";
	}
	
	
	@RequestMapping(value= {"/home","/"})
	public String home() {	
		return "home";		
	}
	
	
	@RequestMapping (value="/admin")
	public String getAdminPage() {
		return "admin";
	}
	
	
	

//	@RequestMapping (value="/getUserSignUpForm")
//	public String getUserSignUpForm() {
//		return "userSignUpForm";
//	}
//	
//	@RequestMapping (value="/createUser", method = RequestMethod.POST)
//	public String createUser(User user) {
//		//create role table content. Run only once when table create
////		Role roleAdmin = new Role("admin");
//		Role roleUser = new Role("user");
////		roleService.save(roleAdmin);
////		roleService.save(roleUser);
//		
//		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
//		//set roles to user
//		Set<Role> roles = new HashSet<>();
////		roles.add(roleAdmin);
//		roles.add(roleUser);
//		user.setRoles(roles);
//		
//		userService.saveUser(user);
//		return "redirect:getGuestDetailForm";
//	
//	}

}
