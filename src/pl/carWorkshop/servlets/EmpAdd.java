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

@WebServlet("/empAdd")
public class EmpAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/empAdd.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee emp = new Employee();

		emp.setFirstName(request.getParameter("firstName"));
		emp.setLastName(request.getParameter("lastName"));
		emp.setAddress(request.getParameter("address"));
		emp.setNote(request.getParameter("note"));
		emp.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
		emp.setWorkHourCost(Double.parseDouble(request.getParameter("workHourCost")));

		try {
			EmployeeDao.addToDb(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/CarWorkshop/employeePage");
	}

}
