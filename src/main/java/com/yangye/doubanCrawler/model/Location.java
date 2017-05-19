package com.yangye.doubanCrawler.model;

public enum Location {
	location1(1, "美国"),location2(2, "日本"),location3(3, "香港"),location4(4, "英国"),
	location5(5, "中国"),location6(6, "韩国"),location7(7, "法国"),location8(8, "台湾"),
	location9(9, "中国大陆"),location10(10, "德国"),location11(11, "意大利"),location12(12, "印度"),
	location13(13, "内地"),location14(14, "西班牙"),location15(15, "泰国"),location16(16, "欧洲"),
	location17(17, "加拿大"),location18(18, "澳大利亚"),location19(19, "俄罗斯"),location20(20, "伊朗"),
	location21(21, "瑞典"),location22(22, "爱尔兰"),location23(23, "巴西"),location24(24, "丹麦"),
	location25(25, "波兰"),location26(26, "捷克"),location27(27, "阿根廷"),location28(28, "比利时"),
	location29(29, "墨西哥"),location30(30, "新西兰"),location31(31, "荷兰"),location32(32, "奥地利"),
	location33(33, "土耳其"),location34(34, "匈牙利"),location35(35, "瑞士"),location36(36, "以色列");
	
	
	private int value;
	private String title;
	
	private Location(int value, String title) {
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
		Location[] allLocations = Location.values();
		for (Location location : allLocations) {
			if(location.getTitle().equals(title)) {
				return location.getValue();
			}
		}
		return 0;
	}
}
