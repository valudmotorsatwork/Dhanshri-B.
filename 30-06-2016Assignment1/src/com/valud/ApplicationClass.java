package com.valud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ApplicationClass {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String show;
		TreeSet<String> showset= new TreeSet<>();
		Map<String, TreeSet<String>> networkMap;
		while (true) {
			System.out.println("Input tv network:");
			String networkName = sc.nextLine();
			System.out.println("Input tv show on:" + networkName);
			show = sc.nextLine();
			networkMap = new HashMap<String, TreeSet<String>>();
			if (networkMap.get(networkName) == null) {
				showset = new TreeSet<String>(showset);
				showset.add(show);
				networkMap.put(networkName, showset);
				System.out.println(networkMap);
			} else {
				showset.add(show);
			}
			//System.out.println(networkMap);
			System.out.println("Do YOU Want To Continue yes or no::");
			String choice = sc.nextLine();
			if (choice.equals("No") || choice.equals("no"))
				break;
		}
			System.out.println("\n     Entry Inserted      \n");
			System.out.println(networkMap);

			System.out.println("\n   	 Sorted Order  	 \n");
			ArrayList<String> keyList = new ArrayList<String>(networkMap.keySet());
			Collections.sort(keyList);
			for (String networka : keyList) {
				System.out.println(networka + ": " + networkMap.get(networka));
		}
	}

}
