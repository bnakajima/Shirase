package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Admin;

public interface LoginService {

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
	public List<Admin> Login(Admin admin);
}
