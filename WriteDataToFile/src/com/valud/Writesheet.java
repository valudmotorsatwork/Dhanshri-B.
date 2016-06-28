package com.valud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Writesheet {

	@SuppressWarnings("resource")
	public  void display() {
		
		//Declaration:
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");
		
		
		 CellStyle style1 = workbook.createCellStyle();
		 style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
         CellStyle style2 = workbook.createCellStyle();
		 style2.setFillForegroundColor(IndexedColors.RED.getIndex());
		 style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
         CellStyle style3 = workbook.createCellStyle();
		 style3.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		 style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		
		
	
		// For Storing File Data Line By Line Into List(ArrayList).
			List<String> list = new ArrayList<>();
					
			double k = 0.0d,k1=0.0d;
			try {

			// For Accessing DataMembers
			DataMembers db = new DataMembers();

			// File is read from other class.
			ReadingDataFromFile fin = new ReadingDataFromFile();
			BufferedReader br = fin.openFile();

			// count variable is used to skip first line of input file.
			int count = 0;

			XSSFRow row = null;

			String s;
			String[] line = new String[6];
           
			while ((s = br.readLine()) != null) {
        	 
        	  if (count>=0) 
				{
				 if(s.contains("|")) 
				{
					line = s.split("[|]");
					db.setComapnyName(line[5]);
					db.setDate(line[1]);
				}

				else if (s.contains(";"))
				{
					line = s.split("[;]");
					db.setComapnyName(line[5]);
					db.setDate(line[1]);
				} 
				else if (s.contains(":"))
				{
					line = s.split("[:]");
					db.setComapnyName(line[5]);
					db.setDate(line[1]);
				}
				else if (s.contains(" "))
				{
					line[0] = s.substring(0, 8);
					line[1] = s.substring(9, 19);
					line[2] = s.substring(19, 22);
					line[3] = s.substring(22, 28);
					line[4] = s.substring(29, 36);
					line[5] = s.substring(40, 53);
				}
			}
				
				for (int i = 0; i < line.length; i++) {
					list.add(line[i]);
				}
				count++;
			} // End Of while loop.
		
				
			//Here we write logic to convert this column data in row wise i.e. row=7 and column=5
			int r = 0;
			Cell cell = null ;
			int i=0;
			for ( i = 0; i < 7; i++) {
				
				row = sheet.createRow(i);
				for (int j = 0; j < 6; j++) {
				 cell = row.createCell(j);
				// Create a cell with a value and set style to it.
				 cell.setCellValue(list.get(r));
			
				if(i==0)
				{	
					cell.setCellStyle(style1);
				}
				else
				{
				 if(j==4 && Double.parseDouble(list.get(r))>3000)
				 {
					cell.setCellStyle(style2);
				 }
				else
				{
					cell.setCellStyle(style3);
				}
				 
			}
				r++;
				}
	
			}
			
			//For performing Sum Of Column Values (Total_Recon).
		    k=Double.parseDouble(list.get(9))+Double.parseDouble(list.get(15))+Double.parseDouble(list.get(21))+Double.parseDouble(list.get(27))+Double.parseDouble(list.get(33))+Double.parseDouble(list.get(39));
			System.out.println(k);
			row=sheet.createRow(i);
			cell=row.createCell(3);
			cell.setCellValue(k);
			
			//For performing Sum Of Column Values (Recon_Diff).
			k1=Double.parseDouble(list.get(10))+Double.parseDouble(list.get(16))+Double.parseDouble(list.get(22))+Double.parseDouble(list.get(28))+Double.parseDouble(list.get(34))+Double.parseDouble(list.get(40));
			System.out.println(k1);
			cell=row.createCell(4);
			cell.setCellValue(k1);
			
			
           
			//For Writing Data To JavaBokks.xlsx File.
			FileOutputStream fos = new FileOutputStream("./resources/Javatext.xlsx");
			workbook.write(fos);
			fos.close();
			
		
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		
		//For PDF file.....
				 Document document = new Document();
				 Paragraph paragraph = null;
			
				 PdfPTable table = new PdfPTable(6);
				 
				//special font sizes
				   Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
				   new Font(FontFamily.TIMES_ROMAN, 12); 
				   
				 try
			      {
			         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./resources/Javapdf.pdf"));
			         document.open();
			        
			         table.setWidthPercentage(100); //Width 100%
			         table.setSpacingBefore(10f); //Space before table
			         table.setSpacingAfter(10f); //Space after table
			         
			        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			        InsertDataIntoTable insertIntoTable=new InsertDataIntoTable();
			        int colorGreen[]={0,222,0};
			        int colorGray[]={128,128,128};
			        int colorRed[]={222,0,0};
			        int r=0;
			        int i=0;
				    for (i=0;i<7;i++)
				    {
				    	 for (int j = 0; j < 6; j++) 
				    		 {
				    		  paragraph = new Paragraph(list.get(r));
				    		 	if(i==0)
				    		 		insertIntoTable.insertCell(table,paragraph,bfBold12,colorGreen);
				    		 	
				    		 	else
				    		 		{
				    		 		if(j==4 && Double.parseDouble(list.get(r))>3000)
				    		 			insertIntoTable.insertCell(table,paragraph,bfBold12,colorRed);
				    		 		else 
				    		 			insertIntoTable.insertCell(table,paragraph,bfBold12,colorGray);
				    		 		}
				    			 r++;
				    		  }
				     }
				    	 System.out.println("for pdf:"+i);
				    	 float f1 = (float) k;
				    	 Paragraph tableParagraph =new Paragraph("PDF Report Of Reconciliation");
				    	 tableParagraph.add(table);
				    	 document.add(tableParagraph);
				    	 paragraph=new Paragraph(f1);
				    	 Paragraph summaryParagraph =new Paragraph("Summary Of Report--> Total Recon = "+ f1);
				    	 document.add(summaryParagraph);
				         document.close();
				         writer.close();
				       
			      }//try block closed.
				 catch (DocumentException e)
				      {
				         e.printStackTrace();
				      }
				 catch (FileNotFoundException e)
				      {
				         e.printStackTrace();
				      }
			
		}
}
