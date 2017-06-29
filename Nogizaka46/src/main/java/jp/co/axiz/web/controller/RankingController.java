package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.service.SelectService;

@Controller
public class RankingController {

	@Autowired
	private SelectService ss;

	@Autowired
	HttpSession session;

	@RequestMapping("/rank")
	public String rank(@ModelAttribute("quiz")Rank rank,Model model) {

		List<Rank> rankselect = ss.rankSelect();
		model.addAttribute("rank", rankselect);

		return "rank";
	}
}
