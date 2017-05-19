package com.yangye.doubanCrawler.model;

import java.util.List;

public class DoubanMovie {
	private int movieId;// 主键
	private String movieName;// 电影名称
	private int year;// 电影年份
	private int onTime;// 上映时间
	private List<DoubanActor> movieActors;// 演员表
	private String movieType;// 类型
	private String location;// 制片国家/地区
	private int language;// 语言
	private int movieTime;// 片长
	private int score;// 评分
	private int scoreNum;// 评价人数
	private int seenNum;// 已看人数
	private int wantNum;// 想看人数
	private List<DoubanComment> comments;// 短评
	private int shortCommentNum;// 短评数量
	private int longCommentNum;// 影评数量

	private double oneStar;// 1星比例
	private double twoStar;// 2星比例
	private double threeStar;// 3星比例
	private double fourStar;// 4星比例
	private double fiveStar;// 5星比例

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getOnTime() {
		return onTime;
	}

	public void setOnTime(int onTime) {
		this.onTime = onTime;
	}

	public List<DoubanActor> getMovieActors() {
		return movieActors;
	}

	public void setMovieActors(List<DoubanActor> movieActors) {
		this.movieActors = movieActors;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScoreNum() {
		return scoreNum;
	}

	public void setScoreNum(int scoreNum) {
		this.scoreNum = scoreNum;
	}

	public int getSeenNum() {
		return seenNum;
	}

	public void setSeenNum(int seenNum) {
		this.seenNum = seenNum;
	}

	public int getWantNum() {
		return wantNum;
	}

	public void setWantNum(int wantNum) {
		this.wantNum = wantNum;
	}

	public List<DoubanComment> getComments() {
		return comments;
	}

	public void setComments(List<DoubanComment> comments) {
		this.comments = comments;
	}

	public int getShortCommentNum() {
		return shortCommentNum;
	}

	public void setShortCommentNum(int shortCommentNum) {
		this.shortCommentNum = shortCommentNum;
	}

	public int getLongCommentNum() {
		return longCommentNum;
	}

	public void setLongCommentNum(int longCommentNum) {
		this.longCommentNum = longCommentNum;
	}

	public double getOneStar() {
		return oneStar;
	}

	public void setOneStar(double oneStar) {
		this.oneStar = oneStar;
	}

	public double getTwoStar() {
		return twoStar;
	}

	public void setTwoStar(double twoStar) {
		this.twoStar = twoStar;
	}

	public double getThreeStar() {
		return threeStar;
	}

	public void setThreeStar(double threeStar) {
		this.threeStar = threeStar;
	}

	public double getFourStar() {
		return fourStar;
	}

	public void setFourStar(double fourStar) {
		this.fourStar = fourStar;
	}

	public double getFiveStar() {
		return fiveStar;
	}

	public void setFiveStar(double fiveStar) {
		this.fiveStar = fiveStar;
	}

}
