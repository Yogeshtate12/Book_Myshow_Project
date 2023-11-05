package com.service;
import java.sql.*;
import java.util.*;

public interface BookMyShow {
	void bookTicket(Connection con) throws Exception;//movie is a return type
     void addMeal(Connection con) throws Exception ;//it return a list objects of snack class
	void printDetails(Connection con) throws Exception;//it return details of of movie and meals you booked
	void logout();//it stops the execution of program

}
