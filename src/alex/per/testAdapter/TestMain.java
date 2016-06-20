package alex.per.testAdapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestMain {
	private static final int NUM = 5;
	
	public static void main(String[] args){
		ArrayList<String> alist = new ArrayList<String>();
//		Vector<String> vt = new Vector<String>();
		
		
		for(int i = 0;i<NUM;i++){
			alist.add("No"+i);
//			vt.add("Hey"+i);
		}
		
		
		
		Iterator<String> it = alist.iterator();
		Enumeration<String> et = new IteAdapter<String>(it);
		
//		Iterator<String> it2 = vt.iterator();
//		Enumeration<String> et2 = vt.elements();
//		EnumAdapter<String> eA = new EnumAdapter(et2);
//		
//		for(int i=0;i<NUM;i++){
//			if(eA.hasNext()){
//				System.out.println(eA.next());
//			}
//		}
		
//		Enumeration<String> et = (Enumeration<String>) alist.iterator();
//		Enumeration<String> et = alist.get(0);
//		Iterator<String> it2 = new EnumAdapter<String>(et);
//		it2 = alist.iterator();
//		
//		for(int i = 0;i<NUM;i++){
//			if(it.hasNext()){
//				System.out.println(it.next());
//				
//			}				
//		}
		
		for(int i = 0;i<NUM;i++){
			if(et.hasMoreElements())
				System.out.println("hello "+et.nextElement());
		}
		
/*		for(int i = 0;i<NUM;i++){
			if(it2.hasNext())
				System.out.println(it2.next());
		}*/
	}
}
