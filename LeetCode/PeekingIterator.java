// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peek = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peek == null && hasNext()) {
            peek = next();
        }
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (peek != null) {
            Integer temp = peek;
            peek = null;
            return temp;
        }
        if (hasNext()) {
            return it.next();
        }
        return null;
	}
	
	@Override
	public boolean hasNext() {
	    return peek != null || it.hasNext();
	}
}
