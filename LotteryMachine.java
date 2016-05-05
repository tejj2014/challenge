package vt.challenge.tej;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class LotteryMachine {

	//Instance variable declaration begin
	private List<Customer> cust = new CopyOnWriteArrayList<Customer>();	//All customer list
	private List<Integer> pick3 = new CopyOnWriteArrayList<Integer>(); //Pick3 ticket numbers list
	private List<Integer> pick4 = new CopyOnWriteArrayList<Integer>(); //Pick4 ticket numbers list
	private List<Integer> pick5 = new CopyOnWriteArrayList<Integer>(); //Pick5 ticket numbers list
	//Instance variable declaration end
	
	
	//Getters and Setters begin
	protected List<Customer> getCust() {
		return cust;
	}

	protected void setCust(Customer cust) {
		this.cust.add(cust);
	}

	protected List<Integer> getPick3() {
		return pick3;
	}

	protected void setPick3(Integer pick3) {
		this.pick3.add(pick3);
	}

	protected List<Integer> getPick4() {
		return pick4;
	}

	protected void setPick4(Integer pick4) {
		this.pick4.add(pick4);
	}

	protected List<Integer> getPick5() {
		return pick5;
	}

	protected void setPick5(Integer pick5) {
		this.pick5.add(pick5);
	}
	//Getters and Setters end
	
	
	//Methods begin
	//Allotting pick3 ticket to a customer begin
	protected int pick3(int cid){
		
		int ticketno = 0;
		byte flag = 0;
		Random rand = new Random();
		
		if(pick3.size() == 50)
			return -1;
		
		do{
			flag = 0;
			ticketno = 100 + rand.nextInt(900);
			for(Integer i: pick3)
				if(i == ticketno)
					flag = 1;
		}while(flag == 1);
		
		pick3.add(ticketno);
		cust.get(cid-1).setCtickets(ticketno);
		cust.get(cid-1).setTypes(0);
		return ticketno;
	}
	//Allotting pick3 ticket to a customer end
	
	//Allotting pick4 ticket to a customer begin
	protected int pick4(int cid){
		
		int ticketno = 0;
		byte flag = 0;
		Random rand = new Random();
		
		if(pick4.size() == 40)
			return -1;
		
		do{
			flag = 0;
			ticketno = 1000 + rand.nextInt(9000);
			for(Integer i: pick4)
				if(i == ticketno)
					flag = 1;
		}while(flag == 1);
		
		pick4.add(ticketno);
		cust.get(cid-1).setCtickets(ticketno);
		cust.get(cid-1).setTypes(1);
		return ticketno;
	}
	//Allotting pick4 ticket to a customer end
	
	//Allotting pick5 ticket to a customer begin
	protected int pick5(int cid){
		
		int ticketno = 0;
		byte flag = 0;
		Random rand = new Random();
		
		if(pick5.size() == 60)
			return -1;
		
		do{
			flag = 0;
			ticketno = 10000 + rand.nextInt(90000);
			for(Integer i: pick5)
				if(i == ticketno)
					flag = 1;
		}while(flag == 1);
		
		pick5.add(ticketno);
		cust.get(cid-1).setCtickets(ticketno);
		cust.get(cid-1).setTypes(2);
		return ticketno;
	}
	//Allotting pick5 ticket to a customer end
	//Methods end
}
