package com.hat.googleplay;

/**
 * google play 分类数据
 * @author Administrator
 *
 */
public enum ApkCategory {

	COMICS("COMICS");
	
	private String name;
	
	private ApkCategory(String str)
	{
		name = str;
	}

	public String getName() {
		return name;
	}
}
