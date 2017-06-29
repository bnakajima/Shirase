package jp.co.axiz.web.entity;

public class Lyrics {

	private Integer lyrics_id = null;
	private String lyrics;
	private Integer title_id = null;


	public Lyrics() {
	}


	public Integer getLyrics_id() {
		return lyrics_id;
	}


	public void setLyrics_id(Integer lyrics_id) {
		this.lyrics_id = lyrics_id;
	}


	public String getLyrics() {
		return lyrics;
	}


	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}


	public Integer getTitle_id() {
		return title_id;
	}


	public void setTitle_id(Integer title_id) {
		this.title_id = title_id;
	}


}
