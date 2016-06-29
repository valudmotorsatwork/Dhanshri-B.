package com.valud;

import java.util.Scanner;

public class ApplicationClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String inputString;
		System.out.println("Enter Your String Of 5 Letters Only::");
		inputString=sc.nextLine();
		System.out.println("Your String Is "+ inputString);
		String temp="";
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					if(i==j||i==k||j==k) continue;
					System.out.println(temp+inputString.charAt(i)+inputString.charAt(j)+inputString.charAt(k));
				}
			}
		}

	}

}
