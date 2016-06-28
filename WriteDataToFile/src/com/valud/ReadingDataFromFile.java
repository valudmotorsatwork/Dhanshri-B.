package com.valud;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadingDataFromFile 
{
	//Here is logic of reading input file.
	
	FileReader fr;
    public BufferedReader br;

	public BufferedReader openFile()
	{
		try{
	    	fr = new FileReader("./resources/ass1_input.txt");
	    	br = new BufferedReader(fr);
	    	}
		catch(Exception e){
			e.printStackTrace();
		}
	return br;
 }
	
 }
