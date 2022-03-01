public class Goods {
    public String date;
    
    //构造方法
    public Goods(String date) {
        this.date = date;
    }
    
    public Goods() {
    
    }
    // 获得商品日期
    public String getDate() {
        return date;
    }
    // 设置商品日期
    public void setDate(String date) {
        this.date = date;
    }
    
    // 重写了商品的输出形式
    @Override
    public String toString() {
        return "生产日期为:" + this.getDate();
    }
}
