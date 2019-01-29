package database_manager;
import logic_manager.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	static Connection connection;
	
	static void initialize(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Test_1234");
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public boolean addMember(Member member) throws SQLException {
		boolean rs=true;
			initialize();
			PreparedStatement statement=connection.prepareStatement("insert into customer(username,customer_firstname,customer_lastname,customer_address,customer_contact,customer_email,customer_gender) values(?,?,?,?,?,?,?);");
				statement.setString(1, member.getUsername());	
				statement.setString(2, member.getMember_firstname());
				statement.setString(3, member.getMember_lastname());
				statement.setString(4, member.getMember_address());
				statement.setString(5, member.getContact());
				statement.setString(6, member.getEmail());
				statement.setString(7, member.getGender());
			 rs=statement.execute();
			 return rs;
			
	}
	

	public static Boolean Login(String username, String password) throws SQLException {
		initialize();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
		if(result.next())
		return true;
		else
			return false;
	}

	public static int issueBook(int book_id,String member, String date) throws SQLException {
		int result;
		initialize();
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select number_of_copies from book where book_id="+book_id);
		if(resultset.next()) {
			if(resultset.getInt(1)<0) {
				return 0;
			}
			Statement statement1=connection.createStatement();
			ResultSet resultset2=statement1.executeQuery("select customer_id from customer where username='"+member+"'");
			if(resultset2.next()) {
				
		PreparedStatement preparedStatement=connection.prepareStatement("update book set number_of_copies=number_of_copies-1 where book_id=?");
		preparedStatement.setInt(1,book_id);
		preparedStatement.executeUpdate();
		PreparedStatement preparedStatement1=connection.prepareStatement("insert into issuebook(customer_name,book_id,date_of_issue) values('"+member+"','"+book_id+"','"+date+"')");
		result=preparedStatement1.executeUpdate();

		return result;
		}
	}
		return 0;
	}

	public int deleteMember(String delete_member) throws SQLException {
			initialize();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from customer where username='"+delete_member+"'");
		int rs=preparedStatement.executeUpdate();
		return rs;
	}

	public static int updateMember(Member member) throws SQLException {
		// TODO Auto-generated method stub
		initialize();
		System.out.println(member.getContact());

		PreparedStatement preparedStatement=connection.prepareStatement("update customer set customer_address=? , customer_contact=? ,customer_email=? where username=?");
		preparedStatement.setString(1, member.getMember_address());
		preparedStatement.setString(2, member.getContact());
		preparedStatement.setString(3, member.getEmail());
		preparedStatement.setString(4, member.getUsername());
		int rs=preparedStatement.executeUpdate();
		return rs;
	}

	public Member getUpdateMember(String search_member) throws SQLException {
		initialize();
		Statement statement=connection.createStatement();
		System.out.println("alling query");
		Member member=new Member();
		ResultSet result=statement.executeQuery("select customer_firstname,customer_lastname,customer_address,customer_email,customer_contact,customer_gender from customer where username="+search_member);
		if(result.next()) {
			System.out.println("resultset");
			member.setMember_firstname(result.getString(1));
			member.setMember_lastname(result.getString(2));
			member.setMember_address(result.getString(3));
			member.setContact(result.getString(5));
			
			member.setEmail(result.getString(4));
			member.setGender(result.getString(6));
			return member;
		}
		return null;
	}

	public String getReturnBook(String search_member, int bookid) throws SQLException {
		initialize();
		Statement statement=connection.createStatement();
		System.out.println("alling query");
		ResultSet result=statement.executeQuery("select date_of_issue from  issuebook where customer_name='"+search_member+"' and book_id="+bookid);
		if(result.next()) {
			String issue_date=result.getString(1);
			return issue_date;
		}
		return null;
	}

	public static int returnBook(int bookid, String username, String return_date) throws SQLException {
		initialize();
		System.out.println("alling query");
		PreparedStatement preparedStatement=connection.prepareStatement("update issuebook set return_date='"+return_date+"' where customer_name='"+username+"' and book_id="+bookid);
		PreparedStatement preparedStatement1=connection.prepareStatement("update book set number_of_copies=number_of_copies+1 where book_id="+bookid);
		int result=preparedStatement1.executeUpdate();
		int rs=preparedStatement.executeUpdate();
		return rs;
	}

	public ResultSet reportsForAll() throws SQLException {
		initialize();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select customer.username , customer.customer_firstname, customer.customer_lastname, issuebook.book_id, issuebook.date_of_issue,book.book_name, book.author_name, book.book_type from customer, issuebook, book\r\n" + 
				"where customer.username=issuebook.customer_name and issuebook.return_date is null and issuebook.book_id=book.book_id ");
		return result;
		// TODO Auto-generated method stub
		
	}

	public List<Book> getSubjectBasedReports(String resourceType) throws SQLException {
		List<Book> list = new ArrayList<Book>();
		initialize();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select book_id,book_name,author_name,book_type,number_of_copies from book where book_type='"+resourceType+"'");
		
		while(result.next()) {
			Book book=new Book();
			book.setBookid(result.getInt(1));
			book.setBookname(result.getString(2));
			book.setAuthorname(result.getString(3));
			book.setBook_type(result.getString(4));
			book.setNumber_of_copies(result.getInt(5));
			list.add(book);

		}
		return list;
	}
		
	

	public List<Book> getAvailabilityBasedReports() throws SQLException {
		initialize();
		List<Book> list = new ArrayList<Book>();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select book_id,book_name,author_name,book_type,number_of_copies from book where number_of_copies>0");
		while(result.next()) {
			Book book=new Book();
			book.setBookid(result.getInt(1));
			book.setBookname(result.getString(2));
			book.setAuthorname(result.getString(3));
			book.setBook_type(result.getString(4));
			book.setNumber_of_copies(result.getInt(5));
			list.add(book);

		}
		return list;
	}

	public ResultSet reportsForParticularUser(String username) throws SQLException {
		initialize();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select customer.username , customer.customer_firstname, customer.customer_lastname, issuebook.book_id, issuebook.date_of_issue,book.book_name, book.author_name, book.book_type from customer, issuebook, book\r\n" + 
				"where customer.username=issuebook.customer_name and issuebook.return_date is null and issuebook.book_id=book.book_id and username like '"+username+"%' ");
		return result;
	}
	
} 

