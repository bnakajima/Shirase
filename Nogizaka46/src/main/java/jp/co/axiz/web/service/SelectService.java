package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.entity.Title;

public interface SelectService {

	/**
	 * 指定したユーザーアカウントでのログインを許可するかどうかを判定します。<p />
	 *
	 * ログインを許可する場合は{@code true}を、
	 * 許可しない場合は{@code false}を返却します。
	 * @param admin
	 *
	 * @param userId ユーザー{@code ID}
	 * @param pwd ログインパスワード
	 * @return 判定結果
	 */

	public List<Lyricstitle> Select();

	public List<Title> titleSelect();

	public List<Lyrics> Select(Lyrics lyrics);

	public List<Lyrics> randomSelect();

	public List<Title> titleSelect(Integer id);

	public List<Rank> rankSelect();

	public List<Lyricstitle> findAll(Lyrics lyrics);
}
