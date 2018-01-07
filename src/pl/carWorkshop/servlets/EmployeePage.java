package pl.carWorkshop.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.carWorkshop.dao.Employee;
import pl.carWorkshop.dao.EmployeeDao;


@WebServlet("/employeePage")
public class EmployeePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Employee[] empArr = EmployeeDao.loadAll();
			request.setAttribute("employees", empArr);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/EmployeePage.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		int execute = Integer.parseInt(request.getParameter("do"));
//		int who = Integer.parseInt(request.getParameter("who"));
//		Employee emp = new Employee();
//		
//		try {
//			emp = EmployeeDao.loadById(who);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if (execute==1) {
//			request.setAttribute("emp", emp);
//			getServletContext().getRequestDispatcher("/empEdit.jsp").forward(request, response);
//		}
	}

}
