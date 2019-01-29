package logic_manager;
import database_manager.DatabaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddMember() {
        super();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseManager database_manager=new DatabaseManager();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Member member=new Member();
		member.setUsername(request.getParameter("username"));
		member.setMember_firstname(request.getParameter("customer_firstname"));
		member.setMember_lastname(request.getParameter("customer_lastname"));
		member.setMember_address(request.getParameter("customer_address"));
		member.setGender(request.getParameter("customer_gender"));
		member.setEmail(request.getParameter("customer_email"));
		member.setContact(request.getParameter("contact_number"));
		
		try {
		Boolean	result = database_manager.addMember(member);
			if(result)
			{	
				JOptionPane.showMessageDialog(null, "User registered");
				RequestDispatcher rd = 	request.getRequestDispatcher("Main.jsp");
						rd.forward(request,response);
			}else {
				JOptionPane.showMessageDialog(null, "User registered");
				RequestDispatcher rd12 = 	request.getRequestDispatcher("AddMember.jsp");
				rd12.forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("nhi hoenga");
		}
		
	}
}
