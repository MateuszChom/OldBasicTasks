//package LottoRNG;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		int[] numbers = readNumbers();
		System.out.println(Arrays.toString(numbers));
		
		int[] generated = generateNumbers();
		System.out.println(Arrays.toString(generated));
		
		checkResult(numbers, generated);
	}
	
	static int[] readNumbers() {
		int[] nums = new int[6];
		int counter = 0;
		int num;
		Scanner scan = new Scanner(System.in);
		while (counter < 6) {
			System.out.println("Guess next number:");
			try {
				num = scan.nextInt();
				if (num < 1 || num > 49) {
					System.out.println("You have to guess number from 1 to 49");
				} else if (contains(nums, num)) {
					System.out.println("You already guessed that number");
				} else {
					nums[counter] = num;
					counter++;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Thats not number");
				scan.nextLine();
			}
		}
		
		Arrays.sort(nums);
		scan.close();
		System.out.println("Program finished");
		return nums;
	}
	
	static int[] generateNumbers() {
		int[] nums = new int[6];
		int counter = 0;
		int num = 0;
		Random random = new Random();
		while (counter < 6) {
			num = random.nextInt(49) + 1;
			if (!contains(nums, num)) {
				nums[counter] = num;
				counter++;
			}
		}
		Arrays.sort(nums);
		return nums;
	}
	
	static void checkResult(int[] numbers, int[] generated) {
		int result = 0;
		for (int el : numbers) {
			if (contains(generated, el)) {
				result++;
			}
		}
		
		switch(result) {
			case 3:
				System.out.println("You got 3 right answers");
				break;
			case 4:
				System.out.println("You got 4 right answers");
				break;	
			case 5:
				System.out.println("You got 5 right answers");
				break;
			case 6:
				System.out.println("You blow up bank. You got 6 right answers");
				break;
			default:
				System.out.println("You lose");
		}
	}
	
	static boolean contains(int[] tab, int elem) {
		for (int el : tab) {
			if (el == elem) {
				return true;
			}
		}
		return false;
	}
}