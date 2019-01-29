package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmanager {
	
	public static ResultSet ReportDB() {
		//List<Book> list=new List();
		try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Test_1234");
	Statement statement=connection.createStatement();
	ResultSet result=statement.executeQuery("select book_name,author_name,number_of_copies from book where number_of_copies>0");
	return result;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
	}
		
}

