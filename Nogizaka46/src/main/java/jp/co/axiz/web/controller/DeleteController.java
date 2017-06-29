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
import jp.co.axiz.web.service.DeleteService;
import jp.co.axiz.web.service.SelectService;

@Controller
public class DeleteController {

	@Autowired
	private DeleteService ds;

	@Autowired
	private SelectService ss;

	@Autowired
	HttpSession session;

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String Update(@ModelAttribute("delete") Lyrics lyrics,Model model) {
		return "delete";
	}

	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String insertConfirm(@Validated @ModelAttribute("delete") Lyrics lyrics,BindingResult bindingResult,Model model) {

		if(lyrics.getLyrics_id() == null){
			model.addAttribute("msg", "IDは必須です");
			return "delete";
		}

		List<Lyrics> list = ss.Select(lyrics);

		if(list.size() != 0){
			ds.delete(lyrics);
			return "adminResult";
		}
		model.addAttribute("msg", "入力されたデータはありませんでした");
		return "delete";
	}
}
