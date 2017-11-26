package com.pmz.humble.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pmz.humble.dao.AbstractDAO;

/**
 * @author pasko
 *
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);	
	
	@GetMapping("/")
	public String getIndex() {
		return "home";
	}
		
}
