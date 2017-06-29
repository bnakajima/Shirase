package jp.co.axiz.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Answer;
import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.entity.Title;
import jp.co.axiz.web.service.InsertService;
import jp.co.axiz.web.service.SelectService;

@Controller
public class QuizController {

	@Autowired
	private SelectService ss;

	@Autowired
	private InsertService is;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	ArrayList<Answer> answerList  = new ArrayList<Answer>();

	int point = 0;

	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String name(@ModelAttribute("name") Rank rank,Model model) {

		//問題を10件ランダムに取得
		List<Lyrics> list = ss.randomSelect();

		//ランダムに取ってきた問題をセッションに格納
		session.setAttribute("random",list);
		//カウントを初期化してセッションに格納
		session.setAttribute("count",1);
		return "name";
	}

	@RequestMapping(value="/quiz",method=RequestMethod.POST)
	public String quiz(@ModelAttribute("quiz")Answer answer ,@ModelAttribute("name")Rank rank,Lyrics lyrics,Model model) {
		//クイズで遷移してきたとき、空文字だった時、初めて来たときを条件分岐
		if(rank.getName() != null){
			if(rank.getName().equals("")){
				//空文字なのでメッセージを前ページで表示
				model.addAttribute("msg","君の名は希望なので入力してね");
				return "name";
			}else{
				//名前をセッションに格納
				session.setAttribute("name",rank.getName());
				//問題リストをクリア
				answerList.clear();
				//ポイントをクリア
				point = 0;
			}
		}


		//ランダムに取ってきた問題が格納されたセッションをリストに入れなおす。
		@SuppressWarnings("unchecked")
		List<Lyrics> idlist = (List<Lyrics>) session.getAttribute("random");
		//リストに入れなおした問題のうち、現在の問題をカウントを使い取得
		lyrics.setLyrics_id(idlist.get((Integer)session.getAttribute("count") - 1).getLyrics_id());

		//歌詞テーブルから該当問題を取得
		List<Lyrics> list = ss.Select(lyrics);
		//該当問題の歌詞を取得
		lyrics.setLyrics(list.get(0).getLyrics());
		//該当問題のタイトルIDを取得
		lyrics.setTitle_id(list.get(0).getTitle_id());
		//タイトルテーブルから全データを取得
		List<Title> titlelist = ss.titleSelect();

		//間違った答えの要素数を設定
		final int n = 3;
		//重複判定用
		boolean num[] = new boolean[titlelist.size()];
		//ランダムな数値
		Random rand = new Random();
		//答えを格納しておくリスト作成
		ArrayList<Integer> dummy = new ArrayList<Integer>();
		//答えのタイトルを格納しておくリストを作成
		ArrayList<String> dummyTitle = new ArrayList<String>();

		// すべての重複判定用配列をfalseにしておく
		for(int i=0; i<titlelist.size(); i++){
			num[i] = false;
		}

		//要素数回数をループ
		for(int i=0; i < n ; ){

			//タイトルテーブルに存在する要素数内で値をランダムに取得
			int p = rand.nextInt(titlelist.size());


			//正解と被らないように条件分岐
			if(list.get(0).getTitle_id() != p + 1){
				//まだ使ってない値か判定
				if(num[p] == false){
					//初めて使う値なら答えリストに格納
					dummy.add(p + 1);
					//使った値はtrueにしておく
					num[p] = true;
					//ループ用の値をインクリメント
					i++;
				}
			}
		}

		//答えリストに答えのIDを格納
		dummy.add(list.get(0).getTitle_id());
		//答えの位置を変えるために答えリストをシャッフル
		Collections.shuffle(dummy);

		//答えリストに格納されているものに該当する、答えタイトルをリストに格納する
		for(int i=0; i < dummy.size() ;i++ ){
			//dummy.get(i)で答えリストに格納されているIDを取得しテーブル参照を行い、答えタイトルリストにタイトルを格納する
			dummyTitle.add(ss.titleSelect(dummy.get(i)).get(0).getTitle());
		}



		model.addAttribute("update", lyrics);
		model.addAttribute("dummy", dummy);
		model.addAttribute("dummyTitle", dummyTitle);

		return "quiz";
	}

	@RequestMapping("/result")
	public String result(@ModelAttribute("quiz")Answer answer ,Rank rank,Lyrics lyrics,Model model) {

		answer.setAnswertitle(ss.titleSelect(answer.getAnswer()).get(0).getTitle());
		if(answer.getQuestion() == answer.getAnswer()){
			answer.setJudge("〇");
			point++;
		}else{
			answer.setJudge("×");
		}

		answerList.add(answer);

		if((Integer)session.getAttribute("count") == 10){
			session.setAttribute("answer",answerList);
			session.setAttribute("point",point);

			rank.setName((String)session.getAttribute("name"));
			rank.setPoint((Integer)session.getAttribute("point"));

			is.rankInsert(rank);
			return "result";
		}
		session.setAttribute("count",(Integer)session.getAttribute("count") + 1);
		return "forward:quiz";
	}

	@RequestMapping("/resultreboot")
	public String resultreboot(@ModelAttribute("quiz")Answer answer ,Rank rank,Lyrics lyrics,Model model) {
		return "result";
	}

	@RequestMapping("/detail")
	public String detail(@ModelAttribute("quiz")Lyrics lyrics,Answer answer,Model model) {
		String id  = request.getParameter("id");

		lyrics.setLyrics_id(Integer.parseInt(id));

		List<Lyricstitle> list = ss.findAll(lyrics);

		model.addAttribute("Lyrics", list.get(0).getLyrics());
		model.addAttribute("title", list.get(0).getTitle());


		return "detail";
	}
}