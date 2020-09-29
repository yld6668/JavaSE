
public class showticket {
	public static void main(String[] args) {
		TicketMachine ticketMachine = new TicketMachine();
		ticketMachine.setPrice(2);
		ticketMachine.insertMoney(10);
		
		System.out.println("balance :"+ticketMachine.getBalance());
		ticketMachine.printTicket();
		ticketMachine.printTicket();
		
		System.out.println("balance :"+ticketMachine.getBalance());
		System.out.println("refund :"+ticketMachine.refund());
		System.out.println("total :"+ticketMachine.getTotal());
	}
}
