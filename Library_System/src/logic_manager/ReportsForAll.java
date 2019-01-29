package logic_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class ReportsForAll
 */
@WebServlet("/ReportsForAll")
public class ReportsForAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportsForAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		DatabaseManager databaseManager=new DatabaseManager();
		try {
			//JSONArray jsonArray = new JSONArray();
			ResultSet result= databaseManager.reportsForAll();
			out.println("<table border=1 align=center width=75%>");
			out.println("<b><tr><td><b>Username</td><td><b> Full name </td><td><b>Bookname</td><td><b>Author name</td><td><b>Resource type</td><td><b>Date of issue</td><tr></b>");
			while(result.next()) {
				Member member=new Member();
				Book book=new Book();
				member.setUsername(result.getString(1));
				member.setMember_firstname(result.getString(2));
				member.setMember_lastname(result.getString(3));
				book.setBookname(result.getString(6));
				book.setAuthorname(result.getString(7));
				int bookid=result.getInt(4);
				String date_of_issue=result.getString(5);
				String resource_type=result.getString(8);
				
					//JSONObject object = new JSONObject();
					
						out.print("<tr><td>"+member.getUsername());
						out.println("</td><td>"+member.getMember_firstname()+"  "+member.getMember_lastname());
						//out.println("member_lastname"+member.getMember_lastname());
						//out.println("</td><td>"+bookid);
						
						out.println("</td><td>"+book.getBookname());
						out.println("</td><td>"+book.getAuthorname());
						out.println("</td><td>"+resource_type);
						out.println("</td><td>"+date_of_issue+"</td></tr>");
					// out.print(object.toString());
					//jsonArray.put(object);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
