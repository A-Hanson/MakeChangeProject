package makechange;

import java.util.Scanner;

public class MakeChange {
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		// uncomment next line to run program on given test cases
//		testCases();

		// prompt user for price of item (less than 20.00) and how much they paid
		double amount = getAmount();
		double tendered = getTendered();
		
		// truncate any numbers past the second decimal place
		amount = Math.floor(amount * 100.0) / 100;
		tendered = Math.floor(tendered * 100.0) / 100;
		
		// Output: too little money, exact amount, or change
		checkTenderedAmount(tendered, amount);

		
		userInput.close();
	
		
	}
	
	public static double getAmount() {
		// prompt user for the price of the item (20.00 or less)
		System.out.print("How much does the item cost? ");
		double itemPrice = userInput.nextDouble();
		return itemPrice;
	}
	
	public static double getTendered() {
		// prompt user for the amount tendered
		System.out.print("How much was tendered? ");
		double amountTendered = userInput.nextDouble();
		return amountTendered;
	}
	
	public static void checkTenderedAmount(double tendered, double amount) {
		// check if tendered >= amount. Prints appropriate message
		if (tendered == amount) {
			System.out.println("Exact amount. Thank you!");
		} else if (tendered < amount) {
			System.out.println("ERROR. More money needed.");
		} else {
			String tenderMessage = stringChangeAmounts(tendered, amount);
			System.out.println(tenderMessage);
		}
		
	}
	
	public static String stringChangeAmounts(double tendered, double amount) {
		// Change amounts to be printed
		int tenDollarBill, fiveDollarBill, oneDollarBill, quarter, dime, nickel, penny;
		String changeAmounts = "Please give the following in change: ";
		oneDollarBill = 0;
		quarter = 0;
		dime = 0;
		nickel = 0;
		penny = 0;
		
		
		double change = tendered - amount;
		if (change / 10.0 >= 1.0) {
			tenDollarBill = 1;
			change -= 10.0;
			changeAmounts += "1 ten dollar bill, ";
		}
		if (change / 5.0 >= 1.0) {
			fiveDollarBill = 1;
			change -= 5.0;
			changeAmounts += "1 five dollar bill, ";
		}
		
		while (change >= 1.0) {
			oneDollarBill += 1;
			change -= 1.0;
		}
		if (oneDollarBill > 0) {
			changeAmounts += String.valueOf(oneDollarBill) + " one dollar bill(s), ";
		}
		
		if (change / 0.25 >= 1.0) {
			quarter = (int) (change / 0.25);
			change %= 0.25;
			changeAmounts += String.valueOf(quarter) + " quarter(s), ";
		}
		if (change / 0.1 >= 1.0) {
			dime = (int) (change / 0.1);
			change %= 0.1;
			changeAmounts += String.valueOf(dime) + " dime(s), ";
		}
		if (change / 0.05 >= 1.0) {
			nickel = (int) (change / 0.05);
			change %= 0.05;
			changeAmounts += String.valueOf(nickel) + " nickel(s), ";
		}
		
		if (change > 0) {
			penny = (int) ((change  + 0.005) * 100);
			changeAmounts += String.valueOf(penny) + " penny(s)";
		}
		
		return changeAmounts;
	}
	
	public static void testCases() {
		/*
		 Test cases
	Amount: .67, Tendered: .50, Result: Error message
	Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
	Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
	Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
		 */
		int count;
		for (count = 1 ; count <= 4; count++) {
			switch (count) {
			case 1:
				checkTenderedAmount(0.5, 0.67);
				break;
			case 2:
				checkTenderedAmount(1.0, 0.67);
				break;
			case 3:
				checkTenderedAmount(1.0, 0.59);
				break;
			case 4:
				checkTenderedAmount(20.00, 3.96);
				break;
			default:
				System.out.println("Error with Test method");
			}
		}
	}

}
