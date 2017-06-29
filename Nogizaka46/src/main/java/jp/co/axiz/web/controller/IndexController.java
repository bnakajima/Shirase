package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@Autowired
	HttpSession session;

	@RequestMapping("/index")
	public String index(Model model) {
		session.invalidate();
		return "index";
	}

	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu(Model model) {
		if((String) session.getAttribute("usrdata") == null){
			return "index";
		}

		return "menu";
	}
}
