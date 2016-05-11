package com.hat.googleplay;

/**
 * 得到 DrawShow在韩文的排名
 * @author Administrator
 */
public class GetTraditionalChineseRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetTraditionalChineseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("\n------------- 繁体中文 -------------");
			
			//获取关键字排名
			String[] keys = {"如何畫漫畫", "動漫", "愛動漫", "畫畫", "學畫畫", "畫卡通", "動畫片", "動畫", "如何畫動漫"};
			for(int i=0; i< keys.length; i++)
				System.out.println(KeyRank.getRank(packageName, keys[i]));
			System.out.println("------------- finish -------------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
