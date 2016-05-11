package com.hat.googleplay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ��ȡ�ؼ�������
 * @author Administrator
 *
 */
public class GetKeywordRank {

	/**
	 * 
	 * @param path			�ؼ��������ļ���·��
	 * @param packageName	����
	 * @param categoryName	���࣬�������� ��������Ƶ
	 * @param isFree		��Ѱ��Ǹ��Ѱ�
	 */
	public static void getRank(String path, String packageName, String categoryName, boolean isFree)
	{
		if(path == null || path.isEmpty())
		{
			System.out.println("·��������Ϊ��");
			return;
		}
		
		File file = new File(path);
		if(!file.exists())
		{
			System.out.println("�ļ�������");
			return;
		}
		
		ArrayList<String> keyWordList = new ArrayList<String>();
        try{
        	FileInputStream fis = new FileInputStream(file); 
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); 
            
            BufferedReader br = new BufferedReader(isr);//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
            	keyWordList.add(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = sdf.format(new Date());
        
        for(int i=0; i< keyWordList.size(); i++)
        {
        	String key = keyWordList.get(i);
        	try {
        		if(key.isEmpty())
        			System.out.println("");
        		else if(key.equals("�ؼ���"))
        			System.out.println(dateStr);
    			else
    				System.out.println(KeyRank.getRank(packageName, key));
        		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
