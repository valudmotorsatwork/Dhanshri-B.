package com.string;

import java.io.*;
import java.util.Scanner;
public class ForSplitingString {
	
 void processMethod()
{
	//count variable in order to print message if user enter string without letter 'b' or 'B'
	int count=0;
	try
		{
			Scanner sc=new Scanner(System.in);
			String inputString;
			System.out.println("Enter Your String::");
			inputString=sc.nextLine();
			System.out.println("Your String Is "+ inputString);
			inputString.trim();
			String line[]=inputString.split(" ");
		
			for(int i=0;i<line.length;i++)
			{
				if(line[i].startsWith("b")||line[i].startsWith("B"))
				{
					System.out.println("Strings Starting With Letter As B or b are::" );
					System.out.println(line[i]);
					count++;
				}
			}
			if(count==0)
			{
				System.out.println("No String Found...Please Enter The String Again..");
			}
		}//try block closed.
    catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		
	 }//method closed.
	}
		




