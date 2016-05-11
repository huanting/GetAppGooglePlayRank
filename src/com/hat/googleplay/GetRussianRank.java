package com.hat.googleplay;

/**
 * 得到 DrawShow在俄文的排名
 * @author Administrator
 */
public class GetRussianRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetRussianRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("------------- 俄文 -------------");
			//获取关键字排名
			String[] keys = {
				"Репетитор по рисованию",
				"как нарисовать",
				"Рисовать аниме",
				"Научиться рисовать"
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
