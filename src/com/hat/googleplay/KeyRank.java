package com.hat.googleplay;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hat.util.IOUtils;

/**
 * 根据关键字获取排名
 * @author Administrator
 *
 */
public class KeyRank {
	private static String SEARCH_URL = "https://play.google.com/store/search?q=%s&c=apps";

	public static int getRank(String packageName, String key) throws Exception
	{
		String url = String.format(SEARCH_URL,  URLEncoder.encode(key, "utf-8"));
		int selectRank = 0;
	
		String findStr ="*!@#$%^&*()";
		
		int index =  url.indexOf("/store");
		if(index != -1)
		{
			findStr = url.substring(index);
			findStr = findStr.replaceAll("=", "\\\\u003d");
			findStr = findStr.replaceAll("&", "\\\\u0026");
			findStr = findStr.replace("\\", "\\\\");
		}
		
		
		Document doc;
		try {
			int rank = 1;
			String pagTok="";
			for(int i=0; i< 5; i++)
	        {
	        
		        if(pagTok.isEmpty())
					doc = Jsoup.connect(url)
							.ignoreContentType(true)
							.header("Accept-Encoding", "gzip, deflate")
							.header("Accept-Language", "zh-CN,zh;q=0.8,de-DE;q=0.6,de;q=0.4,en;q=0.2,en-US;q=0.2")
							.header("scheme", "https")
							.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.17 (KHTML, like Gecko)Chrome/24.0.1312.56 Safari/537.17")
							.timeout(3000).post();
		        else
		        	doc = Jsoup.connect(url)
					.ignoreContentType(true)
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language", "zh-CN,zh;q=0.8,de-DE;q=0.6,de;q=0.4,en;q=0.2,en-US;q=0.2")
					.header("scheme", "https")
					.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.17 (KHTML, like Gecko)Chrome/24.0.1312.56 Safari/537.17")
					.data("pagTok", pagTok)
					.timeout(3000).post();
				
				//找到分类
				Elements eles = doc.select("div.card-content");
				
				
				ArrayList<AppInfo> dataList = new ArrayList<AppInfo>();
				
				for(Element ele : eles)
				{
					Element detailsEle = ele.select("div.details").first();
					if(detailsEle != null)
					{
						AppInfo info = new AppInfo();
						//设置包名
						info.setPackageName(ele.attr("data-docid"));
						
						if(packageName.equals(info.getPackageName()))
								return rank;
						
						//设置排名
						info.setRank(rank);
						
						Element titleEle = detailsEle.select("a.title").first();
						if(titleEle != null)
						{
							info.setName(titleEle.attr("title"));
						}
						dataList.add(info);
						rank++;
						//System.out.println(info.toString());
					}
				}
				String val = doc.html();
				int keyIndex = val.indexOf(findStr);
				if(keyIndex != -1)
				{
					int beginIndex = val.indexOf(",", keyIndex);
					int endIndex = val.indexOf(",", beginIndex+1);
					if(beginIndex != -1 && endIndex != -1 && beginIndex < endIndex)
					{
						String str = val.substring(beginIndex+1, endIndex);
						pagTok = str.replace("\\x22", ""); 
//						System.out.println(pagTok);
					}
				}
//		        IOUtils.writeFile("d:\\key" + i + ".txt", doc.html());
	        }
//			System.out.println("-------- finish -----------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return selectRank;
	}
	
	public static void main(String[] args) {
		try {
			int rank = getRank("com.mueezaapps.easydrawingpopularanime", "学画画");
			System.out.println("学画画 rank=" + rank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
