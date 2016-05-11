package com.hat.googleplay;

/**
 * 得到 DrawShow在日语的排名
 * @author Administrator
 */
public class GetJapaneseRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetJapaneseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("\n------------- 日语 -------------");
			//获取关键字排名
			String[] keys = {
					"漫画の描き方",
					"アニメを描きます",
					"アニメの描き方",
					"漫す画を描きま",
					"アニメ",
					"漫画",
					"描画",
					"アニメーション",
					"マンガの描き方",
					"スケッチ",
					"コミック",
					"絵を描く",
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
