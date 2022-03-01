import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String input;
        boolean state = true;
        
        MyStack<Goods> stack = new MyStack<>(10);
        stack.push(new Goods("2000-2-13"));
        stack.push(new Goods("2001-2-13"));
        stack.push(new Goods("2002-2-13"));
        stack.push(new Goods("2022-2-13"));
        stack.push(new Goods("2010-2-13"));
        stack.push(new Goods("2000-2-14"));
        while (state) {
            printMenu();
            input = scanner.nextLine();
            if (input.equals("1")) {
                pickUp(stack);
            }
            if (input.equals("2")) {
                exhibit(stack);
            }
            if (input.equals("3")) {
                query(stack);
            }
            if (input.equals("4")) {
                sort(stack);
            }
            if (input.equals("0")) {
                exit();
                break;
            }
            System.out.println("\n");
            state = hasNextStep();
        }
        
        
    }
    
    public static void printMenu() {
        System.out.println("------------------欢迎使用供货信息管理系统------------------");
        System.out.println("                     1. 取 货                           ");
        System.out.println("                     2. 上 货                           ");
        System.out.println("                     3. 查 询                           ");
        System.out.println("                     4. 倒 货 架                        ");
        System.out.println("                     0. 离 开                           ");
        System.out.println("----------------------请输入数字-------------------------");
    }
    
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    // 取货功能
    public static void pickUp(MyStack<Goods> stack) {
        int size = stack.size() + 1;
        System.out.println("当前货架共有" + size + "件商品");
        System.out.println("请输入要取出的商品数量");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println("----------------------正在取货-------------------------");
        for (int i = 0; i < num; i++) {
            try {
                Goods goods = stack.pop();
                Thread.sleep(1000);
                System.out.println(goods.toString() + "的商品已取货成功");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    
    // 上货功能
    public static void exhibit(MyStack<Goods> stack) {
        int size = stack.size() + 1;
        int remainSize = stack.capacity - size;
        System.out.println("当前货架共有" + size + "件商品,还可添加" + remainSize + "件商品");
        System.out.println("请输入要添加的商品数量");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println("请按照\"年-月-日\"的顺序输入商品的生产日期");
        System.out.println("如:\"2022-2-22\"");
        for (int i = 0; i < num; i++) {
            try {
                String date = scanner.nextLine();
                System.out.println("----------------------正在上货-------------------------");
                Thread.sleep(1000);
                Goods goods = new Goods();
                goods.setDate(date);
                stack.push(goods);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(stack.peek() + "的商品上货成功");
        }
    }
    
    // 查询功能
    public static void query(MyStack<Goods> stack) {
        System.out.println("----------------------开始查询-------------------------");
        try {
            for (int i = stack.size(); i >= 0; i--) {
                Thread.sleep(300);
                System.out.println(stack.items[i]);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------查询成功-------------------------");
    }
    
    private static void swap(MyStack<Goods> stack, int i, int j) {
        Goods temp = (Goods) stack.items[i];
        stack.items[i] = stack.items[j];
        stack.items[j] = temp;
    }
    
    private static void quickSort(MyStack<Goods> stack, int start, int end) {
        if (start >= end)
            return;
        try {
            Date pivot = formatter.parse(((Goods) stack.items[start]).getDate());
            int i = start, j = end;
            while (i != j) {
                Date date1 = formatter.parse(((Goods) stack.items[j]).getDate());
                while (i < j && date1.before(pivot)) {
                    --j;
                    date1 = formatter.parse(((Goods) stack.items[j]).getDate());
                }
                swap(stack, i, j);
                Date date2 = formatter.parse(((Goods) stack.items[i]).getDate());
                while (i < j && date2.after(pivot)) {
                    ++i;
                    date2 = formatter.parse(((Goods) stack.items[i]).getDate());
                }
                swap(stack, i, j);
                quickSort(stack, start, i - 1);
                quickSort(stack, i + 1, end);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
    
    // 倒货架功能
    public static void sort(MyStack<Goods> stack) {
        try {
            System.out.println("----------------------正在倒货架-------------------------");
            quickSort(stack, 0, stack.size());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------倒货架成功-------------------------");
    }
    
    // 判断是否有下一步
    public static boolean hasNextStep() {
        System.out.println("*********************下一步**************************");
        System.out.println("                     1.返 回 主 菜 单                     ");
        System.out.println("                     0.离 开                     ");
        System.out.println("---------------------请输入数字--------------------------");
        String next = scanner.nextLine();
        boolean state;
        if (next.equals("1")) {
            state = true;
            clearScreen();
        } else {
            state = false;
            exit();
        }
        return state;
    }
    
    // 离开界面
    public static void exit() {
        clearScreen();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                                                                 ");
        System.out.println("                        欢迎下次使用， 再见！                       ");
        System.out.println("                                                                 ");
        System.out.println("-----------------------------------------------------------------");
    }
}
