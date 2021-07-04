package mediator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Books implements Iterable<String>{
	
	

	private List<String> names;
	
	private Iterator<String> iterator;

	public static void main(String[] args) {
		List<String> names = Arrays.asList("java", "c", "c++", "pascal");
		Books books = new Books(names);
		for (String name : books) {
			System.out.println(name);
		}
		
		Iterator<String> iterator = books.iterator();
		
		while(iterator.hasNext()) {
			System.out.println("found name "+iterator.next());
		}
		System.out.println("-==================");
		
		
		iterator = books.iterator();
		while(iterator.hasNext()) {
			System.out.println("found name "+iterator.next());
		}
	}
	
	
	public Books(List<String> names) {
		this.names = names;
	}


	@Override
	public Iterator<String> iterator() {
		if(iterator == null) {
			iterator = new BooksIterator(names);
		}
		return iterator;
		//return new BooksIterator(names);
	}
}

class BooksIterator implements Iterator<String>{

	private List<String> names;
	
	private int index =0;
	
	
	public BooksIterator(List<String> names) {
		this.names = names;
	}

	@Override
	public boolean hasNext() {
		return names.size() > index;
	}

	@Override
	public String next() {
		return names.get(index++);
	}
	
	
}
