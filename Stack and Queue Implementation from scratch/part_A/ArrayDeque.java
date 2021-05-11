public class ArrayDeque implements DequeInterface {
  int f=-1;
  int r=0;
  int MaxSize=1;
  Object[] deck =  new Object[MaxSize];
  boolean empty=true;

  public void insertFirst(Object o){
    empty=false;
    if(f==-1 && r==0){
      deck[0]= o;
      f=f+1;
      return;
    }  
    if(size()==MaxSize){
      doubleSize();
    }
    f=(f-1+MaxSize)%MaxSize;
    deck[f]=o;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public void insertLast(Object o){
    empty=false;
    if(f==-1 && r==0){
      deck[0]= o;
      f=f+1;
      return;
    }
    if(size()==MaxSize){
      doubleSize();
    }
    deck[r]=o;
    r=(r+1)%MaxSize;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object removeFirst() throws EmptyDequeException{
    Object temp;
    if(empty==true){
      throw new EmptyDequeException("Deque is empty");
    }
    else{
      temp = deck[f];
      f=(f+1+MaxSize)%MaxSize;
    }
    if(r==f){
      empty=true;
    }
    return temp;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object removeLast() throws EmptyDequeException{
    
    if(empty==true){
      throw new EmptyDequeException("Deque is empty");
    }
    Object temp;

    temp= deck[(r-1+MaxSize)%MaxSize];
    r=(r-1+MaxSize)%MaxSize;
    
    
    if(r==f){
      empty=true;
    }
    return temp;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }

  public Object first() throws EmptyDequeException{
    if(empty==true){
      throw new EmptyDequeException("Deque is empty");
    }
    else{
      return deck[f];
    }
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object last() throws EmptyDequeException{
    if(empty==true){
      throw new EmptyDequeException("Deque is empty");
    }
    else{
      return deck[(r-1+MaxSize)%MaxSize];
    }
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public int size(){
    if(empty==true){
      return 0;
    }
    int l =(r-f);
    if(l<=0){
      l+=MaxSize;
    }

    return l;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public boolean isEmpty(){
    return empty;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }

  public String toString(){
    String a = "[";
    if(size()==0){
      a =a+"]";
    }
    else{
      if(f<r){
      for(int k=f;k<r;k++){
          a=a+String.valueOf(deck[k])+", ";
      }
      }
      else{
        for(int k=f;k<MaxSize;k++){
          a=a+String.valueOf(deck[k])+", ";
        }
        for(int k=0;k<r;k++){
          a=a+String.valueOf(deck[k])+", ";
        }  
      }
      a =a.substring(0,a.length()-2) +"]";
    }
    return a;
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }  

  public void doubleSize(){
        
    Object[] temp = new Object[2*MaxSize];
    for(int i = 0; i<MaxSize;i++){
        temp[i]= deck[(i+f)%MaxSize];
    }
    f=0;
    r=MaxSize;
    MaxSize =2*MaxSize;
    deck = temp;
  }
}
