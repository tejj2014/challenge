package vt.challenge.tej;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Simulation {

	//Main method begin
	public static void main(String[] args){
		
		//Local variable declaration begin
		int choice = 0, choice2 = 0, pick = 0, draw = 0, prechoice = 0, prechoice2 = 0;
		byte flag = 0, flag2 = 0, flag3 = 0, soldout = 0;
		int cid = 0, wid = 0;
		Random rand = new Random();
		PrintWriter pr = null, fr = null;
		String s = "", s2 = "";
		LotteryMachine lm = new LotteryMachine();
		//Local variable declaration end
		
		try{
			pr = new PrintWriter("SimulationResults_Tej.txt", "UTF-8"); //File to append entire simulation process
			fr = new PrintWriter("SimulationReporting_Tej.txt", "UTF-8"); //File to append answers to questions asked
		}catch(Exception e){
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		
		pr.println("Simulation Results");
		
		Customer first = new Customer();
		cid++;
		first.setCid(cid);
		lm.setCust(first);
		
		while(flag == 0){	//Loop to simulate customers buying tickets
			int ccid = 0;
			
			choice = 1 + rand.nextInt(2);
			if(choice == 1){
				Customer c = new Customer();
				cid++;
				c.setCid(cid);
				ccid = cid;
				lm.setCust(c);
			}else{
				ccid = 1 + rand.nextInt(lm.getCust().size());
			}
			pr.println("Welcome customer: " + ccid);
			
			flag2 = 0;
			if(lm.getCust().get(ccid-1).getCount() < 5){
				pr.println("Please choose which tickets would you like to buy");
				pr.println("Enter 3 for pick3, 4 for pick4 or 5 for pick5: ");
				prechoice = 0;
				prechoice2 = 0;
				choice2 = 0;
				while(flag2 == 0){	//Loop that simulates allotting a particular ticket to a customer
					
					while ((prechoice == choice2) || (prechoice2 == choice2))
						choice2 = 3 + rand.nextInt(3);
					
					pr.println("You have chosen pick"+choice2);
					switch(choice2){
					case 3:
						pick = lm.pick3(ccid);
						break;
					case 4:
						pick = lm.pick4(ccid);
						break;
					case 5:
						pick = lm.pick5(ccid);
						break;
					default:
						break;
					}
					if(pick == -1){
						if(prechoice == 0)
							prechoice = choice2;
						if(prechoice2 == 0 && prechoice !=0)
							if(prechoice != choice2)
								prechoice2 = choice2;
						pr.println("Pick"+choice2+" tickets are sold out");
						pr.println("Please wait till next lottery season to buy pick"+choice2+" tickets");
						soldout = 1;
					}else{
						pr.println("Your ticket number is: " + pick);
						flag2 = 1;
					}
				}
			}
			
			if(lm.getCust().get(ccid-1).getCount() == 5){
				pr.println("You have purchased maximum number of tickets allowed per person");
				pr.println("Please wait till the next lottery season to buy new tickets");
				pr.println("Good luck for current season's draw");
			}
			
			if(lm.getPick3().size() + lm.getPick4().size() + lm.getPick5().size() == 150){
				flag = 1;
			}else{
				pr.println("Total sold: " + (lm.getPick3().size() + lm.getPick4().size() + lm.getPick5().size()));
			}
		}
		
		
		fr.println("Simulation Reporting");
		for(int i = 0; i < 2; i++)
			fr.println();
		fr.println("1. Total number of customers who bought tickets: " + lm.getCust().size());	//Question 1
		for(int i = 0; i < 1; i++)
			fr.println();
		fr.println("2. Types of tickets bought by customers");	//Question 2
		
		for(int i = 0; i < 5; i++)
			pr.println();
		pr.println("Customer Details");
		for(Customer c: lm.getCust()){
			s = "";
			pr.println("Customer id: " + c.getCid() + "	Tickets: " + Arrays.toString(c.getCtickets()));
			for(int j = 0; j < c.getTypes().length; j++)
				if(c.getTypes()[j] != 0)
					s = s + "Type" + Integer.toString(j+3) +" ";
			fr.println("Customer with id " + c.getCid() + " purchased types: " + s);
		}
		
		for(int i = 0; i < 1; i++)
			fr.println();
		if(soldout != 0)	//Question 3
			fr.println("3. Customers attempted to buy sold out ticket types");
		else
			fr.println("4. Customers did not attempt to buy sold out ticket types");
		for(int i = 0; i < 1; i++)
			fr.println();	
		s = "";
		
		for(int i = 0; i < 5; i++)
			pr.println();
		pr.println("Draw Winners");
		draw = rand.nextInt(50);
		pick = lm.getPick3().get(draw);
		for(Customer c: lm.getCust()){
			for(int i = 0; i < 5; i++)
				if(c.getCtickets()[i] == pick){
					wid = c.getCid();
					flag3 = 1;
					break;
				}
			if(flag3 == 1)
				break;
		}
		pr.println("Winning number of pick3 draw is: " + pick);
		pr.println("Winner of pick3 draw is customer with id: " + wid);
		s = s + "Winner of pick3 draw is customer with id: " + wid;
		s2 = s2 + "Winning number of pick3 draw is: " + pick;
		
		flag3 = 0;
		draw = rand.nextInt(40);
		pick = lm.getPick4().get(draw);
		for(Customer c: lm.getCust()){
			for(int i = 0; i < 5; i++)
				if(c.getCtickets()[i] == pick){
					wid = c.getCid();
					flag3 = 1;
					break;
				}
			if(flag3 == 1)
				break;
		}
		pr.println("Winning number of pick4 draw is: " + pick);
		pr.println("Winner of pick4 draw is customer with id: " + wid);
		s = s + "\r\n" + "Winner of pick4 draw is customer with id: " + wid;
		s2 = s2 + "\r\n" + "Winning number of pick4 draw is: " + pick;
		
		flag3 = 0;
		draw = rand.nextInt(60);
		pick = lm.getPick5().get(draw);
		for(Customer c: lm.getCust()){
			for(int i = 0; i < 5; i++)
				if(c.getCtickets()[i] == pick){
					wid = c.getCid();
					flag3 = 1;
					break;
				}
			if(flag3 == 1)
				break;
		}
		pr.println("Winning number of pick5 draw is: " + pick);
		pr.print("Winner of pick5 draw is customer with id: " + wid);
		s = s + "\r\n" + "Winner of pick5 draw is customer with id: " + wid;
		s2 = s2 + "\r\n" + "Winning number of pick5 draw is: " + pick;
		fr.println("4. Winners of drawing for each ticket type: ");	//Question 4
		fr.println(s);
		for(int i = 0; i < 1; i++)
			fr.println();
		fr.println("5. Numbers selected during the drawing: ");	//Question 5
		fr.print(s2);
		
		pr.close();
		fr.close();
	}
	//Main method end
}
