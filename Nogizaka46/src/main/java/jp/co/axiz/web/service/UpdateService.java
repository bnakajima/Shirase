package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.Lyrics;

public interface UpdateService {

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

	public void update(Lyrics lyrics);
}
