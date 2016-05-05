package vt.challenge.tej;

public class Customer {

	//Instance variable declaration begin
	private int cid;	//Customer id
	private int[] ctickets = new int[5];  //Purchased tickets
	private int[] types = new int[3];	//Purchased ticket types
	private byte count = 0;
	//Instance variable declaration end
	
	
	//Constructor
	Customer(){
		for(int i = 0; i < 3; i++)
			types[i] = 0;
	}
	//Constructor end
	
	
	//Getters and Setters begin
	protected int getCid() {
		return cid;
	}
	protected void setCid(int cid) {
		this.cid = cid;
	}
	protected int[] getCtickets() {
		return ctickets;
	}
	protected void setCtickets(int cticket) {
		this.ctickets[count] = cticket;
		count++;
	}
	protected byte getCount() {
		return count;
	}
	protected void setCount(byte count) {
		this.count = count;
	}
	protected int[] getTypes() {
		return types;
	}
	protected void setTypes(int type) {
		this.types[type] = 1;
	}
	//Getters and Setters end
}
