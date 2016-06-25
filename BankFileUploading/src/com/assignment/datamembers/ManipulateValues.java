package com.assignment.datamembers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulateValues {
	public  void logicMethod() {
		//To Access Data Members We Have Create The Object Of DataMembers Class. 
		DataMembers db=new DataMembers();
		double RECON_DIFF = 0.0d;
    	String s;
    	
    	try {
    		//File is read from other class.
			FileReadingClass fin=new FileReadingClass();
			BufferedReader br=fin.openFile();
			
		    //count variable is used to skip first line of input file.
			int count = 0;
			
			while ((s = br.readLine()) != null) 
			{
				if (count == 0) 
				{
					RECON_DIFF = 0.0d;
				} 
				// Here We Have Reading File and Splitting It Based On Tokens And Fetching Recon_Diff Values. 
				else if(s.contains("|")) 
				{
					String line[] = s.split("[|]");
					db.setComapnyName(line[5]);
					db.setDate(line[1]);
					db.setReconDiff(Double.parseDouble(line[4]));
					RECON_DIFF = RECON_DIFF +  db.getReconDiff();
			     } 
				
               else if (s.contains(";")) 
               {
						String[] line = s.split("[;]");
						db.setComapnyName(line[5]);
						db.setDate(line[1]);
						db.setReconDiff(Double.parseDouble(line[4]));
						RECON_DIFF = RECON_DIFF +  db.getReconDiff();
				}
               else if (s.contains(":")) 
               {
						String[] line = s.split("[:]");
						db.setComapnyName(line[5]);
						db.setDate(line[1]);
						db.setReconDiff(Double.parseDouble(line[4]));
						RECON_DIFF = RECON_DIFF +  db.getReconDiff();
               	}
               else if (s.contains(" ")) 
				{
						String[] line = new String[6];
						line[0] = s.substring(0, 8);
						line[1] = s.substring(9, 19);
					    line[2] = s.substring(19, 22);
					    line[3] = s.substring(22, 28);
						line[4] = s.substring(29, 36);
						line[5] = s.substring(40, 53);
						RECON_DIFF = RECON_DIFF + Double.parseDouble(line[4]);
				}
				count++;
			}// End Of while loop.
			
			System.out.println("TOT_RECON_DIFF=" + RECON_DIFF);
			System.out.println(db.getComapnyName());
			System.out.println(db.getDate());
			
			//here we write data to output_file.txt file.
			FileWriter writeToFile=new FileWriter("./resources/output_file.txt");
			writeToFile.write("\r\nCompany Name::"+db.getComapnyName());
			writeToFile.write("\r\nRecon_Diff::"+String.valueOf(RECON_DIFF));
			writeToFile.write("\r\nRecon_Date::"+db.getTotalRecon());
			writeToFile.close();
			br.close();
			
		 }//End Of Try Block.
		
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found::"+e);
		}
		catch (IOException e) {
			System.out.println("Io Exception Has Occured::"+e);
		}
		
	}
}
