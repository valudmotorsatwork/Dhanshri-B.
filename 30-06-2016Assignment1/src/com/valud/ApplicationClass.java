package com.valud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/*
 *
 * @dbagal
 */
public class ApplicationClass 
{
	public static void main(String[] args) 
	{
		Map<String,TreeSet<String>> networkMap = new HashMap<String,TreeSet<String>>();
		TreeSet<String> showSet = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n********You have To entered 10 shows In Same Or Different Network. Please try to add Further The Shows in next run*****\n");
		for(int i=0;i<10;i++)
		{
			System.out.print("Input type Network : ");
			String network = sc.nextLine();
    		System.out.print("Input Type Show " + network + ": ");
    		String show = sc.nextLine();
    		if ( networkMap.get(network) == null) 
    		{
    			showSet = new TreeSet<String>();
    			showSet.add(show);
    			networkMap.put(network, showSet);
    		}
    		else 
    		{
    			showSet.add(show);
    		}
    		System.out.println(networkMap);
	    }
		System.out.println("\n        **************Entry Inserted****************   \n");
		System.out.println(networkMap);
	
		
		System.out.println("\n        **************Sorted Order****************\n");
		ArrayList<String> keyList = new ArrayList<String>(networkMap.keySet());
		Collections.sort(keyList);
		for (String networka: keyList) 
		{
			System.out.println(networka + ": " + networkMap.get(networka));
		}	
		System.out.println("\n************Program Completed Successfully******************");
	}
}