package com.yangye.crawler;

import org.jsoup.nodes.Element;

import com.yangye.crawler.utils.HtmlUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class DoubanCrawler extends BreadthCrawler{
	public static volatile int count = 0;
	public DoubanCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	public void visit(Page page, CrawlDatums next) {
		String movieName = HtmlUtil.getString(page.select("#content h1 span").first());
		int year = HtmlUtil.getMovieYear(page.select("#content h1 span").last());
		System.out.println(movieName + "===" + year);
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		DoubanCrawler crawler = new DoubanCrawler("crawler", true);
		
		crawler.setThreads(2);
		crawler.addSeed("https://movie.douban.com/subject/1292052/?from=subject-page");
		crawler.addRegex("https://movie.douban.com/subject/[0-9]+/\\?from=subject-page");
		try {
			crawler.start(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
