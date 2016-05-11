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
     * @param urlPath ͼƬ·��
     * @throws Exception 
     */
    public static void getImages(String urlPath, String fileName) throws Exception{
    	getImages(urlPath, fileName, false);
    }
    
    /**
     * @param urlPath ͼƬ·��
     * @throws Exception 
     */
    public static void getImages(String urlPath, String fileName, boolean downloadSmall) throws Exception{
        URL url = new URL(urlPath);//����ȡ��·��
        //:httpЭ�����Ӷ���
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
     * ��ȡurl�����ݣ������ֽڵ���ʽ����
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
     * ��ȡtxt�ļ�������
     * @param file ��Ҫ��ȡ���ļ�����
     * @return �����ļ�����
     */
    public static String txt2String(File file){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
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
		put("AO","������");
		put("AF","������");
		put("AL","����������");
		put("DZ","����������");
		put("AD","���������͹�");
		put("AI","��������");
		put("AG","����ϺͰͲ���");
		put("AR","����͢");
		put("AM","��������");
		put("AU","�Ĵ�����");
		put("AT","�µ���");
		put("AZ","�����ݽ�");
		put("BS","�͹���");
		put("BH","����");
		put("BD","�ϼ�����");
		put("BB","�ͰͶ�˹");
		put("BY","�׶���˹");
		put("BE","����ʱ");
		put("BZ","������");
		put("BJ","����");
		put("BM","��Ľ��Ⱥ��");
		put("BO","����ά��");
		put("BW","��������");
		put("BR","����");
		put("BN","����");
		put("BG","��������");
		put("BF","�����ɷ���");
		put("MM","���");
		put("BI","��¡��");
		put("CM","����¡");
		put("CA","���ô�");
		put("CF","�зǹ��͹�");
		put("TD","է��");
		put("CL","����");
		put("CN","�й�");
		put("CO","���ױ���");
		put("CG","�չ�");
		put("CK","���Ⱥ��");
		put("CR","��˹�����");
		put("CU","�Ű�");
		put("CY","����·˹");
		put("CZ","�ݿ�");
		put("DK","����");
		put("DJ","������");
		put("DO","������ӹ��͹�");
		put("EC","��϶��");
		put("EG","����");
		put("SV","�����߶�");
		put("EE","��ɳ����");
		put("ET","���������");
		put("FJ","쳼�");
		put("FI","����");
		put("FR","����");
		put("GF","����������");
		put("GA","����");
		put("GM","�Ա���");
		put("GE","��³����");
		put("DE","�¹�");
		put("GH","����");
		put("GI","ֱ������");
		put("GR","ϣ��");
		put("GD","�����ɴ�");
		put("GU","�ص�");
		put("GT","Σ������");
		put("GN","������");
		put("GY","������");
		put("HT","����");
		put("HN","�鶼��˹");
		put("HK","���");
		put("HU","������");
		put("IS","����");
		put("IN","ӡ��");
		put("ID","ӡ��������");
		put("IR","����");
		put("IQ","������");
		put("IE","������");
		put("IL","��ɫ��");
		put("IT","�����");
		put("JM","�����");
		put("JP","�ձ�");
		put("JO","Լ��");
		put("KH","����կ");
		put("KZ","������˹̹");
		put("KE","������");
		put("KR","����");
		put("KW","������");
		put("KG","������˹̹");
		put("LA","����");
		put("LV","����ά��");
		put("LB","�����");
		put("LS","������");
		put("LR","��������");
		put("LY","������");
		put("LI","��֧��ʿ��");
		put("LT","������");
		put("LU","¬ɭ��");
		put("MO","����");
		put("MG","����˹��");
		put("MW","����ά");
		put("MY","��������");
		put("MV","�������");
		put("ML","����");
		put("MT","�����");
		put("MU","ë����˹");
		put("MX","ī����");
		put("MD","Ħ������");
		put("MC","Ħ�ɸ�");
		put("MN","�ɹ�");
		put("MS","���������ص�");
		put("MA","Ħ���");
		put("MZ","Īɣ�ȿ�");
		put("NA","���ױ���");
		put("NR","�³");
		put("NP","�Ჴ��");
		put("NL","����");
		put("NZ","������");
		put("NI","�������");
		put("NE","���ն�");
		put("NG","��������");
		put("KP","����");
		put("NO","Ų��");
		put("OM","����");
		put("PK","�ͻ�˹̹");
		put("PA","������");
		put("PG","�Ͳ����¼�����");
		put("PY","������");
		put("PE","��³");
		put("PH","���ɱ�");
		put("PL","����");
		put("PF","��������������");
		put("PT","������");
		put("PR","�������");
		put("QA","������");
		put("RO","��������");
		put("RU","����˹");
		put("LC","ʥ¬����");
		put("VC","ʥ��ɭ�ص�");
		put("SM","ʥ����ŵ");
		put("ST","ʥ��������������");
		put("SA","ɳ�ذ�����");
		put("SN","���ڼӶ�");
		put("SC","�����");
		put("SL","��������");
		put("SG","�¼���");
		put("SK","˹�工��");
		put("SI","˹��������");
		put("SB","������Ⱥ��");
		put("SO","������");
		put("ZA","�Ϸ�");
		put("ES","������");
		put("LK","˹������");
		put("LC","ʥ¬����");
		put("VC","ʥ��ɭ��");
		put("SD","�յ�");
		put("SR","������");
		put("SZ","˹��ʿ��");
		put("SE","���");
		put("CH","��ʿ");
		put("SY","������");
		put("TW","̨��ʡ");
		put("TJ","������˹̹");
		put("TZ","̹ɣ����");
		put("TH","̩��");
		put("TG","���");
		put("TO","����");
		put("TT","�������Ͷ�͸�");
		put("TN","ͻ��˹");
		put("TR","������");
		put("TM","������˹̹");
		put("UG","�ڸɴ�");
		put("UA","�ڿ���");
		put("AE","����������������");
		put("GB","Ӣ��");
		put("US","����");
		put("UY","������");
		put("UZ","���ȱ��˹̹");
		put("VE","ί������");
		put("VN","Խ��");
		put("YE","Ҳ��");
		put("YU","��˹����");
		put("ZW","��Ͳ�Τ");
		put("ZR","������");
		put("ZM","�ޱ���");
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
     * ���Ƶ����ļ� 
     *  
     * @param srcFileName 
     *            �����Ƶ��ļ��� 
     * @param descFileName 
     *            Ŀ���ļ��� 
     * @param overlay 
     *            ���Ŀ���ļ����ڣ��Ƿ񸲸� 
     * @return ������Ƴɹ�����true�����򷵻�false 
     */  
    public static boolean copyFile(String srcFileName, String destFileName,  
            boolean overlay) {  
        File srcFile = new File(srcFileName);  
  
        // �ж�Դ�ļ��Ƿ����  
        if (!srcFile.exists()) {  
            return false;  
        } else if (!srcFile.isFile()) {  
            return false;  
        }  
  
        // �ж�Ŀ���ļ��Ƿ����  
        File destFile = new File(destFileName);  
        if (destFile.exists()) {  
            // ���Ŀ���ļ����ڲ�������  
            if (overlay) {  
                // ɾ���Ѿ����ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�  
                new File(destFileName).delete();  
            }  
        } else {  
            // ���Ŀ���ļ�����Ŀ¼�����ڣ��򴴽�Ŀ¼  
            if (!destFile.getParentFile().exists()) {  
                // Ŀ���ļ�����Ŀ¼������  
                if (!destFile.getParentFile().mkdirs()) {  
                    // �����ļ�ʧ�ܣ�����Ŀ���ļ�����Ŀ¼ʧ��  
                    return false;  
                }  
            }  
        }  
  
        // �����ļ�  
        int byteread = 0; // ��ȡ���ֽ���  
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
     * ��youtube�л�ȡ����ͼ
     * @param dir	Ŀ¼
     * @param fileName	json�ļ����ƣ�������������
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
	 * ѹ���ļ�
	 * @param path ��ѹ�����ļ�·��
	 */
	static final int BUFFER = 8192; 
    public static void compressZip(String path) {   
        File file = new File(path);   
        if (!file.exists())   
            throw new RuntimeException(path + "�����ڣ�");   
        try {   
        	int index = path.lastIndexOf("\\");
			String parentDir = path.substring(0, index+1);
			String zipName = path.substring(index+1);
			System.out.println(parentDir + ", " + zipName);
			// Ҫ��ѹ�����ļ���  
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
        /* �ж���Ŀ¼�����ļ� */  
        if (file.isDirectory()) {   
            System.out.println("ѹ����" + basedir + file.getName());   
            compressDirectory(file, out, basedir);   
        } else {   
            System.out.println("ѹ����" + basedir + file.getName());   
            compressFile(file, out, basedir);   
        }   
    }   
  
    /** ѹ��һ��Ŀ¼ */  
    private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {   
        if (!dir.exists())   
            return;   
  
        File[] files = dir.listFiles();   
        for (int i = 0; i < files.length; i++) {   
            /* �ݹ� */  
            compress(files[i], out, basedir + dir.getName() + "/");   
        }   
    }   
  
    /** ѹ��һ���ļ� */  
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
