package jp.co.axiz.web.entity;

public class Lyricstitle {

	private Integer lyrics_id = null;
	private String lyrics;
	private String title;


	public Lyricstitle() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
