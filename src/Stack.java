public interface Stack<T> {
    void push(T x); // 插入一个元素
    
    T pop(); // 弹出顶部元素
    
    T peek(); // 获取顶部元素
    
    boolean isEmpty(); // 判断是否为空
    
    boolean isFull(); // 判断是否栈满
    
}
