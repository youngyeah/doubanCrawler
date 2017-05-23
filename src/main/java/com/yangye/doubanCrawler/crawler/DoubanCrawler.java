package com.yangye.doubanCrawler.crawler;

import java.util.List;

import com.yangye.doubanCrawler.model.DoubanActor;
import com.yangye.doubanCrawler.model.DoubanComment;
import com.yangye.doubanCrawler.model.DoubanMovie;
import com.yangye.doubanCrawler.utils.HtmlUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class DoubanCrawler extends BreadthCrawler{
	public static volatile int count = 0;
	public DoubanCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	public void visit(Page page, CrawlDatums next) {
		if(page.matchUrl("https://movie.douban.com/subject/[0-9]+/")) {
			int movieId = HtmlUtil.getMovieId(page);
			String movieName = HtmlUtil.getMovieName(page);
			int year = HtmlUtil.getMovieYear(page);
			List<DoubanActor> actors = HtmlUtil.getActors(page, movieId);
			String movieType = HtmlUtil.getMovieType(page);
			String location = HtmlUtil.getLocation(page);
			int onTime = HtmlUtil.getOnTime(page);
			int movieTime = HtmlUtil.getMovieTime(page);
			double score = HtmlUtil.getScore(page);
			int scoreNum = HtmlUtil.getScoreNum(page);
			int seenNum = HtmlUtil.getSeenNum(page);
			int wantNum = HtmlUtil.getWantNum(page);
			int shortCommentNum = HtmlUtil.getShortCommentNum(page);
			List<DoubanComment> comments = HtmlUtil.getComments(page, movieId);
			int longCommentNum = HtmlUtil.getLongCommentNum(page);
			double fiveStar = HtmlUtil.getStar(page, 0);
			double fourStar = HtmlUtil.getStar(page, 1);
			double threeStar = HtmlUtil.getStar(page, 2);
			double twoStar = HtmlUtil.getStar(page, 3);
			double oneStar = HtmlUtil.getStar(page, 4);
			DoubanMovie movie = new DoubanMovie();
			movie.setMovieId(movieId);
			movie.setMovieName(movieName);
			movie.setYear(year);
			movie.setOnTime(onTime);
			movie.setMovieActors(actors);
			movie.setMovieType(movieType);
			movie.setLocation(location);
			movie.setMovieTime(movieTime);
			movie.setScore(score);
			movie.setScoreNum(scoreNum);
			movie.setSeenNum(seenNum);
			movie.setWantNum(wantNum);
			movie.setComments(comments);
			movie.setShortCommentNum(shortCommentNum);
			movie.setLongCommentNum(longCommentNum);
			movie.setOneStar(oneStar);
			movie.setTwoStar(twoStar);
			movie.setThreeStar(threeStar);
			movie.setFourStar(fourStar);
			movie.setFiveStar(fiveStar);
			System.out.println("电影id：" + movieId);
			System.out.println("电影名称：" + movieName);
			System.out.println("年份：" + year);
			System.out.println("演员表：" + actors);
			System.out.println("类型：" + movieType);
			System.out.println("国家/地区：" + location);
			System.out.println("上映时间：" + onTime);
			System.out.println("时长：" + movieTime);
			System.out.println("评分：" + score);
			System.out.println("评价人数：" + scoreNum);
			System.out.println("已看人数：" + seenNum);
			System.out.println("想看人数：" + wantNum);
			System.out.println("短评人数：" + shortCommentNum);
			System.out.println("评论详情：" + comments);
			System.out.println("影评数量：" + longCommentNum);
			System.out.println("5星：" + fiveStar);
			System.out.println("4星：" + fourStar);
			System.out.println("3星：" + threeStar);
			System.out.println("2星：" + twoStar);
			System.out.println("1星：" + oneStar);
		}
	}
	
	public static void main(String[] args) {
		DoubanCrawler crawler = new DoubanCrawler("crawler", true);
		
		crawler.setThreads(1);
		crawler.setExecuteInterval(3000);
		crawler.addSeed("https://movie.douban.com/subject/10491666/");
//		crawler.addSeed("https://movie.douban.com/tag/");
//		crawler.addRegex("https://movie.douban.com/tag/[0-9]+");
//		crawler.addRegex("https://movie.douban.com/tag/[0-9]+\\?start=[0-9]+&type=T");
//		crawler.addRegex("https://movie.douban.com/subject/[0-9]+/");
		try {
			crawler.start(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
