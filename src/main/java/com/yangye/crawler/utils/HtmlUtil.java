package com.yangye.crawler.utils;

import org.jsoup.nodes.Element;

public class HtmlUtil {
	public static String getString(Element element) {
		return element != null ? element.text() : "";
	}
	
	public static int getInteger(Element element) {
		String s = getString(element);
		return s.equals("") ? 0 : Integer.valueOf(s);
	}
	
	public static int getMovieYear(Element element) {
		String yearText = element.text();//(1900)
		if(yearText.length() >= 6) {
			String yearStr = yearText.substring(1, 5);//1900
			return Integer.valueOf(yearStr);
		}
		return 0;
		
		
	}
	public static void main(String[] args) {
		System.out.println(getInteger(null));
	}
}
