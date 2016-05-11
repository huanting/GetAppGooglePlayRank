package com.hat.googleplay;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hat.util.IOUtils;

/**
 * 获取某分类的免费排名
 * 
 * @author Administrator
 * 
 */
public class TopFree {

	private static String TOP_FREE_URL = "https://play.google.com/store/apps/category/%s/collection/%s";

	private static final String TOPSELLING_PAID = "topselling_paid";
	private static final String TOPSELLING_FREE = "topselling_free";

	public static int getRank(String packageName, String category, boolean isFree)
	{
		String url = String.format(TOP_FREE_URL, category, 
				isFree ? TOPSELLING_FREE : TOPSELLING_PAID);
		int selectRank = 0;
		
		Document doc;
		try {
//			// Https请求
//	        if (url.startsWith("https")) {
//	            trustEveryone();
//	        }
//			
			int rank = 1;
			
			for(int i=0; i< 5; i++)
	        {
	        	int num = 60;
	        	int start = i*num;
	        	
		        HashMap<String, String> valMap = new HashMap<String, String>();
		        valMap.put("start", "0");
		        valMap.put("num", "300");
		        if(i == 0)
		        	
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
					.data("start",""+start,
							"num", ""+num)
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
		int rank = getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
		System.out.println("com.energysh.drawshow is " + rank);
	}
}
