I implemented the program using three classes

1. A customer class to hold all customer details. It stored the customer id, the tickets and the types of tickets bought by the customer.

2. A lottery machine class to perform all fucntions of the lottery machine.
The lottery machine class stores list of customers who bought tickets. It also stores lists of pick3, pick4 and pick5 tickets generated.
The ticket generation methods generate tickets for a particular customer. If the requested type of tickets are sold out the method alerts sold out status. Else it generates a ticket unique number and allots it to the customer. 

3. A simulation class which simulates the lottery process starting from ticket sales to drawing the winner.

A random selection is made between 'new customer' or 'existing customer'. If the selection is for a new customer then a new customer is created. Once the customer selection is made customer goes on to buy the ticket. Here a random selection is made between the three ticket types. If the selected type is available then a ticket is issues to the customer else, a random selection is made beteween the remaining two types of tickets and that ticket is issued to the customer. If the second selected type is also unavailable then customer is given a ticket of the third type. In a case where all three ticket types are unavailable an all tickets sold out message is issued. This process is repeated untill all tickets are sold out.

For drawing the winners, a random number between 0(inclusive) and the maximum allowed number of the ticket type(exclusive) is selected. This number is used as an index to pick the winning ticket from that type ticket list.

The entire process is appended to the 'SimulationResults_Tej.txt' file. The answers to the questions asked are reported in the 'SimulationReporting_Tej.txt' file.


How to run and test results:
1. There are three java files in my program: Customer.java, LotteryMachine.java and Simulation.java
2. 2. The package name is vt.challenge.tej
3. 3. Create a folder of choice and in it create folders as vt\challenge\tej (tej folder inside challenge folder inside vt folder inside your folder)
4. 4. Download the java files to tej folder
5. 5. Using command prompt navigate to tej directory and compile the java files (javac *.java)
6. 6. Now navigate to your folder i.e., move three folders back (cd..)
7. 7. Run the program from command prompt (java vt.challenge.tej.Simulation)
8. 8. Two output files will be created in your folder (SimulationResults_Tej.txt and SimulationReporting_Tej.txt)
9. 9. The answers to the questions asked can be found in SimulationReporting_Tej.txt file
10. 10. The answers can be tested/verified and the entire simulation process can be checked with the contents of the SimulationResults_Tej.txt file
