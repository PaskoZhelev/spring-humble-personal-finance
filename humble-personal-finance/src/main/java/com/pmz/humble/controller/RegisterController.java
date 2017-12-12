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
public class RegisterController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);
	
	@Value("${humble.registration.usernameTaken}")
	private String usernameTaken;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("newUserForm", new NewUserForm());
		return getRegisterView();
	}
	
	@PostMapping("/register")
	public String submitRegisterForm(@ModelAttribute("newUserForm") @Valid NewUserForm newUserForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
            return getRegisterView();
        }
		
		if(registrationService.registerUser(newUserForm) == null) {
			model.addAttribute("usernameExists", usernameTaken);
			return getRegisterView();
		}
		return getLoginView();
	}
	
	private String getRegisterView() {
		return "register";
	}
	
	private String getLoginView() {
		return "redirect:login-page";	
	}
}
