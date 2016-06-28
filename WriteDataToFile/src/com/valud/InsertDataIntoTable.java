package com.valud;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class InsertDataIntoTable {
	
	//For Inserting Data Of PDF File Into Table Format.
	   public void insertCell(PdfPTable table,Paragraph P,Font font,int[]color){
		  
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(P));
		  cell.setBackgroundColor(new BaseColor(color[0],color[1],color[2]));
		  table.addCell(cell);
		 }
	 
}
