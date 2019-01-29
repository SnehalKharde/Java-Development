package logic_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class Details_Update_user
 */
@WebServlet("/Details_Update_user")
public class Details_Update_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_Update_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		DatabaseManager database_manager = new DatabaseManager();
		String search_member=request.getParameter("search_member");
		System.out.println("calling database");
		Member member;
		try {
			member = database_manager.getUpdateMember(search_member);
		if(member!=null) {
				JSONObject object = new JSONObject();
				try {
					object.put("member_firstname", member.getMember_firstname());
					object.put("member_lastname", member.getMember_lastname());
					object.put("member_address",member.getMember_address());
					object.put("contact",member.getContact());
					object.put("email",member.getEmail());
					object.put("gender", member.getGender());
				 out.println(object.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			System.out.println("member details"+member.getMember_address()+member.getEmail()+member.getContact());
		}
		else {
			JOptionPane.showMessageDialog(null, "User didnt exist");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
