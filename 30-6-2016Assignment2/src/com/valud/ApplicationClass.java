package com.valud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ApplicationClass {

	public static void main(String[] args) {
	    
		//**************Declaring List To Store String***************************
		ArrayList<String> list=new ArrayList<String>();
		
		//************For Taking Input From User*************************
		Scanner sc=new Scanner(System.in);
		String inputString = null;
		System.out.println("Enter Your Input::");
	    int temp;
	    temp=sc.nextInt();
		System.out.println(temp);
		System.out.println("Type a string:");
		for(int i=1;i<=temp;i++)
		{
		      list.add(sc.next());
		 }
		
		
		
		 // Display everything in the list
		Iterator< String> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println(list.size());
		LogicClass obj=new LogicClass();
		obj.switchPairs(list);
		
	}

}
