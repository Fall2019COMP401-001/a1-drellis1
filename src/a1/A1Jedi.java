/*
 * @author drellis1
 * @version 09/01/2019
 */

package a1;

import java.util.*;

public class A1Jedi {

	public static void main(String[] args) {
		// Class fields.
		Scanner input = new Scanner(System.in);
		int numItems = input.nextInt();
		String[] itemArray = new String[numItems];
		int[] itemTotalArray = new int[numItems];
		int[] customerPurchaseArray = new int[numItems];

		// Populate array with input.
		for (int i = 0; i < numItems; i++) {
			itemArray[i] = input.next();
			input.nextDouble();
		}

		int numCustomer = input.nextInt();

		// Iterate through all customers.
		while (numCustomer > 0) {
			boolean[] purchasedArray = new boolean[numItems];
			input.next();
			input.next();
			int items = input.nextInt();

			// Iterates through each customers item.
			while (items > 0) {
				int count = input.nextInt();
				String itemName = input.next();

				// Totals items. No duplicates.
				for (int i = 0; i < numItems; i++) {
					if (itemArray[i].equals(itemName)) {
						itemTotalArray[i] += count;
					}
					if (itemArray[i].equals(itemName) && purchasedArray[i] == false) {
						customerPurchaseArray[i] += 1;
						purchasedArray[i] = true;
					}
				}
				items--;
			}
			numCustomer--;
		}

		// Iterates through array and generates output.
		for (int i = 0; i < numItems; i++) {
			if (customerPurchaseArray[i] == 0) {
				System.out.println("No customers bought " + itemArray[i]);
			} else {
				System.out.println(
						customerPurchaseArray[i] + " customers bought " + itemTotalArray[i] + " " + itemArray[i]);
			}
		}
		input.close();
	}
}
