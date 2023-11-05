package com.service;
import java.util.*;

import java.sql.*;

public class BookingDesk implements BookMyShow {
	Scanner sc=new Scanner(System.in);
	int movieId;
	int snackId;
	public static boolean signIn(String user,String pass)
	{
		
		String username="root";
		String password="Root@123";
		
		boolean value;
		if((username.equals(user))&&(password.equals(pass)))
		{
			value=true;
			
		}
		else if((user=="root")&&(pass=="Root@1234"))
		{
			System.out.println("looged out of system");
			value=false;
		}
		else
		{
			System.out.println("Enter correct user ID/password");
			value=false;
		}
		
		return value;
		
	}
	 public void bookTicket(Connection con)throws SQLException {
		 String retrieve="select * from ticketstore";
		PreparedStatement ps=con.prepareStatement(retrieve);
		ResultSet rs=ps.executeQuery();
		
		 while(rs.next())
		 {
			 System.out.println("ID :"+rs.getInt(1));
			 System.out.println("NAME :"+rs.getString(2));
			 System.out.println("PRICE :"+rs.getInt(3));
			 System.out.println("RATIING :"+rs.getString(4));
			 System.out.println("GENRE :"+rs.getString(5));
			 System.out.println("----------------------------------------");
		 }
	        System.out.println("Enter the id of movie that you want to watch.");
	        int movieNo=sc.nextInt();

	        movieId=movieNo;
	        while(rs.next())
	        {
	        	
	        	System.out.print("NAME :"+rs.getString(2));
	        	System.out.println("GENRE :"+rs.getString(5));
	        	
	        	System.out.println("PRICE :"+rs.getInt(3));
	        }
	        
	        
	    }
	public void addMeal(Connection con)throws Exception
	{
		
		 String retrieve="select * from snack ";
			PreparedStatement ps=con.prepareStatement(retrieve);
			ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				 System.out.println("ID :"+rs.getInt(1));
				 System.out.println("NAME :"+rs.getString(2));
				 System.out.println("PRICE :"+rs.getInt(3));				 
				 System.out.println("DESCRIPTION :"+rs.getString(4));
				 System.out.println("----------------------------------------");
			 }
		
		System.out.print("Select a meal:");
	   int choice = sc.nextInt();
		 snackId=choice;		 
		System.out.println("id :"+snackId);
	}
	public void printDetails(Connection con) throws Exception {
		
	    int moviePrice = 0;
	    int snackPrice = 0;

	    System.out.println("How many seats do you want to book?");
	    int seat = sc.nextInt();

	    System.out.println("**************Booking Details*************** ");

	    String printRetrieve = "select moviename, genre, price from ticketstore where id=?";
	    PreparedStatement ps = con.prepareStatement(printRetrieve);
	    ps.setInt(1, movieId);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        System.out.print("NAME: " + rs.getString("moviename"));
	        System.out.println("    GENRE: " + rs.getString("genre"));
	        moviePrice = rs.getInt("price");
	        System.out.println("PRICE: " + moviePrice);
	    }

	    System.out.println("**************Your Meals***************");

	    String printRetrieve1 = "select * from snack where id=?";
	    PreparedStatement ps1 = con.prepareStatement(printRetrieve1);
	    ps1.setInt(1, snackId);
	    rs = ps1.executeQuery();

	    while (rs.next()) {
	        System.out.println("NAME: " + rs.getString(2));
	        snackPrice = rs.getInt(3);
	        System.out.println("PRICE :"+rs.getInt(3));
	        
	    }

	    System.out.println("----------------------------------");

	    int price = (seat * moviePrice) + snackPrice;
	    System.out.println("Total Price: " + price);
		
	}


	
	public void logout()
	{
		BookingDesk.signIn("root", "Root@1234");
		//System.out.println("Logged out of system");
		
		
	}

}
