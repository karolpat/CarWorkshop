package pl.carWorkshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.carWorkshop.DbUtil;

public class OrdersDao {

	
	private static final String ADD_TO_DB = "insert into (orderDate, plannedStartDate, startDate, employee_id, problemDesc, fixDesc, status_id, car_id, fixCost, partsCost)"
			+ " values(?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "update orders set orderDate=?, plannedStartDate=?, startDate=?, employee_id=?, problemDesc=?, car_id=?, fixCost=?, partsCost=? where id=?";
	private static final String READ = "select * from orders";
	private static final String READ_BY_ID = "select * from orders where id=";
	private static final String DELETE = "delete from orders where id=";

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
	 *            - id of an order to be read
	 * @return an instance of Order loaded by given id
	 * @throws SQLException
	 */
	public static Orders loadById(int id) throws SQLException {

		Orders ord = new Orders();

		try (Connection conn = DbUtil.getConn()) {

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ_BY_ID + id);
			while (res.next()) {
				ord.setOrderDate(res.getTimestamp("orderDate"));
				ord.setPlannedStartDate(res.getTimestamp("plannedStartDate"));
				ord.setStartDate(res.getTimestamp("startDate"));
				ord.setEmployee_id(res.getInt("employee_id"));
				ord.setProblemDesc(res.getString("problemDesc"));
				ord.setFixDesc(res.getString("fixDesc"));
				ord.setStatus_id(res.getInt("status_id"));
				ord.setCar_id(res.getInt("car_id"));
				ord.setFixCost(res.getDouble("fixCost"));
				ord.setPartsCost(res.getDouble("partsCost"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		return ord;
	}

	/**
	 * @return An array of all orders
	 * @throws SQLException
	 */
	public static Orders[] loadAll() throws SQLException {

		List<Orders> ordList = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ);

			while (res.next()) {

				Orders ord = new Orders();

				ord.setId(res.getInt("id"));
				ord.setOrderDate(res.getTimestamp("orderDate"));
				ord.setPlannedStartDate(res.getTimestamp("plannedStartDate"));
				ord.setStartDate(res.getTimestamp("startDate"));
				ord.setEmployee_id(res.getInt("employee_id"));
				ord.setProblemDesc(res.getString("problemDesc"));
				ord.setFixDesc(res.getString("fixDesc"));
				ord.setStatus_id(res.getInt("status_id"));
				ord.setCar_id(res.getInt("car_id"));
				ord.setFixCost(res.getDouble("fixCost"));
				ord.setPartsCost(res.getDouble("partsCost"));

				ordList.add(ord);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		Orders[] empArr = new Orders[ordList.size()];
		ordList.toArray(empArr);
		return empArr;

	}

	/**
	 * Updating parameters of an Orders instance, where id is given
	 * 
	 * @param ord
	 *            - an instance of Orders to be updated
	 * @param id
	 *            - id of an order to be updated
	 * @return an instance of Orders updated to db
	 * @throws SQLException
	 */
	public static Orders updateToDb(Orders ord, int id) throws SQLException {

		try (Connection conn = DbUtil.getConn(); PreparedStatement prep = conn.prepareStatement(UPDATE)) {

			prep.setTimestamp(1, ord.getOrderDate());
			prep.setTimestamp(2, ord.getPlannedStartDate());
			prep.setTimestamp(3, ord.getStartDate());
			prep.setInt(4, ord.getEmployee_id());
			prep.setString(5, ord.getProblemDesc());
			prep.setString(6, ord.getFixDesc());
			prep.setInt(7, ord.getStatus_id());
			prep.setInt(8, ord.getCar_id());
			prep.setDouble(9, ord.getFixCost());
			prep.setDouble(10, ord.getPartsCost());

			prep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Updataing employee failed");
		}
		return ord;

	}

	/**
	 * @param ord
	 *            - an instance of Orders to be added to db
	 * @return an instance of orders added to db
	 * @throws SQLException
	 */
	public Orders addToDb(Orders ord) throws SQLException {

		try (Connection conn = DbUtil.getConn();
				PreparedStatement prep = conn.prepareStatement(ADD_TO_DB, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			prep.setTimestamp(1, ord.getOrderDate());
			prep.setTimestamp(2, ord.getPlannedStartDate());
			prep.setTimestamp(3, ord.getStartDate());
			prep.setInt(4, ord.getEmployee_id());
			prep.setString(5, ord.getProblemDesc());
			prep.setString(6, ord.getFixDesc());
			prep.setInt(7, ord.getStatus_id());
			prep.setInt(8, ord.getCar_id());
			prep.setDouble(9, ord.getFixCost());
			prep.setDouble(10, ord.getPartsCost());

			int result = prep.executeUpdate();

			if (result != 1) {
				throw new RuntimeException("ExecuteUpdate returned " + result);

			}

			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					ord.setId(generatedKeys.getInt(1));
					return ord;
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
