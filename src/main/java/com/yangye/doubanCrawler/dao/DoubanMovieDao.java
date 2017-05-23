package com.yangye.doubanCrawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yangye.doubanCrawler.model.DoubanMovie;
import com.yangye.doubanCrawler.utils.JDBCUtils;

public class DoubanMovieDao {
	private Connection conn = null;
	
	public DoubanMovieDao() {
		this.conn = JDBCUtils.getConnection();
	}
	
	public void saveMovie(DoubanMovie movie) throws SQLException {
		String sql = "insert into douban_movie (movie_id,movie_name,year,on_time,movie_type,location,movie_time,score,score_num,seen_num,want_num,short_comment_num"
				+ ",long_comment_num,one_star,two_star,three_star,four_star,five_star,update_time) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,UNIX_TIMESTAMP(NOW()))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, movie.getMovieId());
		pstmt.setString(2, movie.getMovieName());
		pstmt.setInt(3, movie.getYear());
		pstmt.setInt(4, movie.getOnTime());
		pstmt.setString(5, movie.getMovieType());
		pstmt.setString(6, movie.getLocation());
		pstmt.setInt(7, movie.getMovieTime());
		pstmt.setDouble(8, movie.getScore());
		pstmt.setInt(9, movie.getScoreNum());
		pstmt.setInt(10, movie.getSeenNum());
		pstmt.setInt(11, movie.getWantNum());
		pstmt.setInt(12, movie.getShortCommentNum());
		pstmt.setInt(13, movie.getLongCommentNum());
		pstmt.setDouble(14, movie.getOneStar());
		pstmt.setDouble(15, movie.getTwoStar());
		pstmt.setDouble(16, movie.getThreeStar());
		pstmt.setDouble(17, movie.getFourStar());
		pstmt.setDouble(18, movie.getFiveStar());
		pstmt.executeUpdate();
	}
	
	public static void saveActor(DoubanMovie movie) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into douban_movie (movie_id,movie_name,year,on_time,movie_type,location,movie_time,score,score_num,seen_num,want_num,short_comment_num"
				+ ",long_comment_num,one_star,two_star,three_star,four_star,five_star,update_time) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,UNIX_TIMESTAMP(NOW()))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, movie.getMovieId());
		pstmt.setString(2, movie.getMovieName());
		pstmt.setInt(3, movie.getYear());
		pstmt.setInt(4, movie.getOnTime());
		pstmt.setString(5, movie.getMovieType());
		pstmt.setString(6, movie.getLocation());
		pstmt.setInt(7, movie.getMovieTime());
		pstmt.setDouble(8, movie.getScore());
		pstmt.setInt(9, movie.getScoreNum());
		pstmt.setInt(10, movie.getSeenNum());
		pstmt.setInt(11, movie.getWantNum());
		pstmt.setInt(12, movie.getShortCommentNum());
		pstmt.setInt(13, movie.getLongCommentNum());
		pstmt.setDouble(14, movie.getOneStar());
		pstmt.setDouble(15, movie.getTwoStar());
		pstmt.setDouble(16, movie.getThreeStar());
		pstmt.setDouble(17, movie.getFourStar());
		pstmt.setDouble(18, movie.getFiveStar());
		pstmt.executeUpdate();
	}
}
