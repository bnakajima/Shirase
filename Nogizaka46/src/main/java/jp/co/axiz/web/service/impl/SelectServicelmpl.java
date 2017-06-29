package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.dao.impl.PgUserDao;
import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.entity.Title;
import jp.co.axiz.web.service.SelectService;

@Service
public class SelectServicelmpl implements SelectService {

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
	public List<Lyricstitle> Select() {
		List<Lyricstitle> list = usrMstDao.findAll();
			return list;
	}

	@Override
	public List<Title> titleSelect() {
		List<Title> list = usrMstDao.findAllTitle();
		return list;
	}

	@Override
	public List<Lyrics> Select(Lyrics lyrics) {
		List<Lyrics> list = usrMstDao.findById(lyrics);
		return list;
	}

	@Override
	public List<Lyrics> randomSelect() {
		List<Lyrics> list = usrMstDao.randomSelect();
		return list;
	}

	@Override
	public List<Title> titleSelect(Integer id) {
		List<Title> list = usrMstDao.findById(id);
		return list;
	}

	@Override
	public List<Rank> rankSelect() {
		List<Rank> list = usrMstDao.rankSelect();
		return list;
	}

	@Override
	public List<Lyricstitle> findAll(Lyrics lyrics) {
		List<Lyricstitle> list = usrMstDao.findAll(lyrics);
		return list;
	}
}
