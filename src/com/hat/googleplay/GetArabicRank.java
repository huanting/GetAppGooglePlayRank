package com.hat.googleplay;

/**
 * 得到 DrawShow在阿拉伯语的排名
 * @author Administrator
 */
public class GetArabicRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetArabicRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("------------- 阿拉伯语 -------------");
			//获取关键字排名
			String[] keys = {
					"معلم الرسم",
					"رسم الكرتون",
					"كيف ترسم",
					"كيفية رسم فكاهي",
					"رسم أنيمي"
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
