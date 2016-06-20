package alex.per.TestNet;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestGetBing {
	
	public static void DoGet(String urlstring) throws IOException
	{
		
			URL url = new URL(urlstring);
			URLConnection connection = url.openConnection();
			connection.connect();
			
			Map<String, List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry: headers.entrySet()){
				String key = entry.getKey();
				System.out.println("Response:");
				for(String value:entry.getValue()){
					System.out.println(key+":"+value);
				}
			}
			
			Scanner in = new Scanner(connection.getInputStream());
//			while(in.hasNextLine()){
//				System.out.println(in.nextLine());
//			}
			in.close();

	}
	
	
	public static void main(String args[]){
		/*StringBuilder str = new StringBuilder();
		str.append("http://cn.bing.com/search?");
		str.append("q=chax&go=%E6%8F%90%E4%BA%A4&qs=n&form=QBRE&pq=chax&sc=8-4&sp=-1&sk=&cvid=E924664480654A229DB89D87BF3B2BED");
		DoGet((String)str);*/
		
		String str = new String("http://cn.bing.com/search?q=%E5%A4%A9%E6%B0%94&go=%E6%8F%90%E4%BA%A4&qs=n&form=QBRE&pq=%E5%A4%A9%E6%B0%94&sc=0-0&sp=-1&sk=&cvid=94BF03C783C342A188939CF05FD964D4");
		try {
			DoGet(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
