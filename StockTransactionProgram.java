public class StockTransactionProgram {

	public static void main(String[] args) {
int shares = 1000;
double origPrice = 32.87;
double joePrice = 33.92;
double commission = .02;

System.out.println("Joe paid $" + (shares*origPrice) + "0 for the stock.");
System.out.println("Joe paid his broker $" + (32870*commission) + "0 in commission when he bought the stock.");
System.out.println("Joe sold the stock for $" + (shares*joePrice) + "0.");
System.out.println("Joe paid his broker $" + (33920*commission) + "0 in commission when he sold the stock.");
System.out.println("Joe lost $" + Math.abs(33920-678-657-32870) + ".80.");

	}

}
