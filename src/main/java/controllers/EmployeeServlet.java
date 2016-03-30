package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.*;
import employee.*;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String query = "SELECT * FROM employees";
		String url = "/employees.jsp";
	
		HttpSession session = request.getSession();
		Connection con = (Connection)request.getSession().getAttribute("connection");
		
		EmployeeFactory ef = new EmployeeFactory();
		

		// TODO: refractor EmployeeFactory to just build a single model - SRP
		Map<Integer, Employee> employees = ef.employeeRsToHash(con.query(query));
		request.setAttribute("employees", employees);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
