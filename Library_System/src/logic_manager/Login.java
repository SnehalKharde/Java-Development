package logic_manager;
import database_manager.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_manager.DatabaseManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Boolean result=true;
		try {
			result = DatabaseManager.Login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("error in database connectivity");
		}
		
		if(result)
		{	
			 RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");  
			 rd.forward(request, response);  
		}
		else
		{
			 System.out.print("Username and password mismatch");
			 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			 rd.forward(request, response); 
			
			
		}
	}

}
