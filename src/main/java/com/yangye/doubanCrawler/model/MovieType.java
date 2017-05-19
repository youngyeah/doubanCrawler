package com.yangye.doubanCrawler.model;

public enum MovieType {
	type1(1, "爱情"),type2(2, "喜剧"),type3(3, "剧情"),type4(4, "动画"),
	type5(5, "科幻"),type6(6, "动作"),type7(7, "经典"),type8(8, "悬疑"),
	type9(9, "青春"),type10(10, "犯罪"),type11(11, "惊悚"),type12(12, "文艺"),
	type13(13, "搞笑"),type14(14, "纪录片"),type15(15, "励志"),type16(16, "恐怖"),
	type17(17, "战争"),type18(18, "短片"),type19(19, "黑色幽默"),type20(20, "魔幻"),
	type21(21, "传记"),type22(22, "情色"),type23(23, "感人"),type24(24, "暴力"),
	type25(25, "家庭"),type26(26, "音乐"),type27(27, "动画短片"),type28(28, "童年"),
	type29(29, "浪漫"),type30(30, "女性"),type31(31, "黑帮"),type32(32, "同志"),
	type33(33, "烂片"),type34(34, "史诗"),type35(35, "通话"),type36(36, "西部");
	
	
	private int value;
	private String title;
	
	private MovieType(int value, String title) {
		this.value = value;
		this.title = title;
	}

	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public static int getValueByTitle(String title) {
		MovieType[] allTypes = MovieType.values();
		for (MovieType movieType : allTypes) {
			if(movieType.getTitle().equals(title)) {
				return movieType.getValue();
			}
		}
		return 0;
	}
}
