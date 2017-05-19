package com.yangye.doubanCrawler.model;

public class DoubanActor {
	private int actorId;// 主键
	private String actorName;// 演员姓名
	private int movieId;// 参加电影id

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "DoubanActor [actorId=" + actorId + ", actorName=" + actorName + ", movieId=" + movieId + "]";
	}

}
