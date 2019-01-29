package logic_manager;
import database_manager.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: hell ").append(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
			  int book_id = Integer.parseInt(request.getParameter("book_id"));
	String username=request.getParameter("username");
	String date =request.getParameter("date_of_issue");
	try {
	int result = 1;
	
		result=DatabaseManager.issueBook(book_id,username,date);
		 if(result>0) {
				JOptionPane.showMessageDialog(null, "Book is issued");
				RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
				rd.forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "Book can't issued");
				RequestDispatcher rd=request.getRequestDispatcher("IssueBook.jsp");
				rd.forward(request, response);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	doGet(request, response);
	}
}
