package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {


	@Autowired
	private LoginService ls;

	@Autowired
	HttpSession session;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("login") Admin admin,Model model) {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Validated @ModelAttribute("login") Admin admin,BindingResult bindingResult,Model model) {

		List<Admin> list = ls.Login(admin);


		if(list.size() != 0){

			session.setAttribute("usrdata",list.get(0).getAdminName());
			//model.addAttribute("session", session);
			return "menu";
		}
		model.addAttribute("msg", "IDまたはPASSが間違っています");
		return "login";
	}

	@RequestMapping(value="/logout")
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}

}
