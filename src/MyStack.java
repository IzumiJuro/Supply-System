
import java.util.*;

public class MyStack<T>  {
    private final int size;
    private int top;
    public final T[] items;
    
    public MyStack(int size) {
        items = (T[]) new Object[size];
        top = -1;
        this.size = size;
    }
    
    public int size() {
        return size;
    }
    
    public T pop() {
        T obj = peek();
        removeElementAt(size - 1);
        return obj;
    }
    
    public void push(T x) {
        if (x == null)
            throw new IllegalArgumentException("can not add null");
        addElement(x, items);
    }
    
    private void addElement(T x, T[] items) {
        if (isFull())
            throw new IllegalArgumentException("货架已满");
        items[++top] = x;
    }
    
//    public T[] grow() {
//        size = size * 2;
//        return items = Arrays.copyOf(items, size);
//    }
    
    
    private void removeElementAt(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + size);
        else if (index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        top--;
        items[index] = null;
    }
    
    private T elementAt(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + size);
        return items[index];
    }
    
    public T peek() {
        if (size == 0)
            throw new EmptyStackException();
        return elementAt(top);
    }
    
    public boolean isFull() {
        return top == size - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }
//
//    private class StackIterator implements Iterator<T> {
//        private int pos;
//
//        public StackIterator() {
//            pos = 0;
//        }
//        @Override
//        public boolean hasNext() {
//            return pos < top;
//        }
//
//        @Override
//        public T next() {
//            T returnItem = elementAt(pos);
//            pos += 1;
//            return returnItem;
//        }
//    }
}
