package ticket;
import java.util.Scanner;

 public class Ticket {

    public static void main(String[] args) {

        /*int default_price = 2;
        int price = args.length > 0 ? Integer.parseInt(args[0]) : default_price;*/
        //TicketMachine ticketMachine = new TicketMachine(price);
        //ticketMachine.setPrice(price);

        Scanner scanner = new Scanner(System.in);
        int price=scanner.nextInt();
         TicketMachine ticketMachine = new TicketMachine(price);
        while (true) {
            boolean quitFlag = false;
            System.out.println("===============欢迎使用自动售票机===============");
            System.out.println("本机销售固定票价 " + price + " 元的车票");
            while (true) {
                System.out.println("请选择服务...");
                System.out.println("1、投币");
                System.out.println("2、打印车票");
                System.out.println("3、找零");
                System.out.println("reset 重置");
                System.out.println("turn off 关机");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        int amount = scanner.nextInt();
                        scanner.nextLine();
                        if (amount < 0) {
                            System.out.println("请正常投币...");
                        } else {
                            ticketMachine.insertMoney(amount);
                        }
                        System.out.println("当前余额：" + ticketMachine.getBalance() + " 元");
                        break;
                    case 2:
                        ticketMachine.print();
                        System.out.println("当前余额：" + ticketMachine.getBalance() + " 元");
                        if (ticketMachine.getBalance() == 0) {
                            quitFlag = true;
                        }
                        break;
                    case 3:
                        System.out.println("请收好找零 " + ticketMachine.refund() + " 元");
                        quitFlag = true;
                        break;
                    case 4:
                        System.out.println("本次运营总收入 " + ticketMachine.getTotal() + " 元");
                        ticketMachine.reset();
                        System.out.println("============本机被重置============");
                        quitFlag = true;
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("请输入正确的功能序号");
                }
                if (quitFlag) {
                    break;
                }
            }
        }

    }

}
class TicketMachine {
    int price;
    int balance;
    int total;
//构造方法
    TicketMachine(int price) {
        this.price = price;
    }

    void insertMoney(int amount) {
        balance += amount;
    }

    int getBalance() {
        return balance;
    }

    void print() {
    	if(balance>=price){
        System.out.println("==============================");
        System.out.println("This is a ticket");
        System.out.println("price : " + price);
        System.out.println("==============================");
        balance -= price;
        total += price;
    	}else{
    		System.out.println("余额不足");
    	}
    }

    int refund() {
        int result = balance;
        balance = 0;
        return result;
    }

    int getTotal() {
        return total;
    }

    void reset() {
        balance = 0;
        total = 0;
    }

  /*  public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.setPrice(2);
        ticketMachine.insertMoney(-10);
        System.out.println("balance : " + ticketMachine.getBalance());
        ticketMachine.print();
        ticketMachine.print();
        System.out.println("balance : " + ticketMachine.getBalance());
        System.out.println("refund : " + ticketMachine.refund());

        System.out.println("total : " + ticketMachine.getTotal());
    }
*/
}















