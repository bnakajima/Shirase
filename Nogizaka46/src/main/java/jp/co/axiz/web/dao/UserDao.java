package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.entity.Title;

public interface UserDao {

	public List<Admin> findById(Admin admin);
	public List<Lyricstitle> findAll();
	public List<Title> findAllTitle();
	public void insert(Lyrics lyrics);
	public List<Lyrics> findById(Lyrics lyrics);
	public void update(Lyrics lyrics);
	public void delete(Lyrics lyrics);
	public List<Lyrics> randomSelect();
	public List<Title> findById(Integer id);
	public List<Rank> rankSelect();
	public void insert(Rank rank);
	public List<Lyricstitle> findAll(Lyrics lyrics);

}