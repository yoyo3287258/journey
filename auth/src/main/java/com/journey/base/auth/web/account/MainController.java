package com.journey.base.auth.web.account;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页管理的Controller
 * 
 * @author 刘霖坤
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMainPage(HttpSession session) {
		return "index";
	}
	
}
