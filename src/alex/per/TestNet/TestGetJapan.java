package alex.per.TestNet;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestGetJapan {
	
	public static void DoGet(String urlstring) throws IOException
	{
		
			URL url = new URL(urlstring);
			URLConnection connection = url.openConnection();
			connection.connect();
			

			Scanner in = new Scanner(connection.getInputStream());
			while(in.hasNextLine()){
				System.out.println(in.nextLine());
			}
			
			System.out.println("Response:");
			Map<String, List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry: headers.entrySet()){
				String key = entry.getKey();
				
				for(String value:entry.getValue()){
					System.out.println(key+":"+value);
				}
			}
			
			in.close();

	}
	
	
	public static void main(String args[]) throws IOException{
		String str2;
		/*StringBuilder str = new StringBuilder();
		str.append("http://cn.bing.com/search?");
		str.append("q=chax&go=%E6%8F%90%E4%BA%A4&qs=n&form=QBRE&pq=chax&sc=8-4&sp=-1&sk=&cvid=E924664480654A229DB89D87BF3B2BED");
		DoGet((String)str);*/
		
		String str1 = new String("http://www.kotonoha.gr.jp/shonagon/search_form?query_string=");
		
		if(args.length > 0)
			str2 = URLEncoder.encode(args[0],"UTF-8");
		else
			str2 = new String("%E7%99%BE%E5%BA%A6");
		
		String str3 = new String("&lcontext_regex=&rcontext_regex=&media=%E6%9B%B8%E7%B1%8D&media=%E9%9B%91%E8%AA%8C&media=%E6%96%B0%E8%81%9E&media=%E7%99%BD%E6%9B%B8&media=%E6%95%99%E7%A7%91%E6%9B%B8&media=%E5%BA%83%E5%A0%B1%E7%B4%99&media=Yahoo%21%E7%9F%A5%E6%81%B5%E8%A2%8B&media=Yahoo%21%E3%83%96%E3%83%AD%E3%82%B0&media=%E9%9F%BB%E6%96%87&media=%E6%B3%95%E5%BE%8B&media=%E5%9B%BD%E4%BC%9A%E4%BC%9A%E8%AD%B0%E9%8C%B2&entire_period=1");
		
		System.out.println("str:"+str1+str2+str3);
		
		try {
			DoGet(str1+str2+str3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
