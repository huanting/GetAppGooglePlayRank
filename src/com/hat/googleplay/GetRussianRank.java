package com.hat.googleplay;

/**
 * �õ� DrawShow�ڶ��ĵ�����
 * @author Administrator
 */
public class GetRussianRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetRussianRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//��ȡ��������
		try
		{
			System.out.println("------------- ���� -------------");
			//��ȡ�ؼ�������
			String[] keys = {
				"���֧�֧�ڧ��� ��� ��ڧ��ӧѧߧڧ�",
				"�ܧѧ� �ߧѧ�ڧ��ӧѧ��",
				"���ڧ��ӧѧ�� �ѧߧڧާ�",
				"���ѧ��ڧ���� ��ڧ��ӧѧ��"
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
