package com.valud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ApplicationClass {

	public static void main(String[] args) {
		System.out.println("Enter Your Sentence::");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String inputString=sc.nextLine();
		System.out.println("Your String Is "+ inputString);
		String s[]=inputString.split(" ");
		ArrayList< String> list=new ArrayList<>();
		list.addAll(Arrays.asList(s));
		int i=0,count=0;
		//System.out.println(list.get(i));
		System.out.printf( "%-15s %15s %n","Word Length","Occurences");
        for(i=0;i<list.size();i++)
        {
        	for(int j=0;j<list.size();j++)
        	{
        		if(list.get(i).equals(list.get(j)))
        			count++;
        		if(list.get(i).equals(list.get(j))&&count>1)
        		  list.remove(j);		
        	}
        	if(count!=0)
        	System.out.format("%-15s %15s %n",list.get(i).length(),count);
        	count=0;
        }
	}

}
