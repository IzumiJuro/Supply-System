import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Goods implements Comparable<Goods>{
    static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public String date;
    
    public Goods(String date) {
        this.date = date;
    }
    
    public Goods() {
    
    }
    
    
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public int compareTo(Goods o) {
        try {
            return formatter.parse(o.getDate()).compareTo(formatter.parse(this.getDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String toString() {
        return "生产日期为:" + this.getDate();
    }
}
