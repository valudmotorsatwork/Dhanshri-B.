package com.valud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LogicClass {

	
	void logic()
	{
	
		Scanner sc=new Scanner(System.in);
		String inputString = null;
		System.out.println("Enter Your Input::");
		int temp;
		temp=sc.nextInt();
		System.out.println(temp);
		System.out.println("Enter Set Of Integer Values::");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=temp;i++)
		{
			list.add(sc.nextInt());
		}
		
		if(temp==0)
		{
			System.out.println("you can not keep list empty.");
		}
		 if ((list.size()%2)==1)
	        {
	            list.remove(list.size()-1);
	        }
		
		
		
		for(int i=0;i<list.size()-1;i+=2)
		{
			if(list.get(i)>list.get(i+1))
			{
				list.remove(i);
				list.remove(i);
			}
			System.out.println(list);
			
		}
		
		
		//*************** Display everything in the list***************
		Iterator<Integer> it=list.iterator();
		while(it.hasNext())
		{
			it.next();
		}
	//	System.out.println(list.size());
		
		
		}
	}
     

