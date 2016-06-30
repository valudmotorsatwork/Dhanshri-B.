package com.valud;

import java.util.ArrayList;

public class LogicClass {

	
  //************************Here We appending '****' Before Each String Whose Length Is ==4 *****************************
	void markLength4(ArrayList<String> list){
		for(int i=0;i<list.size();i++)
		{
			String s=list.get(i);
			if(s.length()==4)
			{
				list.add(i, "****");
				i++;
			}
			
		}
		System.out.println(list);
	}
	
	

}
