package com.valud;

/**
 * @author HGonge
 * Date 29June2016
 */
public class MainClass {
	
		public static void main(String[] args) {
			ApplicationClass obj=new ApplicationClass();
			boolean result =obj.logic();
			if(result==true)
				System.out.println("\nThe String which you have entered is palindrome.");
			else
				System.out.println("\nThe String which you have entered is not palindrome.");
			System.out.println("*********************Program Completed Successfully********************");
		}
			
}