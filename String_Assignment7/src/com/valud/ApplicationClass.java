package com.valud;

import java.util.Scanner;

public class ApplicationClass {

	//********************Here We Use Logic Of Sorting To Check String Is Palindrome Or Not**************************
	//Here We Take Two Pointer One Is Pointing To 0th character and One Is Pointing To Last Character And Check Character By Character.
	public boolean logic()
	{
		boolean result=true;
		String inputString="";
		System.out.println("Enter Sentence/String To Check Whether It Is Panlidrome Or Not:");
		Scanner sc = new Scanner(System.in);
		inputString= sc.nextLine();
		int  leftPointer =0;
		int rightPointer=inputString.length()-1;
		char charLeft,charRight;
		
		while (leftPointer <rightPointer)
    	{
    		charLeft =inputString.charAt(leftPointer );
    		charRight =inputString.charAt(rightPointer);
    		if (String.valueOf(charLeft).equalsIgnoreCase(String.valueOf(charRight)))
    		{
    			leftPointer ++;
    			rightPointer--;
    		}

    		else if (charLeft == '.' || charLeft == '-' || charLeft == ',' || charLeft == ' ' || charLeft == '!' || charLeft == ':' || charLeft==';')
    		{
    			leftPointer ++;
    		}

    		else if (charRight == '.' || charRight == '-' || charRight == ',' || charRight == ' ' || charRight == '!' || charRight == ':' || charRight == ';')
    		{
    			rightPointer--;
    		}
    		else
    		{
    			result = false;
    			break;
    		}	

    	}
		return result;
	}

}

