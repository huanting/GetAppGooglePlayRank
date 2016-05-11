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
 * 获取关键字排名
 * @author Administrator
 *
 */
public class GetKeywordRank {

	/**
	 * 
	 * @param path			关键字所在文件的路径
	 * @param packageName	包名
	 * @param categoryName	分类，比如是在 动漫，视频
	 * @param isFree		免费榜还是付费榜
	 */
	public static void getRank(String path, String packageName, String categoryName, boolean isFree)
	{
		if(path == null || path.isEmpty())
		{
			System.out.println("路径不可以为空");
			return;
		}
		
		File file = new File(path);
		if(!file.exists())
		{
			System.out.println("文件不存在");
			return;
		}
		
		ArrayList<String> keyWordList = new ArrayList<String>();
        try{
        	FileInputStream fis = new FileInputStream(file); 
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); 
            
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
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
        		else if(key.equals("关键字"))
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
