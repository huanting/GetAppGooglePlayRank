package com.hat.googleplay;

/**
 * app���������
 * @author Administrator
 *
 */
public class AppInfo {

	private String packageName;	//����
	private String Name; //����
	private int rank; //����
	
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
