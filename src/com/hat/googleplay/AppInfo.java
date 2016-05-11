package com.hat.googleplay;

/**
 * app的相关数据
 * @author Administrator
 *
 */
public class AppInfo {

	private String packageName;	//包名
	private String Name; //名称
	private int rank; //排名
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString()
	{
		return rank + "\t" + Name + "\t" + packageName;
	}
	
}
