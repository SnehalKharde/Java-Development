package logic_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class FilterBasedAvailability
 */
@WebServlet("/FilterBasedAvailability")
public class FilterBasedAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterBasedAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		DatabaseManager databaseManager=new DatabaseManager();
		try {
			List<Book> list=databaseManager.getAvailabilityBasedReports();
			out.println("<table border=1 align=center width=75%>");
			out.println("<tr><td><b>Book ID</td><td><b> Book name </td><td><b>Author Name</td><td><b>Resource type</td><td><b>Number of copies</td><tr>");
			System.out.println(list);
			for(Book book:list) {
				System.out.println("book"+book);
				out.println("<tr><td>"+book.getBookid()+"</td>");
				out.println("<td>"+book.getBookname()+"</td>");
				out.println("<td>"+book.getAuthorname()+"</td>");
				out.println("<td>"+book.getBook_type()+"</td>");
				out.println("<td>"+book.getNumber_of_copies()+"</td></tr>");
			}
			out.println("</table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
