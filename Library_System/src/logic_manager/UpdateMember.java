package logic_manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UpdateMember")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member=new Member();
		member.setUsername(request.getParameter("username"));
		member.setMember_address(request.getParameter("customer_address"));
		member.setEmail(request.getParameter("customer_email"));
		member.setContact(request.getParameter("contact_number"));
   int result;
try {
	result = DatabaseManager.updateMember(member);

   if(result>0) {
		JOptionPane.showMessageDialog(null, "Member is updated");
		RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
		rd.forward(request, response);
	}
	else {
		JOptionPane.showMessageDialog(null, "Member can't updated");
		RequestDispatcher rd=request.getRequestDispatcher("UpdateMember.jsp");
		rd.forward(request, response);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   }
   
	}
