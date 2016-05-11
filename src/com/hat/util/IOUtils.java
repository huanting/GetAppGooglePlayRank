package com.hat.util;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.json.JSONArray;
import org.json.JSONObject;


public class IOUtils {

public static boolean makeDirs(String filePath)
{

        File folder = new File(filePath);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
}


/**
     * @param urlPath 图片路径
     * @throws Exception 
     */
    public static void getImages(String urlPath, String fileName) throws Exception{
    	getImages(urlPath, fileName, false);
    }
    
    /**
     * @param urlPath 图片路径
     * @throws Exception 
     */
    public static void getImages(String urlPath, String fileName, boolean downloadSmall) throws Exception{
        URL url = new URL(urlPath);//：获取的路径
        //:http协议连接对象
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setReadTimeout(6 * 10000);
        if (conn.getResponseCode() <10000){
            InputStream inputStream = conn.getInputStream();
            byte[] data = readStream(inputStream);
            if(downloadSmall || (!downloadSmall && data.length>(1024*10)))
            {
                FileOutputStream outputStream = new FileOutputStream(fileName);
                outputStream.write(data);
                outputStream.close();
            }
        }
    }
    
    /**
     * 读取url中数据，并以字节的形式返回
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inputStream) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = inputStream.read(buffer)) !=-1){
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        inputStream.close();
        return outputStream.toByteArray();
    }
    
    
    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result = result + "\n" +s;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    private static Map  map = new HashMap()
    {
    	{
		put("AO","安哥拉");
		put("AF","阿富汗");
		put("AL","阿尔巴尼亚");
		put("DZ","阿尔及利亚");
		put("AD","安道尔共和国");
		put("AI","安圭拉岛");
		put("AG","安提瓜和巴布达");
		put("AR","阿根廷");
		put("AM","亚美尼亚");
		put("AU","澳大利亚");
		put("AT","奥地利");
		put("AZ","阿塞拜疆");
		put("BS","巴哈马");
		put("BH","巴林");
		put("BD","孟加拉国");
		put("BB","巴巴多斯");
		put("BY","白俄罗斯");
		put("BE","比利时");
		put("BZ","伯利兹");
		put("BJ","贝宁");
		put("BM","百慕大群岛");
		put("BO","玻利维亚");
		put("BW","博茨瓦纳");
		put("BR","巴西");
		put("BN","文莱");
		put("BG","保加利亚");
		put("BF","布基纳法索");
		put("MM","缅甸");
		put("BI","布隆迪");
		put("CM","喀麦隆");
		put("CA","加拿大");
		put("CF","中非共和国");
		put("TD","乍得");
		put("CL","智利");
		put("CN","中国");
		put("CO","哥伦比亚");
		put("CG","刚果");
		put("CK","库克群岛");
		put("CR","哥斯达黎加");
		put("CU","古巴");
		put("CY","塞浦路斯");
		put("CZ","捷克");
		put("DK","丹麦");
		put("DJ","吉布提");
		put("DO","多米尼加共和国");
		put("EC","厄瓜多尔");
		put("EG","埃及");
		put("SV","萨尔瓦多");
		put("EE","爱沙尼亚");
		put("ET","埃塞俄比亚");
		put("FJ","斐济");
		put("FI","芬兰");
		put("FR","法国");
		put("GF","法属圭亚那");
		put("GA","加蓬");
		put("GM","冈比亚");
		put("GE","格鲁吉亚");
		put("DE","德国");
		put("GH","加纳");
		put("GI","直布罗陀");
		put("GR","希腊");
		put("GD","格林纳达");
		put("GU","关岛");
		put("GT","危地马拉");
		put("GN","几内亚");
		put("GY","圭亚那");
		put("HT","海地");
		put("HN","洪都拉斯");
		put("HK","香港");
		put("HU","匈牙利");
		put("IS","冰岛");
		put("IN","印度");
		put("ID","印度尼西亚");
		put("IR","伊朗");
		put("IQ","伊拉克");
		put("IE","爱尔兰");
		put("IL","以色列");
		put("IT","意大利");
		put("JM","牙买加");
		put("JP","日本");
		put("JO","约旦");
		put("KH","柬埔寨");
		put("KZ","哈萨克斯坦");
		put("KE","肯尼亚");
		put("KR","韩国");
		put("KW","科威特");
		put("KG","吉尔吉斯坦");
		put("LA","老挝");
		put("LV","拉脱维亚");
		put("LB","黎巴嫩");
		put("LS","莱索托");
		put("LR","利比里亚");
		put("LY","利比亚");
		put("LI","列支敦士登");
		put("LT","立陶宛");
		put("LU","卢森堡");
		put("MO","澳门");
		put("MG","马达加斯加");
		put("MW","马拉维");
		put("MY","马来西亚");
		put("MV","马尔代夫");
		put("ML","马里");
		put("MT","马耳他");
		put("MU","毛里求斯");
		put("MX","墨西哥");
		put("MD","摩尔多瓦");
		put("MC","摩纳哥");
		put("MN","蒙古");
		put("MS","蒙特塞拉特岛");
		put("MA","摩洛哥");
		put("MZ","莫桑比克");
		put("NA","纳米比亚");
		put("NR","瑙鲁");
		put("NP","尼泊尔");
		put("NL","荷兰");
		put("NZ","新西兰");
		put("NI","尼加拉瓜");
		put("NE","尼日尔");
		put("NG","尼日利亚");
		put("KP","朝鲜");
		put("NO","挪威");
		put("OM","阿曼");
		put("PK","巴基斯坦");
		put("PA","巴拿马");
		put("PG","巴布亚新几内亚");
		put("PY","巴拉圭");
		put("PE","秘鲁");
		put("PH","菲律宾");
		put("PL","波兰");
		put("PF","法属玻利尼西亚");
		put("PT","葡萄牙");
		put("PR","波多黎各");
		put("QA","卡塔尔");
		put("RO","罗马尼亚");
		put("RU","俄罗斯");
		put("LC","圣卢西亚");
		put("VC","圣文森特岛");
		put("SM","圣马力诺");
		put("ST","圣多美和普林西比");
		put("SA","沙特阿拉伯");
		put("SN","塞内加尔");
		put("SC","塞舌尔");
		put("SL","塞拉利昂");
		put("SG","新加坡");
		put("SK","斯洛伐克");
		put("SI","斯洛文尼亚");
		put("SB","所罗门群岛");
		put("SO","索马里");
		put("ZA","南非");
		put("ES","西班牙");
		put("LK","斯里兰卡");
		put("LC","圣卢西亚");
		put("VC","圣文森特");
		put("SD","苏丹");
		put("SR","苏里南");
		put("SZ","斯威士兰");
		put("SE","瑞典");
		put("CH","瑞士");
		put("SY","叙利亚");
		put("TW","台湾省");
		put("TJ","塔吉克斯坦");
		put("TZ","坦桑尼亚");
		put("TH","泰国");
		put("TG","多哥");
		put("TO","汤加");
		put("TT","特立尼达和多巴哥");
		put("TN","突尼斯");
		put("TR","土耳其");
		put("TM","土库曼斯坦");
		put("UG","乌干达");
		put("UA","乌克兰");
		put("AE","阿拉伯联合酋长国");
		put("GB","英国");
		put("US","美国");
		put("UY","乌拉圭");
		put("UZ","乌兹别克斯坦");
		put("VE","委内瑞拉");
		put("VN","越南");
		put("YE","也门");
		put("YU","南斯拉夫");
		put("ZW","津巴布韦");
		put("ZR","扎伊尔");
		put("ZM","赞比亚");
    	}
    };
    
    public static String getCountryNameFromCode(String code)
    {
	    if(map.containsKey(code))
	    	return (String)map.get(code);
	    return code;
    
    }
    
    private static Map  languageMap = new HashMap()
    {
    	{
    	    put("ar", "ar");
    	    put("bg", "bg");
    	    put("ca", "ca");
    	    put("zh-CHS", "zh");
    	    put("zh-CHT", "zh-rTW");
    	    put("cs", "cs-rCZ");
    	    put("da", "da-rDK");
    	    put("nl", "nl-rNL");
    	    put("et", "et");
    	    put("fi", "fi-rFI");
    	    put("fr", "fr-rCA");
    	    put("fr", "fr-rFR");
    	    put("de", "de-rDE");
    	    put("el", "el-rGR");
    	    put("hi", "hi-rIN");
    	    put("hu", "hu-rHU");
    	    put("id", "id");
    	    put("it", "it-rIT");
    	    put("ja", "ja-rJP");
    	    put("ko", "ko-rKR");
    	    put("lv", "lv");
    	    put("lt", "lt");
    	    put("ms", "ms");
    	    put("no", "no-rNO");
    	    put("fa", "fa");
    	    put("pl", "pl-rPL");
    	    put("pt", "pt-rPT");
    	    put("ro", "ro");
    	    put("ru", "ru-rRU");
    	    put("sk", "sk");
    	    put("sl", "sl");
    	    put("es", "es-rES");
    	    put("es", "es-rUS");
    	    put("sv", "sv-rSE");
    	    put("th", "th");
    	    put("tr", "tr-rTR");
    	    put("uk", "uk");
    	    put("vi", "vi");
    	}
    };
    
    public static Map getLanguageMap()
    {
    	return languageMap;
    }
    
    
    /** 
     * 复制单个文件 
     *  
     * @param srcFileName 
     *            待复制的文件名 
     * @param descFileName 
     *            目标文件名 
     * @param overlay 
     *            如果目标文件存在，是否覆盖 
     * @return 如果复制成功返回true，否则返回false 
     */  
    public static boolean copyFile(String srcFileName, String destFileName,  
            boolean overlay) {  
        File srcFile = new File(srcFileName);  
  
        // 判断源文件是否存在  
        if (!srcFile.exists()) {  
            return false;  
        } else if (!srcFile.isFile()) {  
            return false;  
        }  
  
        // 判断目标文件是否存在  
        File destFile = new File(destFileName);  
        if (destFile.exists()) {  
            // 如果目标文件存在并允许覆盖  
            if (overlay) {  
                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件  
                new File(destFileName).delete();  
            }  
        } else {  
            // 如果目标文件所在目录不存在，则创建目录  
            if (!destFile.getParentFile().exists()) {  
                // 目标文件所在目录不存在  
                if (!destFile.getParentFile().mkdirs()) {  
                    // 复制文件失败：创建目标文件所在目录失败  
                    return false;  
                }  
            }  
        }  
  
        // 复制文件  
        int byteread = 0; // 读取的字节数  
        InputStream in = null;  
        OutputStream out = null;  
  
        try {  
            in = new FileInputStream(srcFile);  
            out = new FileOutputStream(destFile);  
            byte[] buffer = new byte[1024];  
  
            while ((byteread = in.read(buffer)) != -1) {  
                out.write(buffer, 0, byteread);  
            }  
            return true;  
        } catch (FileNotFoundException e) {  
            return false;  
        } catch (IOException e) {  
            return false;  
        } finally {  
            try {  
                if (out != null)  
                    out.close();  
                if (in != null)  
                    in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    
    public static void writeFile(String filePath, String fileContent)
    {
    	try {
			FileWriter fw = new FileWriter(new File(filePath));
			fw.write(fileContent);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * 从youtube中获取缩略图
     * @param dir	目录
     * @param fileName	json文件名称，包含所有数据
     */
	public static void GetImage(String dir, String fileName)
	{
		String fileContent = IOUtils.txt2String(new File(dir + "\\" + fileName));
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(fileContent);
			for(int i=0; i< jsonArray.length(); i++)
			{
				try
				{
					JSONObject jo = jsonArray.getJSONObject(i);
					String title = jo.getString("title");
					String dealTitle = title.replaceAll("\"|:|\\\\|\\n|/", "");
					if(dealTitle == null || dealTitle.isEmpty())
						dealTitle = title;
					String dstFile = dir + "\\" + dealTitle + ".jpg";
					File file = new File(dstFile);
					if(file.exists())
						continue;
					
					String imgUlr = jo.getString("imgUrl");
					IOUtils.getImages(imgUlr, dstFile, true);
					System.out.println(title);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("finish");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 压缩文件
	 * @param path 被压缩的文件路径
	 */
	static final int BUFFER = 8192; 
    public static void compressZip(String path) {   
        File file = new File(path);   
        if (!file.exists())   
            throw new RuntimeException(path + "不存在！");   
        try {   
        	int index = path.lastIndexOf("\\");
			String parentDir = path.substring(0, index+1);
			String zipName = path.substring(index+1);
			System.out.println(parentDir + ", " + zipName);
			// 要被压缩的文件夹  
	        File zipFile = new File(parentDir, zipName + ".zip");  
	        
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);   
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());   
            ZipOutputStream out = new ZipOutputStream(cos);   
            String basedir = "";   
            compress(file, out, basedir);   
            out.close();   
        } catch (Exception e) {   
            throw new RuntimeException(e);   
        }   
    }   
  
    private static void compress(File file, ZipOutputStream out, String basedir) {   
        /* 判断是目录还是文件 */  
        if (file.isDirectory()) {   
            System.out.println("压缩：" + basedir + file.getName());   
            compressDirectory(file, out, basedir);   
        } else {   
            System.out.println("压缩：" + basedir + file.getName());   
            compressFile(file, out, basedir);   
        }   
    }   
  
    /** 压缩一个目录 */  
    private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {   
        if (!dir.exists())   
            return;   
  
        File[] files = dir.listFiles();   
        for (int i = 0; i < files.length; i++) {   
            /* 递归 */  
            compress(files[i], out, basedir + dir.getName() + "/");   
        }   
    }   
  
    /** 压缩一个文件 */  
    private static void compressFile(File file, ZipOutputStream out, String basedir) {   
        if (!file.exists()) {   
            return;   
        }   
        try {   
            BufferedInputStream bis = new BufferedInputStream(   
                    new FileInputStream(file));   
            ZipEntry entry = new ZipEntry(basedir + file.getName());   
            out.putNextEntry(entry);   
            int count;   
            byte data[] = new byte[BUFFER];   
            while ((count = bis.read(data, 0, BUFFER)) != -1) {   
                out.write(data, 0, count);   
            }   
            bis.close();   
        } catch (Exception e) {   
            throw new RuntimeException(e);   
        }   
    }   
	   
}
