package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.entity.Lyrics;
import jp.co.axiz.web.entity.Lyricstitle;
import jp.co.axiz.web.entity.Rank;
import jp.co.axiz.web.entity.Title;

@Repository
public class PgUserDao implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Admin> findById(Admin admin) {
		List<Admin> list = jdbcTemplate.query("select admin_id,admin_name,password from admin where admin_id = ? AND password = ?",
				new Object[]{admin.getAdminId(),admin.getAdminPass()},new BeanPropertyRowMapper<Admin>(Admin.class));

		return list;
	}

	@Override
	public List<Lyricstitle> findAll() {
		List<Lyricstitle> list = new ArrayList<Lyricstitle>();
		list = jdbcTemplate.query("select lyrics_id,lyrics,title from lyrics l JOIN title t ON l.title_id = t.title_id",
				new BeanPropertyRowMapper<Lyricstitle>(Lyricstitle.class));
		return list;
	}

	@Override
	public List<Title> findAllTitle() {
		List<Title> list = new ArrayList<Title>();
		list = jdbcTemplate.query("select * from title",
				new BeanPropertyRowMapper<Title>(Title.class));
		return list;
	}

	@Override
	public void insert(Lyrics lyrics) {
		jdbcTemplate.update("insert into lyrics(lyrics,title_id) values(?,?)",
				new Object[]{lyrics.getLyrics(),lyrics.getTitle_id()});
		return;
	}

	@Override
	public List<Lyrics> findById(Lyrics lyrics) {
		List<Lyrics> list = new ArrayList<Lyrics>();
		list = jdbcTemplate.query("select * from lyrics where lyrics_id = ?",
				new Object[]{lyrics.getLyrics_id()},new BeanPropertyRowMapper<Lyrics>(Lyrics.class));
		return list;
	}

	@Override
	public void update(Lyrics lyrics) {
		jdbcTemplate.update("update lyrics set lyrics = ?,title_id = ? where lyrics_id = ?",
				new Object[]{lyrics.getLyrics(),lyrics.getTitle_id(),lyrics.getLyrics_id()});
		return;
	}

	@Override
	public void delete(Lyrics lyrics) {
		jdbcTemplate.update("delete from lyrics where lyrics_id = ?",
				new Object[]{lyrics.getLyrics_id()});
		return;
	}

	@Override
	public List<Lyrics> randomSelect() {
		List<Lyrics> list = new ArrayList<Lyrics>();
		list = jdbcTemplate.query("select * from lyrics ORDER BY RANDOM() LIMIT 10;",
				new BeanPropertyRowMapper<Lyrics>(Lyrics.class));
		return list;
	}

	@Override
	public List<Title> findById(Integer id) {
		List<Title> list = new ArrayList<Title>();
		list = jdbcTemplate.query("select title from title where title_id = ?",
				new Object[]{id},new BeanPropertyRowMapper<Title>(Title.class));
		return list;
	}

	@Override
	public void insert(Rank rank) {
		jdbcTemplate.update("insert into ranking(name,point) values(?,?)",
				new Object[]{rank.getName(),rank.getPoint()});
		return;
	}


	@Override
	public List<Rank> rankSelect() {
		List<Rank> list = new ArrayList<Rank>();
		list = jdbcTemplate.query("select * from ranking ORDER BY point DESC LIMIT 10",
				new BeanPropertyRowMapper<Rank>(Rank.class));
		return list;
	}

	public List<Lyricstitle> findAll(Lyrics lyrics) {
		List<Lyricstitle> list = new ArrayList<Lyricstitle>();
		list = jdbcTemplate.query("select lyrics_id,lyrics,title from lyrics l JOIN title t ON l.title_id = t.title_id where lyrics_id = ?",
				new Object[]{lyrics.getLyrics_id()},new BeanPropertyRowMapper<Lyricstitle>(Lyricstitle.class));
		return list;
	}
}
