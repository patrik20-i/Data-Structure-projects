// You should utilise your implementation of ArrayDeque methods to implement this
public class Stack implements StackInterface {
	DequeInterface arr= new ArrayDeque();

	public void push(Object o){
		arr.insertLast(o);
		//you need to implement this
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  	}

	public Object pop() throws EmptyStackException{
		Object temp;
		try {
			temp=arr.removeLast();
		} catch (Exception e) {
			throw new EmptyStackException("stack is empty");
		}
		return temp;
		//you need to implement this
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public Object top() throws EmptyStackException{
		Object temp;
		try {
			temp=arr.last();
		} catch (Exception e) {
			throw new EmptyStackException("stack is empty");
		}
		return temp;
		//return arr.last();
		//you need to implement this
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public boolean isEmpty(){
		return arr.isEmpty();
    	//you need to implement this
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

    public int size(){
		return arr.size();
    	//you need to implement this
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

	public void print(){
		System.out.println(arr);
		System.out.println(arr.size());

	}

}