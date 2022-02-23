import java.util.*;

public class MyStack<T> implements Stack<T> {
    public final int capacity;
    private int top;
    public Object[] items;
    
    public MyStack(int capacity) {
        items = new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }
    
    public int size() {
        return top;
    }
    
    public T pop() {
        T obj = peek();
        removeElementAt(capacity - 1);
        return obj;
    }
    
    public void push(T x) {
        if (isFull())
            throw new IllegalArgumentException("货架已满");
        items[++top] = x;
    }

//    private void addElement(T x, T[] items) {
//        if (isFull())
//            throw new IllegalArgumentException("货架已满");
//        items[++top] = x;
//    }

//    public T[] grow() {
//        size = size * 2;
//        return items = Arrays.copyOf(items, size);
//    }
    
    
    private void removeElementAt(int index) {
        if (index >= capacity)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + capacity);
        else if (index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        top--;
        items[index] = null;
    }
    
    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        if (index >= capacity)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + capacity);
        return (T) items[index];
    }
    
    public T peek() {
        if (capacity == 0)
            throw new EmptyStackException();
        return elementAt(top);
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}
