package com.yangye.doubanCrawler.model;

public class DoubanComment {
	private int commentId;// 主键
	private int movieId;// 所属电影id
	private int vote;// 评论点赞数
	private String content;// 评论内容

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DoubanComment [commentId=" + commentId + ", movieId=" + movieId + ", vote=" + vote + ", content="
				+ content + "]";
	}

}
