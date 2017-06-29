package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Rank;

public interface InsertService {

	/**
	 * 指定したユーザーアカウントでのログインを許可するかどうかを判定します。<p />
	 *
	 * ログインを許可する場合は{@code true}を、
	 * 許可しない場合は{@code false}を返却します。
	 * @param lyrics
	 * @param admin
	 *
	 * @param userId ユーザー{@code ID}
	 * @param pwd ログインパスワード
	 * @return 判定結果
	 */

	public void insert(Lyrics lyrics);

	public void rankInsert(Rank rank);
}
