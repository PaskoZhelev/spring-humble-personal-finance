package com.pmz.humble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pasko
 *
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getIndex() {
		return "home";
	}
	
	@GetMapping("/error")
	public String getError() {
		return "home";
	}
}
