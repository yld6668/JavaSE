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
            System.out.println("===============��ӭʹ���Զ���Ʊ��===============");
            System.out.println("�������۹̶�Ʊ�� " + price + " Ԫ�ĳ�Ʊ");
            while (true) {
                System.out.println("��ѡ�����...");
                System.out.println("1��Ͷ��");
                System.out.println("2����ӡ��Ʊ");
                System.out.println("3������");
                System.out.println("reset ����");
                System.out.println("turn off �ػ�");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        int amount = scanner.nextInt();
                        scanner.nextLine();
                        if (amount < 0) {
                            System.out.println("������Ͷ��...");
                        } else {
                            ticketMachine.insertMoney(amount);
                        }
                        System.out.println("��ǰ��" + ticketMachine.getBalance() + " Ԫ");
                        break;
                    case 2:
                        ticketMachine.print();
                        System.out.println("��ǰ��" + ticketMachine.getBalance() + " Ԫ");
                        if (ticketMachine.getBalance() == 0) {
                            quitFlag = true;
                        }
                        break;
                    case 3:
                        System.out.println("���պ����� " + ticketMachine.refund() + " Ԫ");
                        quitFlag = true;
                        break;
                    case 4:
                        System.out.println("������Ӫ������ " + ticketMachine.getTotal() + " Ԫ");
                        ticketMachine.reset();
                        System.out.println("============����������============");
                        quitFlag = true;
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("��������ȷ�Ĺ������");
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
//���췽��
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
    		System.out.println("����");
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















