package alex.per.TestNet;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
	public static void main(String args[]) {
		try {
			String urlName;

			if (args.length > 0)
				urlName = args[0];
			else
				urlName = "https://www.baidu.com";

			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			
			if(args.length > 2){
				String username = args[1];
				String password = args[2];
				String input = username +":"+ password;
			//	String encoding = base64Encode(input);
			//	connection.setRequestProperty("Authorization","Basic" + encoding);
				
			}
			connection.connect();
			
			Map<String, List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry: headers.entrySet()){
				String key = entry.getKey();
				for(String value:entry.getValue()){
					System.out.println(key+":"+value);
				}
			}
			
			System.out.println("--------------------------------");
			System.out.println("getContentType:"+connection.getContentType());
			System.out.println("getContentLength:"+connection.getContentLength());
			System.out.println("getContentEncoding:"+connection.getContentEncoding());
			System.out.println("getDate:"+connection.getDate());
			System.out.println("getExpiration:"+connection.getExpiration());
			System.out.println("getLastModified:"+connection.getLastModified());
			System.out.println("------------------");
			
			Scanner in = new Scanner(connection.getInputStream());
			
			for(int n = 1; in.hasNextLine() && n<=10; n++){
				System.out.println(in.nextLine());
				
				if(in.hasNextLine()) 
//					System.out.println(".......");
					System.out.println(in.nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public static String base64Encode(String s)
	{
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		
		try{
			out.write(s.getBytes());
			out.flush();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return bOut.toString();
	}*/
}

/*class Base64OutputStream extends FilterOutputStream
{
	public Base64OutputStream(OutputStream out){
		super(out);
	}
	
	public void write(int c) throws IOException
	{
		inbuf[i] = c;
		i++;
		if( i == 3)
		{
			super.wirte(toBase64[(inbuf[0])])
		}
	}
}
*/