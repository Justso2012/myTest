package alex.per.testAdapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteAdapter<E> implements Enumeration<E>{
	private Iterator<E> it;
	
	public IteAdapter(Iterator<E> it) {
		this.it = it;
	}
	@Override
	public boolean hasMoreElements() {
		return it.hasNext();
	}

	@Override
	public E nextElement() {
		return it.next();
	}

}
