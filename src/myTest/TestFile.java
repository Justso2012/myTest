package myTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestFile {

	public static void GetFileData(String filename) {
		Scanner out = null;
		if (new File(filename).exists())
			System.out.println("It exists.");
		else {
			System.out.println("It doesn't exists.");
			return;
		}

		try {
			out = new Scanner(new FileReader(filename));
			while (out.hasNextLine()) {
				System.out.println(out.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}

	}

	public static void SetFileData(String filename, String data) throws IOException {
		File dealFile = new File(filename);
		if (dealFile.exists())
			System.out.println("It exists.");
		else {
			System.out.println("It doesn't exists.");
			try {
				dealFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileOutputStream in = null;
		try {
			in = new FileOutputStream(dealFile);
			StringBuilder str = new StringBuilder();
			str.append(data);
			str.append('\t');
			str.append(Math.random());
			in.write(str.toString().getBytes());
			
/*			String str = data+'\t'+Math.random();
			in.write(str.getBytes());*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null)

					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void DealFile(String fromFileName, String toFileName) throws IOException{
		File fromFile = new File(fromFileName);
		if(fromFile.exists()){
			System.out.println("File is ok");
		}else{
			System.out.println("OutFile doesn't exist.");
			return ;
		}
//		FileInputStream fin = new FileInputStream(fromFile);
		FileReader reader = new FileReader(fromFile);
		BufferedReader bufReader = new BufferedReader(reader);
		
		
		File toFile = new File(toFileName);
		if(toFile.exists()){
			System.out.println("InFile is ok.");
		}else{
			toFile.createNewFile();
		}
//		FileOutputStream fout = new FileOutputStream(toFile);
		FileWriter writer = new FileWriter(toFile);
		
		String str;
		int num = 0;
		while( (str = bufReader.readLine())!= null){
			num++;
			writer.write(num+"\t"+str+"\r\n");
			System.out.println(str);
		}
		reader.close();
		bufReader.close();
		
		writer.flush();
		writer.close();
//		fout.close();
		
		
		
	}

	public static void main(String args[]) throws IOException {
//		final String fromFileName = "C:\\Users\\john\\Desktop\\data\\test\\cms002.c";
		final String fromFileName = "C:\\Users\\john\\Desktop\\data\\test\\words.txt";
		final String toFileName = "C:\\Users\\john\\Desktop\\data\\test\\deal.txt";
//		TestFile.GetFileData("C:\\Users\\john\\Desktop\\data\\test\\words.txt");
//		TestFile.SetFileData("C:\\Users\\john\\Desktop\\data\\test\\deal.txt", "world");

		TestFile.DealFile(fromFileName, toFileName);
	}

}
