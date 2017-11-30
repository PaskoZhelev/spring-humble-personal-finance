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

import com.pmz.humble.model.forms.NewUserForm;
import com.pmz.humble.service.RegistrationService;

/**
 * @author pasko
 *
 */
@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		//model.addAttribute("newUserForm", new NewUserForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@ModelAttribute("newUserForm") @Valid NewUserForm newUserForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            return "login";
        }
		
//		if(registrationService.registerUser(newUserForm) == null) {
//			model.addAttribute("usernameExists", usernameTaken);
//			return "register";
//		}
		return "main";
	}
}
