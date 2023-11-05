package com.user;
import java.util.*;

import java.sql.*;

import com.service.*;

public class Test {

	public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Admin@123");
		Scanner sc=new Scanner(System.in);
		BookMyShow desk=new BookingDesk();
		System.out.println("Enter your username");
		String user=sc.next();
		String pass=sc.next();
		BookingDesk bookingDesk = new BookingDesk();
		boolean loop=bookingDesk.signIn(user,pass);
		while(loop)
		{
		System.out.println("Choose option from below list");
		System.out.println("1.Book your ticket\n2.Add Meal\n3.Print Details\n4.LogOut");
		int n=sc.nextInt();
		
				
		
		switch(n)
		{
		  case 1 :
		  
			desk.bookTicket(con);
			break;
		  case 2 :
			  System.out.println("Choose from the above menu");
			  System.out.println("What do you want to eat");
			  
			  desk.addMeal(con);
			  break;
		  case 3 :
			  desk.printDetails(con);
			  break;
		  case 4:
			  desk.logout();
			  loop=false;
			  break;
		  default :
			  System.out.println("wrong choice");
		}
		
		 
	}

}
}
