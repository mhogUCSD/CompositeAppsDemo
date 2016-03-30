package controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.Connection;
import dbconnection.DBConnection;
import dbconnection.JDBCConnection;
import employee.Employee;
import employee.EmployeeFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = new DBConnection(new JDBCConnection());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url = "/index.jsp";
		RequestDispatcher dispatcher = null;

		// if login succeeds, go to employees page
		if(con.connect(username, password)){
			HttpSession session = request.getSession();
			session.setAttribute("connection", con);
			url = "/EmployeeServlet";
		}else{
			//login = "Failed to log in.";
		}
		
		// else 
		request.getRequestDispatcher(url).forward(request, response);
	}

}
