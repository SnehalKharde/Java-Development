package logic_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class Details_Return_Book
 */
@WebServlet("/Details_Return_Book")
public class Details_Return_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_Return_Book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		DatabaseManager database_manager = new DatabaseManager();
		
		String search_member=request.getParameter("search_name");
		int bookid=Integer.parseInt(request.getParameter("search_bookid"));
		System.out.println("calling database");
		String issue_date;
		try {
			issue_date = database_manager.getReturnBook(search_member,bookid);
		if(issue_date!=null) {
				JSONObject object = new JSONObject();
				try {
					object.put("issue_date", issue_date);
				 out.println(object.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(issue_date);
		}
		else {
			JOptionPane.showMessageDialog(null, "User does'nt exist");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
