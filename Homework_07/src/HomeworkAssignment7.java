import java.util.*;

//Author: Anthony Foley
//Class: CS 20B
//Assignment: Homework 7 Problem 1
//Date: 26 October 2020

public class HomeworkAssignment7 {

	public static void main(String[] args) {
		/*
		List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
		MyIterator iter = new MyIterator(ints.iterator());		
		while (iter.hasNext()) {
			System.out.println("HAS NEXT: " + iter.hasNext());
			System.out.println("AHEAD: " + iter.lookAhead());
			System.out.println("NEXT: " + iter.next());
			System.out.println("AHEAD: " + iter.lookAhead());
		}
		System.out.println("NEXT:"  + iter.next());
		System.out.println("HAS NEXT: " + iter.hasNext());
		*/
	}

}

/*
 * MyIterator class implements a "look-ahead" iterator to allow
 * looking at the next iterator value without advancing the
 * iterator.
 * lookAhead() - returns next iterator element without advancing
 *               iterator.
 * next()      - returns next iterator element and advances
 *               iterator.
 * hasNext()   - returns boolean result of check if elements exist
 *               in the iterator
 */
class MyIterator implements Iterator<Integer> {

	// ==============================================
	// ANY GLOBAL VARIABLE DECLARATIONS HERE
	// ==============================================
	private Iterator<Integer> iter;
	private Integer cur;

	public MyIterator(Iterator<Integer> iterator) {
		this.iter = iterator;
		if (iter.hasNext()) {
			cur = iter.next();
		}
	}

	// Returns the next element in the iteration WITHOUT 
	// advancing the iterator.
	public Integer lookAhead() {
		if (hasNext()) return cur;
		return null;
	}

	@Override
	public Integer next() {
		Integer val = cur;
		cur = (iter.hasNext()) ? iter.next() : null;
		return val;
	}

	@Override
	public boolean hasNext() {
		return cur != null;
	}
}