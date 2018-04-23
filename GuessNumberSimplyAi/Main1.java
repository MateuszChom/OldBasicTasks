//package GuessNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		System.out.println("Choose the number from 0 to 5000.");
		int res = guess();
		System.out.println("The number is " + res);

	}

	static int guess() {

		int result = 0;
		int min = 0;
		int max = 5000;
		int check = 0;
		int counter = 1;
		Scanner s = new Scanner(System.in);

		while (check != 1) {
			result = (max - min) / 2 + min;
			System.out.println("Try " + counter + ". Is it the number: " + result + "?\n Enter 1 = Yes, 2 = No. \n (then tap enter or space or both).");
			try {
				check = s.nextInt();
			} catch (InputMismatchException e) {
				s.nextLine();
			}
			if (check == 2) {
				int checkN = 0;//TODO Additional funcionality, see if user doesnt lie.
				System.out.println("Is it too big?\nEnter 1 = Yes, 2 = No.");

				try {
					checkN = s.nextInt();
				} catch (InputMismatchException e) {
					s.nextLine();
				}
				if (checkN == 1) {
					max = result;
					counter++;
				} else if (checkN == 2) {
					min = result;
					counter++;
				}
			}
		}

		s.close();
		return result;
	}

}
