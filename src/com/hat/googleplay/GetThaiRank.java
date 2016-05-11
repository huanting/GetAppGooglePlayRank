package com.hat.googleplay;

/**
 * 得到 DrawShow在泰文的排名
 * @author Administrator
 */
public class GetThaiRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetThaiRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("\n------------- 泰文 -------------");
			
			//获取关键字排名
				String[] keys = {"ครูสอนวาดภาพ",
					"วาดการ์ตูน",
					"วาด",
					"บทเรียนแบบง่าย",
					"จิตรกรรม"
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
