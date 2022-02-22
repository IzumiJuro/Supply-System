import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean state = true;
        
        System.out.println("------------------欢迎使用供货信息管理系统------------------");
        System.out.println("                     1. 取 货                           ");
        System.out.println("                     2. 上 货                           ");
        System.out.println("                     3. 查 询                           ");
        System.out.println("                     4. 倒 货 架                        ");
        System.out.println("                     0. 离 开                        ");
        System.out.println("----------------------请输入数字-------------------------");
        MyStack<Goods> stack = new MyStack<>(10);
        stack.push(new Goods("2000-2-13"));
        stack.push(new Goods("2001-2-13"));
        stack.push(new Goods("2002-2-13"));
        stack.push(new Goods("2022-2-13"));
        stack.push(new Goods("2010-2-13"));
        stack.push(new Goods("2005-2-13"));
        while (state) {
            input = scanner.nextLine();
            if (input.equals("2")) {
                Goods goods = new Goods();
                
                System.out.println("请输入货物的生产日期");
                String date = scanner.nextLine();
                goods.setDate(date);
                stack.push(goods);
            }
            if (input.equals("3")) {
                for (int i = 0; i < stack.size(); i++) {
                    System.out.println(stack.items[i]);
                }
            }
            if (input.equals("4")) {
                for (int i = 0; i < stack.size(); i++) {
                    for (int j = 0; j < stack.size() - i - 1; j++) {
                        try {
                            Date date1 = formatter.parse(stack.items[j].getDate());
                            Date date2 = formatter.parse(stack.items[j + 1].getDate());
                            if (date1.before(date2)) {
                                Goods temp;
                                temp = stack.items[j];
                                stack.items[j] = stack.items[j + 1];
                                stack.items[j + 1] = temp;
                            }
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("");
                }
            }
            if (input.equals("0")) {
                clearScreen();
                System.out.println("******************************");
                System.out.println("******                 *******");
                System.out.println("******  感谢使用 再见    *******");
                System.out.println("******                 *******");
                System.out.println("******************************");
                System.out.println("");
                state = false;
            }
        }
        
        
    }
    
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
}
