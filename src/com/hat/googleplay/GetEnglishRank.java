package com.hat.googleplay;

/**
 * 得到 DrawShow在英语的排名
 * @author Administrator
 */
public class GetEnglishRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetEnglishRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("\n------------- 英语 -------------");
			//获取关键字排名
			String[] keys = {
				"how to draw",
				"how to draw comic",
				"learn to draw",
				"draw comic",
				"draw cartoon",
				"draw cartoons",
				"draw animation",
				"draw manga",
				"draw tutorial",
				"drawing tutorials",
				"draw a stickman",
			};
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
