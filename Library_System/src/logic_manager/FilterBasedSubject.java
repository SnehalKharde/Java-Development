package logic_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class FilterBasedSubject
 */
@WebServlet("/FilterBasedSubject")
public class FilterBasedSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilterBasedSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject=request.getParameter("subject");
		PrintWriter out=response.getWriter();
		DatabaseManager databaseManager=new DatabaseManager();
		try {
			List<Book> list=databaseManager.getSubjectBasedReports(subject);
			out.println("<table border=1 align=center width=100% style:>");
			out.println("<tr><td><b>Book ID</td><td><b> Book name </td><td><b>Author Name</td><td><b>Resource type</td><td><b>Number of copies</td><tr>");
			System.out.println(list);
			for(Book book:list) {
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
