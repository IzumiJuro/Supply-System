import java.util.*;

public class MyStack<T> implements Stack<T> {
    public final int capacity; // 栈容量
    private int top; // 栈顶位置
    public Object[] items; // 用于实现栈的数组
    
    // 构造函数
    public MyStack(int capacity) {
        items = new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }
    
    // 返回当前栈中元素的数量
    public int size() {
        return top;
    }
    
    // 从栈中弹出一个元素
    public T pop() {
        T obj = peek();
        removeElementAt(capacity - 1);
        return obj;
    }
    
    // 往栈中插入一个元素
    public void push(T x) {
        if (isFull())
            throw new IllegalArgumentException("货架已满");
        items[++top] = x;
    }


//    public T[] grow() {
//        size = size * 2;
//        return items = Arrays.copyOf(items, size);
//    }
    
    // 封装的向数组指定位置删除元素方法
    private void removeElementAt(int index) {
        if (index >= capacity)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + capacity);
        else if (index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        top--;
        items[index] = null;
    }
    
    // 封装的向数组指定元素插入元素方法
    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        if (index >= capacity)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + capacity);
        return (T) items[index];
    }
    
    // 弹出栈顶元素
    public T peek() {
        if (capacity == 0)
            throw new EmptyStackException();
        return elementAt(top);
    }
    
    // 判断是否栈满
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    // 判断是否栈空
    public boolean isEmpty() {
        return top == -1;
    }
}
