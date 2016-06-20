package alex.per.testAdapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumAdapter<E> implements Iterator<E>{
	
	private Enumeration<E> e;
	
	public EnumAdapter(Enumeration<E> e) {
		this.e = e;
	}

	@Override
	public boolean hasNext() {
		
		return e.hasMoreElements();
	}

	@Override
	public E next() {
		
		return e.nextElement();
	}

	public void remove(){
		throw new UnsupportedOperationException();
	}
}
