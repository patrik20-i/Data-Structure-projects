public interface StackInterface {
  public void push(Object o);
  public Object pop() throws EmptyStackException;
  public Object top() throws EmptyStackException;
  public boolean isEmpty();
  public int size();
}