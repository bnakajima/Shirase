package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Title;
import jp.co.axiz.web.service.InsertService;
import jp.co.axiz.web.service.SelectService;

@Controller
public class InsertController {

	@Autowired
	private InsertService is;
	@Autowired
	private SelectService ss;

	@Autowired
	HttpSession session;

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("insert") Lyrics lyrics,BindingResult bindingResult,Model model) {
		List<Title> list = ss.titleSelect();
		model.addAttribute("list", list);
		return "insert";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String login(@ModelAttribute("insert") Lyrics lyrics,BindingResult bindingResult,Model model) {
		is.insert(lyrics);
		return "adminResult";

	}
}
