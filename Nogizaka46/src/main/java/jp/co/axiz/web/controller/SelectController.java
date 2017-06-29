package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.service.SelectService;

@Controller
public class SelectController {

	@Autowired
	private SelectService ss;

	@RequestMapping("/select")
	public String login(@ModelAttribute("list") Lyricstitle lt,BindingResult bindingResult,Model model) {
		List<Lyricstitle> list = ss.Select();

		model.addAttribute("list", list);

		return "select";
	}
}
