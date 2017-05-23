package com.yangye.doubanCrawler.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yangye.doubanCrawler.model.DoubanActor;
import com.yangye.doubanCrawler.model.DoubanComment;
import com.yangye.doubanCrawler.model.Location;
import com.yangye.doubanCrawler.model.MovieType;

import cn.edu.hfut.dmic.webcollector.model.Page;

public class HtmlUtil {

	/**
	 * 获取电影年份
	 * 
	 * @author Young.Y.Yang
	 * @param element
	 * @return
	 */
	public static int getMovieYear(Page page) {
		Element element = page.select("#content h1 span").last();
		String yearText = element.text();// (1900)
		if (yearText.length() >= 6) {
			String yearStr = yearText.substring(1, 5);// 1900
			return Integer.valueOf(yearStr);
		}
		return 0;
	}

	/**
	 * 获取电影id
	 * 
	 * @author Young.Y.Yang
	 * @param url
	 * @return
	 */
	public static int getMovieId(Page page) {// https://movie.douban.com/subject/1292052/?from=subject-page
//		String regex = "https://movie.douban.com/subject/([0-9]+)/\\?from=subject-page";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(page.getUrl());
//		String movieIdStr = "";
//		if (m.matches()) {
//			movieIdStr = m.group(1);
//		}
		return getInt(page.getUrl());
	}

	/**
	 * 获取电影名称
	 * 
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static String getMovieName(Page page) {
		Element element = page.select("#content h1 span").first();
		return getString(element);
	}

	/**
	 * 获取演员列表
	 * 
	 * @author Young.Y.Yang
	 * @param elements
	 * @param movieId
	 * @return
	 */
	public static List<DoubanActor> getActors(Page page, int movieId) {
		Elements elements = page.select("#info .actor .attrs a");
		List<DoubanActor> actors = new ArrayList<DoubanActor>();
		for (Element element : elements) {
			DoubanActor doubanActor = new DoubanActor();
			int actorId = getInt(element.attr("href").replaceAll("/", "").substring(10));
			String actorName = element.text();
			int movieId_actor = movieId;
			doubanActor.setActorId(actorId);
			doubanActor.setActorName(actorName);
			doubanActor.setMovieId(movieId_actor);
			actors.add(doubanActor);
		}
		return actors;
	}
	
	/**
	 * 获取电影类型
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static String getMovieType(Page page) {
		Elements elements = page.select("#info", 0).getElementsByAttributeValueMatching("property", "v:genre");

		StringBuilder sb = new StringBuilder();
		for (Element element : elements) {
			String title = element.text();
			sb.append(MovieType.getValueByTitle(title));
			sb.append(",");
		}
		String movieType = sb.toString();
		
		return movieType.length() > 0 ? movieType.substring(0, movieType.length()-1) : movieType;
	}
	
	/**
	 * 获取电影制片国家/地区
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static String getLocation(Page page) {
		Element element = page.select("#info .pl", 4);
		String locationStr = element.nextSibling().toString();
		String[] locaArr = locationStr.split(" / ");
		StringBuilder sb = new StringBuilder();
		for (String location : locaArr) {
			int value = Location.getValueByTitle(location);
			sb.append(value).append(",");
		}
		String location = sb.toString();
		return location.length() > 0 ? location.substring(0, location.length()-1) : location;
	}
	
	/**
	 * 获取上映时间
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getOnTime(Page page) {
		Element element = page.select("#info .pl", 6);
		String onTimeStr = element.nextElementSibling().text();
		String onTime = onTimeStr.substring(0, 10);
		return DateUtil.getUnixTime(onTime);
		
	}
	
	/**
	 * 获取电影时长
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getMovieTime(Page page) {
		Element element = page.select("#info .pl", 7).nextElementSibling();
		String movieTimeStr = element.text();
		return getInt(movieTimeStr);
	}
	
	/**
	 * 获取电影评分
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static double getScore(Page page) {
		return getDouble(page.select(".rating_num").text());
	}
	
	/**
	 * 获取评价人数
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getScoreNum(Page page) {
		Element element = page.select(".rating_sum", 0).getElementsByAttributeValueMatching("property", "v:votes").first();
		String scoreNumStr =  element.text();
		return getInt(scoreNumStr);
	}
	
	/**
	 * 获取已看人数
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getSeenNum(Page page) {
		Elements elements = page.select(".subject-others-interests-ft a");
		for (Element element : elements) {
			String text = element.text();
			if(text.indexOf("人看过") > 0) {
				return getInt(text);
			}
		}
		return 0;
	}
	
	/**
	 * 获取想看人数
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getWantNum(Page page) {
		Elements elements = page.select(".subject-others-interests-ft a");
		for (Element element : elements) {
			String text = element.text();
			if(text.indexOf("人想看") > 0) {
				return getInt(text);
			}
		}
		return 0;
	}
	
	/**
	 * 获取短评数
	 * @author Young.Y.Yang
	 * @param page
	 * @return
	 */
	public static int getShortCommentNum(Page page) {
		Element element = page.select("#comments-section h2 .pl a", 0);
		return getInt(element.text());
	}
	
	/**
	 * 获取电影短评
	 * @param page
	 * @param movieId
	 * @return
	 */
	public static List<DoubanComment> getComments(Page page, int movieId) {
		List<DoubanComment> comments = new ArrayList<DoubanComment>();
		Elements elements = page.select("#hot-comments .comment-item");
		for (Element element : elements) {
			if(comments.size() > 2){
				break;
			}
			DoubanComment comment = new DoubanComment();
			int commentId = getInt(element.attr("data-cid"));
			int vote = getInt(element.select(".comment h3 .comment-vote .votes").text());
			String content = element.select(".comment p").text();
			comment.setCommentId(commentId);
			comment.setMovieId(movieId);
			comment.setVote(vote);
			comment.setContent(content);
			comments.add(comment);
		}
		return comments;
	}
	
	/**
	 * 获取影评数量
	 * @param page
	 * @return
	 */
	public static int getLongCommentNum(Page page) {
		Element element = page.select(".movie-content header h2 span a", 0);
		int longCommentNum = getInt(element.text());
		return longCommentNum;
	}
	
	/**
	 * 获取等级评分
	 * @param page
	 * @param star
	 * @return
	 */
	public static double getStar(Page page,int star) {
		Elements elements = page.select(".ratings-on-weight .item .rating_per");
		double result = Double.valueOf(elements.get(star).text().replace("%", ""));
		return result;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.toString());
	}

	public static String getString(Element element) {
		return element != null ? element.text() : "";
	}

	public static int getInteger(Element element) {
		String s = getString(element);
		return s.equals("") ? 0 : Integer.valueOf(s);
	}

//	private static int getInt(String s) {
//		int result = 0;
//		try {
//			result = Integer.valueOf(s);
//		} catch (NumberFormatException e) {
//		}
//		return result;
//	}
	
	private static double getDouble(String s) {
		double result = 0;
		try {
			result = Double.valueOf(s);
		} catch (Exception e) {
		}
		return result;
	}
	
	private static int getInt(String s) {
		String regex = "[^0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return Integer.valueOf(m.replaceAll("").trim());
	}
//	private static double getDouble(String s) {
//		String regex = "([0-9]+\\.[0-9]+)";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(s);
//		return Double.valueOf(m.group(1));
//	}
}
