package com.hat.googleplay;

/**
 * 得到 DrawShow在简体中文的排名
 * @author Administrator
 */
public class GetSimpleChineseRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetSimpleChineseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("------------- 简体中文 -------------");
			//获取中国区关键字排名
			String[] keys = {"学画画", "爱动漫", "画漫画", "画画", "动漫", "漫画", "画动漫", "插画","插畫"};
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
