package com.hat.googleplay;

/**
 * �õ� DrawShow�ڼ������ĵ�����
 * @author Administrator
 */
public class GetSimpleChineseRank implements AppRankInterface {

	public static void main(String[] args) {
		new GetSimpleChineseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
	}

	
	@Override
	public void getRank(String packageName, String categoryName, boolean isFree) {
		// TODO Auto-generated method stub
		//��ȡ��������
		try
		{
			System.out.println("------------- �������� -------------");
			//��ȡ�й����ؼ�������
			String[] keys = {"ѧ����", "������", "������", "����", "����", "����", "������", "�廭","�宋"};
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
