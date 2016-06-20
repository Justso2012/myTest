package myTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KeyTest {
	private long startTime, endTime;
	private String keyList[] = {"A", "B", "C", "D","LF2"};
	public KeyTest(){
		
	}
	
	public String getRandomKey(){
		String keyStr = null;
		Random random = new Random();
		int num = -1;
		
		num = random.nextInt(5);
		keyStr = new String(keyList[num]);

		return keyStr;
		/**/
	}
	
	public String getInputKey() throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		str = bfr.readLine();
		System.out.println("You enter :"+ str);
		return str;
	}
	
	public void DoTest() throws IOException{
		String randomStr = null;
		String inputStr = null;
		
		randomStr = getRandomKey();
		System.out.println(randomStr);
		startTime = System.currentTimeMillis();			
		
		System.out.println("Please input the str:");
		inputStr = getInputKey();
		
		endTime = System.currentTimeMillis();	
		
		if(randomStr.equals(inputStr)){
			System.out.print("Right");
		}
		else{
			System.out.print("Wrong");
		}
		System.out.println("   time:" + (endTime - startTime));
	}
	
	public void ShowAction(){
		
	}
}
