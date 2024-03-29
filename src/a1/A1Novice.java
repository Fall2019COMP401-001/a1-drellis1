/*
 * @author drellis1
 * @version 09/01/2019
 */
package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		// Class fields.
		Scanner input = new Scanner(System.in);
		int numCustomers = input.nextInt();

		// While loop, handles input data.
		while (numCustomers > 0) {
			char firstName = input.next().charAt(0);
			String lastName = input.next();
			int numItems = input.nextInt();
			double total = 0.0;

			// Nested while loop, handles customer items.
			while (numItems > 0) {
				int quantity = input.nextInt();
				input.next();
				double price = input.nextDouble();
				total += quantity * price;
				numItems--;
			}
			// Output.
			System.out.println(firstName + ". " + lastName + ": " + String.format("%.2f", total));
			numCustomers--;
		}
		input.close();
	}
}