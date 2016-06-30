package com.valud;

import java.util.ArrayList;

public class LogicClass {
	
	String list1, list2;
	int i, j;

	@SuppressWarnings("unchecked")
	void switchPairs(ArrayList<String> list) {
		String temp;
		String temp2;
		int list1 = 0;
		
		  //swap pairs of words
		 for(int i = 0; i <list.size()-1; i+=2) {
		
		      temp = list.get(i);
	
		      list.set(i, list.get(i+1));
	
		      list.set(i+1, temp);
	
		    }
		 System.out.println(list);
		}

	}


