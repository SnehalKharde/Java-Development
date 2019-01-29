package logic_manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String username=request.getParameter("username");
		int bookid=Integer.parseInt(request.getParameter("book_id"));
		String return_date=request.getParameter("return_date");
		
		try {
			
				int result=DatabaseManager.returnBook(bookid,username,return_date);
				 if(result>0) {
						JOptionPane.showMessageDialog(null, "Book returned");
						RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
						rd.forward(request, response);
					}
					else {
						JOptionPane.showMessageDialog(null, "Book not returned");
						RequestDispatcher rd=request.getRequestDispatcher("Return.jsp");
						rd.forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			doGet(request, response);
	}

}
