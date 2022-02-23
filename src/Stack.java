public interface Stack<T> {
    void push(T x);
    
    T pop();
    
    T peek();
    
    boolean isEmpty();
    
    boolean isFull();
    
}
