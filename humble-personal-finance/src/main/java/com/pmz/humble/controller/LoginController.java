package com.pmz.humble.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pmz.humble.model.forms.LoginUserForm;
import com.pmz.humble.service.LoginService;

/**
 * @author pasko
 *
 */
@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Value("${humble.registration.wrongUsernamePassword}")
	private String wrongUsernamePassword;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login-page")
	public String loginForm(Model model) {
		model.addAttribute("loginUserForm", new LoginUserForm());
		return getLoginView();
	}
	
	@PostMapping("/login-page")
	public String submitLoginForm(@ModelAttribute("loginUserForm") @Valid LoginUserForm loginUserForm,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			LOG.info("Login Controller: Errors in the form");
            return getLoginView();
        }
		
		if(loginService.loginUser(loginUserForm) == null) {
			LOG.info("Login Controller: The login service returned null (username or password is incorrect)");
			model.addAttribute("wrongUsernamePassword", wrongUsernamePassword);
			return getLoginView();
		}
		return getHomeView();
	}
	
	private String getLoginView() {
		return "login-page";
	}
	
	private String getHomeView() {
		return "home";	
	}
}
