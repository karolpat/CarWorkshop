package pl.carWorkshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.carWorkshop.DbUtil;

public class EmployeeDao {

	private static final String ADD_TO_DB = "insert into employee (firstName, lastName, address, phoneNumber, note, workHourCost)"
			+ " values(?,?,?,?,?,?)";
	private static final String UPDATE = "update employee set firstName=?, lastName=?, address=?, phoneNumber=?, note=?, workHourCost=? where id=?";
	private static final String READ = "select * from employee";
	private static final String READ_BY_ID = "select * from employee where id=";
	private static final String DELETE = "delete from employee where id=";

	public static void delete(int id) throws SQLException {

		try (Connection conn = DbUtil.getConn()) {

			Statement st = conn.createStatement();
			st.executeUpdate(DELETE+id);
//			ResultSet res = st.executeQuery(DELETE + id);
//			while(res.next()) {
//				
//			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deleting employee failed");
		}
	}

	/**
	 * @param id
	 *            - id of an employee to be read
	 * @return an instance of Employee loaded by given id
	 * @throws SQLException
	 */
	public static Employee loadById(int id) throws SQLException {

		Employee emp = new Employee();

		try (Connection conn = DbUtil.getConn()) {

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ_BY_ID + id);
			while (res.next()) {
				emp.setFirstName(res.getString("firstName"));
				emp.setLastName(res.getString("lastName"));
				emp.setAddress(res.getString("address"));
				emp.setNote(res.getString("note"));
				emp.setPhoneNumber(res.getInt("phoneNumber"));
				emp.setWorkHourCost(res.getDouble("workHourCost"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		return emp;
	}

	/**
	 * @return An array of all employees
	 * @throws SQLException
	 */
	public static Employee[] loadAll() throws SQLException {

		List<Employee> empList = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ);

			while (res.next()) {

				Employee emp = new Employee();

				emp.setId(res.getInt("id"));
				emp.setFirstName(res.getString("firstName"));
				emp.setLastName(res.getString("lastName"));
				emp.setAddress(res.getString("address"));
				emp.setNote(res.getString("note"));
				emp.setPhoneNumber(res.getInt("phoneNumber"));
				emp.setWorkHourCost(res.getDouble("workHourCost"));

				empList.add(emp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		Employee[] empArr = new Employee[empList.size()];
		empList.toArray(empArr);
		return empArr;

	}

	/**
	 * Updating parameters of an Employee instance, where id is given
	 * 
	 * @param emp
	 *            - an instance of Employee to be updated
	 * @param id
	 *            - id of an employee to be updated
	 * @return an instance of employee updated to db
	 * @throws SQLException
	 */
	public static Employee updateToDb(Employee emp, int id) throws SQLException {

		try (Connection conn = DbUtil.getConn(); PreparedStatement prep = conn.prepareStatement(UPDATE)) {

			prep.setString(1, emp.getFirstName());
			prep.setString(2, emp.getLastName());
			prep.setString(3, emp.getAddress());
			prep.setInt(4, emp.getPhoneNumber());
			prep.setString(5, emp.getNote());
			prep.setDouble(6, emp.getWorkHourCost());
			prep.setInt(7, id);

			prep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Updataing employee failed");
		}
		return emp;

	}

	/**
	 * @param emp
	 *            - an instance of Employee to be added to db
	 * @return an instance of employee added to db
	 * @throws SQLException
	 */
	public static Employee addToDb(Employee emp) throws SQLException {

		try (Connection conn = DbUtil.getConn();
				PreparedStatement prep = conn.prepareStatement(ADD_TO_DB, PreparedStatement.RETURN_GENERATED_KEYS)) {
			prep.setString(1, emp.getFirstName());
			prep.setString(2, emp.getLastName());
			prep.setString(3, emp.getAddress());
			prep.setInt(4, emp.getPhoneNumber());
			prep.setString(5, emp.getNote());
			prep.setDouble(6, emp.getWorkHourCost());

			int result = prep.executeUpdate();

			if (result != 1) {
				throw new RuntimeException("ExecuteUpdate returned " + result);

			}

			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					emp.setId(generatedKeys.getInt(1));
					return emp;
				} else {
					throw new RuntimeException("Genereted key was not found");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		return null;
	}

}
