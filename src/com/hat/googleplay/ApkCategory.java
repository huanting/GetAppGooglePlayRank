package com.hat.googleplay;

/**
 * google play ��������
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
