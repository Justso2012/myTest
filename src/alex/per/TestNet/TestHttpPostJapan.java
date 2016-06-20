package alex.per.TestNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TestHttpPostJapan {

	public static void DoHttpPost(String url, String param, Object obj) {
		System.out.println("url:"+url);
		System.out.println("param:"+param);
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			conn.setRequestMethod("POST");
			// 设置通用的请求属性
			conn.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, lzma");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			conn.setRequestProperty("Cache-Control", "max-age=0");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Content-Length", "433");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Cookie",
					"CGISESSID=65f1d60e5c0c4e0eb6eac7976f38fa3a");
			conn.setRequestProperty("Host", "www.kotonoha.gr.jp");
			conn.setRequestProperty("Origin", "http://www.kotonoha.gr.jp");
			conn.setRequestProperty("Referer",
					"http://www.kotonoha.gr.jp/shonagon/search_form");
			conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
			conn.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36 OPR/38.0.2220.31");
			System.out.println("Connecting.....");
			conn.setConnectTimeout(10000);  

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			int num = 0;
			while ((line = in.readLine()) != null && num <50) {  //限制最多输出500行结果
//				result += "/n" + line;
				num++;
//				System.out.println(num+"\t"+line);	
				if(num == 44){
					int start = line.indexOf('>');
					int end = line.indexOf('件');
					obj.getnum = line.substring(start+1, end-1);
					System.out.println(searchnum);
				}
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	// 提供主方法，测试发送GET请求和POST请求
	public static void main(String args[]) throws IOException {
		String url = null;
		StringBuilder param = new StringBuilder();
		String wordUrlCode;
		String getnum = null;
		
		
		url = new String("http://www.kotonoha.gr.jp/shonagon/search_result");
		
		param.append("query_string=");
		if(args.length>0)
			wordUrlCode = URLEncoder.encode(args[0],"UTF-8");
		else
			wordUrlCode = new String("%E7%99%BE%E5%BA%A6");  //默认用“百度”一词的url编码
		
		param.append(wordUrlCode);
		/*if(args.length>0)
			param.append(URLEncoder.encode(args[0],"UTF-8"));
		else
			param.append("%E7%99%BE%E5%BA%A6");  //默认用“百度”一词的url编码
*/		
		param.append("&lcontext_regex=&rcontext_regex=&media=%E6%9B%B8%E7%B1%8D&media=%E9%9B%91%E8%AA%8C&media=%E6%96%B0%E8%81%9E&media=%E7%99%BD%E6%9B%B8&media=%E6%95%99%E7%A7%91%E6%9B%B8&media=%E5%BA%83%E5%A0%B1%E7%B4%99&media=Yahoo%21%E7%9F%A5%E6%81%B5%E8%A2%8B&media=Yahoo%21%E3%83%96%E3%83%AD%E3%82%B0&media=%E9%9F%BB%E6%96%87&media=%E6%B3%95%E5%BE%8B&media=%E5%9B%BD%E4%BC%9A%E4%BC%9A%E8%AD%B0%E9%8C%B2&entire_period=1");
		

		TestHttpPostJapan.DoHttpPost(url, param.toString(), this);
		System.out.println("now getnum :"+getnum);
		

	}

}
