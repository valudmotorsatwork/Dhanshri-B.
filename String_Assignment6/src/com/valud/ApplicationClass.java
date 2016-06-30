package com.valud;

import java.util.Scanner;

public class ApplicationClass {

	/**
	 * @author dbagal
	 * Date:28-06-2016
	 */
	void display()
	{
		Scanner sc = new Scanner(System.in);
		String inputString;
		System.out.println("Enter Your String::");
		inputString = sc.nextLine();
		System.out.println("Your String Is " + inputString);
		System.out.println(inputString.length());
		StringBuilder sb = new StringBuilder();
		int j;
		for (int i = 1; i <= inputString.length(); i++) {
			for (j = 0; j < inputString.length() - i; j++) {
				System.out.print(" ");
			}

			System.out.print(inputString.substring(0, i));
			if (i > 1) {
				sb = new StringBuilder(inputString.substring(0, i - 1));
				String temp = String.valueOf(sb.reverse());
				System.out.print(temp);
			}
			System.out.println();
		}

		for (int i = inputString.length() - 1; i > 0; i--) {
			for (j = 0; j < inputString.length() - i; j++) {
				System.out.print(" ");
			}

			// to append character each time.
			System.out.print(inputString.substring(0, i));
			if (i > 1) {
				sb = new StringBuilder(inputString.substring(0, i - 1));
				String temp = String.valueOf(sb.reverse());
				System.out.print(temp);
			}
			System.out.println();
		}

	}

}
