package com.valud;

import java.util.Scanner;

public class ApplicationClass {

	public static void main(String[] args) {
		System.out.println("Enter 5 Letter Word::");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String inputString=sc.nextLine();
		System.out.println("Your String Is "+ inputString);
		inputString=inputString.replaceAll("\\s","*");
		char toChecK[]=inputString.toCharArray();
		int count=0,i;
		for(i=0;i<inputString.length();i++)
		{
			for(int j=0;j<inputString.length();j++)
			{
				if(inputString.charAt(i)==inputString.charAt(j)) 
				   count++;
			}
			if(count!=0 && inputString.charAt(i)!='*')
			{
				boolean flag=false;
				for(int k=i+1;k<inputString.length();k++)
				{
					if(toChecK[k]==inputString.charAt(i))
						  flag=true;
				}
				
				if(flag==false)
				{
					switch(count)
					{
						case 1:
						System.out.println(inputString.charAt(i)+"::"+"One");
						break;
						case 2:
						System.out.println(inputString.charAt(i)+"::"+"Two");
						break;
						case 3:
						System.out.println(inputString.charAt(i)+"::"+"Three");
						break;
						case 4:
						System.out.println(inputString.charAt(i)+"::"+"Four");
						break;
						case 5:
						System.out.println(inputString.charAt(i)+"::"+"Five");
						break;
						case 6:
						System.out.println(inputString.charAt(i)+"::"+"Six");
						break;
						case 7:
						System.out.println(inputString.charAt(i)+"::"+"Seven");
						break;
						case 8:
						System.out.println(inputString.charAt(i)+"::"+"Eight");
						break;
						case 9:
						System.out.println(inputString.charAt(i)+"::"+"Nine");
						break;
						default:
						System.out.println(inputString.charAt(i)+"::"+"No");
					
				   }
					flag=false;
				//System.out.println(inputString.charAt(i)+":"+count);
				}
			}
				count=0;
			
		}
		
		
   }

}



//******************Other Way**********************
/*char ch;
for(ch='a';ch<'z';ch++)
{
	for(int i=0;i<inputString.length();i++)
	{
		if(ch==inputString.charAt(i))
		{
			count++;
		}
	}
	if(count!=0)
		System.out.println(ch +":"+count);
		count=0;
	
}*/