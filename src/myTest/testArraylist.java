package myTest;

import java.util.ArrayList;
import java.util.Arrays;

public class testArraylist {


	public static void main(String[] args) {
		
		ArrayList<Element> ary = new ArrayList<Element>();
		for (int i = 0; i < 10; i++) {
			ary.add(new Element(i, 1));
		}
		
		int index = 0;
		int num =0;
		for(int i =0;i<ary.size();i++){

			for(int j = 0;j<ary.size();j++){
				Element e = ary.get(j);
				index = e.index;
				num = e.num;
			if(num == 1){
			
			//	ary.remove(i);
				int length = ary.size() - 1;
				e.flag = false;
				Element tmp = e;
				Element end = ary.get(length);
				ary.set(j, end);
				ary.set(length, tmp);
				ary.remove(length);
				break;
			}
			}
		}
		System.out.println(ary.size());
		for(int i = 0;i< ary.size();i++){
			System.out.println("i:"+i+" index:"+ary.get(i).index);
		}

	}

}


class Element {

	public int index;
	public int num;
	public boolean flag;

	public Element() {

	}

	public Element(int index, int num) {
		this.index = index;
		this.num = num;
		flag = true;
	}
	
	
}