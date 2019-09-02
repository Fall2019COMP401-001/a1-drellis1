/*
 * @author drellis1
 * @version 09/01/2019
 */
package a1;

import java.util.*;
import java.text.*;

public class A1Adept {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numItems = input.nextInt();
		String[] itemArray = new String[numItems];
		double[] priceArray = new double[numItems];

		// Populate arrays with input.
		for (int i = 0; i < numItems; i++) {
			itemArray[i] = input.next();
			priceArray[i] = input.nextDouble();
		}

		int numCustomer = input.nextInt();
		String[] customerNameArray = new String[numCustomer];
		double[] customerTotalArray = new double[numCustomer];
		int counter = 0;

		// Iterates through array of customers.
		while (numCustomer > 0) {
			String firstName = input.next();
			String lastName = input.next();
			int customerItems = input.nextInt();
			double customerTotal = 0.0;

			// Iterates through each customer's items.
			while (customerItems > 0) {
				int count = input.nextInt();
				String itemName = input.next();

				// Totals each customers incurred costs.
				for (int i = 0; i < numItems; i++) {
					if (itemArray[i].equals(itemName)) {
						customerTotal += count * priceArray[i];
					}
				}
				customerItems--;
			}
			customerTotalArray[counter] = customerTotal;
			customerNameArray[counter] = firstName + " " + lastName;
			counter++;
			numCustomer--;
		}

		// Function calculates highest spender.
		double max = 0.0;
		String maxName = customerNameArray[0];
		int i = 0;
		while (i < customerTotalArray.length) {
			if (customerTotalArray[i] > max) {
				max = customerTotalArray[i];
				maxName = customerNameArray[i];
			}
			i++;
		}
		System.out.println("Biggest: " + maxName + " (" + max + ")");

		// Prints smallest spender
		double min = 1000.0;
		String minName = customerNameArray[0];
		int j = 0;
		while (j < customerTotalArray.length) {
			if (customerTotalArray[j] < min) {
				min = customerTotalArray[j];
				minName = customerNameArray[j];
			}
			j++;
		}
		System.out.println("Smallest: " + minName + " (" + min + ")");

		// Prints average of all spenders
		double average = 0.0;
		DecimalFormat df = new DecimalFormat("#.##");
		int k = 0;
		while (k < customerTotalArray.length) {
			average += customerTotalArray[k];
			k++;
		}
		average = average / customerTotalArray.length;
		System.out.println("Average: " + df.format(average));
		input.close();
	}
}
