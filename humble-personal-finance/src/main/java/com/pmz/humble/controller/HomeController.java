package com.pmz.humble.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pmz.humble.handler.CalculationHandler;
import com.pmz.humble.model.User;
import com.pmz.humble.service.TransactionService;
import com.pmz.humble.service.UserService;
import com.pmz.humble.utils.DateUtils;

/**
 * @author pasko
 *
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CalculationHandler calculationHandler;
	
	
	@GetMapping(value= {"/","/home"})
	public String getIndex(Model model) {
		addNecessaryModelAttributes(getLoggedUser(), model);

		return "home";
	}

	/**
	 * @return current User
	 */
	private User getLoggedUser() {
		String username  = SecurityContextHolder.getContext().getAuthentication().getName();	//receive the username of the logged in user
		User user = userService.getUserByName(username);
		return user;
	}
	
	private void addNecessaryModelAttributes(final User user, final Model model) {
		int userId = user.getId();
		int currentMonthDigit = DateUtils.getCurrentMonthDigit();
		double monthlyIncome = calculationHandler
				.calculateMonthlyIncomeOfUser(userId, currentMonthDigit);
		double monthlyExpense = calculationHandler
				.calculateMonthlyExpenseOfUser(userId, currentMonthDigit);
		int[] monthsArray = DateUtils.getArrayWithTheLastMonthsDigits();
		
		model.addAttribute("user", user);
		model.addAttribute("currencySign", user.getCurrency().getSign());
		model.addAttribute("currentMonth", DateUtils.getMonthString(currentMonthDigit));
		model.addAttribute("currentYear", DateUtils.getCurrentYear());
		model.addAttribute("lastMonths", DateUtils.getListLastMonths(monthsArray));
		model.addAttribute("lastMonthsIncomes", calculationHandler.constructIncomeListForLastFiveMonths(userId, monthsArray));
		model.addAttribute("lastMonthsExpenses", calculationHandler.constructExpenseListForLastFiveMonths(userId, monthsArray));
		model.addAttribute("monthlyIncome", monthlyIncome);
		model.addAttribute("monthlyExpense", monthlyExpense);
		
		LOG.info("Logged in user: {}", user.toString());
	}
}
