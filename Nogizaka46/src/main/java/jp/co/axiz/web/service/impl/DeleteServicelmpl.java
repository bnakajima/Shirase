package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.dao.impl.PgUserDao;
import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.service.DeleteService;

@Service
public class DeleteServicelmpl implements DeleteService {

	/** {@link PgUserDao}オブジェクトを保持します。 */

	@Autowired
	private UserDao usrMstDao;

	/**
	 * 指定したユーザーアカウントでのログインを許可するかどうかを判定します。
	 * <p>ログインを許可する場合は{@code true}を、許可しない場合は{@code false}を返 却します。</p>
	 *
	 * @param userId ユーザー{@code ID}
	 * @param pwd ログインパスワード
	 * @return 判定結果
	 */

	@Transactional
	@Override
	public void delete(Lyrics lyrics) {
		usrMstDao.delete(lyrics);
			return;
	}
}
