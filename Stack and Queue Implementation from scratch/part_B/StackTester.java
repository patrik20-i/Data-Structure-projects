public class StackTester {
  public static void main(String[] args){
    int  N = 10;
    StackInterface myStack = new Stack();

    // Testing push operation
    for(int i = 0; i < N; i++) {
      myStack.push(i);
    }
   
    int size1 = myStack.size();
    System.out.println("Size: " + size1);
    
    if(size1 != N){
      System.err.println("Incorrect size of the stack.");
    }
    
    //Test top() operation
    try{
      int top = (int)myStack.top();
      int size2 = myStack.size(); //Should be same as size1
      if(size1 != size2) {
        System.err.println("Error. Size modified after top()");
      }
    }
    catch (EmptyStackException e){
      System.out.println("Empty stack");
    }
    
    // Test pop() operation
    int halfN = (Integer)(N/2);
    //Remove top halfN elements
    for(int i = 0; i < halfN; i++) {
      try{
        int val = (Integer)myStack.pop();
      }
      catch (EmptyStackException e) {
        System.out.println("Cant remove from empty stack");
      }
    }
    
    int size3 = myStack.size();
    System.out.println("Size: " + myStack.size());
    
    if(size3 != (N - halfN)){
      System.err.println("Incorrect size of the stack.");
    }
    
    //empty the queue  - test pop() operation as well
    while(!myStack.isEmpty()){
        try{
          int val = (int)myStack.pop();
        }
        catch (EmptyStackException e) {
          System.out.println("Cant remove from empty stack");
        }
    }
    
    int size5 = myStack.size();
    if(size5 != 0){
      System.err.println("Incorrect size of the stack.");
    } 
  }
}