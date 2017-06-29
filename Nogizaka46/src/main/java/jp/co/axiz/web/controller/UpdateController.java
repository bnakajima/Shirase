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

import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Title;
import jp.co.axiz.web.service.SelectService;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	private UpdateService us;

	@Autowired
	private SelectService ss;

	@Autowired
	HttpSession session;


	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String Update(@ModelAttribute("update") Lyrics lyrics,Model model) {
		return "update";
	}

	@RequestMapping("/updateConfirm")
	public String UpdateInput(@Validated @ModelAttribute("update") Lyrics lyrics,BindingResult bindingResult,Model model) {

		if(lyrics.getLyrics_id() == null){
			model.addAttribute("msg", "必須項目を入力してください");
			return "update";
		}
		session.setAttribute("id",lyrics.getLyrics_id());

		List<Lyrics> list = ss.Select(lyrics);

		List<Title> titlelist = ss.titleSelect();

		if(list.size() != 0){
			lyrics.setLyrics(list.get(0).getLyrics());
			lyrics.setTitle_id(list.get(0).getTitle_id());
			model.addAttribute("update", lyrics);
			model.addAttribute("list", titlelist);
			return "updateConfirm";
		}
		model.addAttribute("msg", "入力されたデータはありませんでした");
		return "update";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String UpdateConfirm(@ModelAttribute("update") Lyrics lyrics,Model model) {
		lyrics.setLyrics_id((Integer) session.getAttribute("id"));
		us.update(lyrics);
		return "adminResult";
	}
}
