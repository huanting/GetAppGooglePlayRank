package com.hat.googleplay;

/**
 * 得到 DrawShow在韩文的排名
 * @author Administrator
 */
public class GetKoreanRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetKoreanRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//获取分类排名
		try
		{
			System.out.println("\n------------- 韩文 -------------");
			
			//获取关键字排名
			String[] keys = {"그리기 교사",
					"만화 그리기",
					"어떻게 그리는 방법",
					"그릴 학습",
					"그림",
					"그릴 알아보기",
					"를 그리는 방법을 알아 봅니다",
					"무승부",
					"만화",
					"애니메이션",
					"만화를 그립니다",
					"애니메이션을 그릴",
					"카툰",
					"그림",
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
