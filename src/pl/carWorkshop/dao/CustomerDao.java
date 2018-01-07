package pl.carWorkshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.carWorkshop.DbUtil;

public class CustomerDao {

	
	private static final String ADD_TO_DB = "insert into customer (firstName, lastName, birthDate) values(?,?,?)";
	private static final String UPDATE = "update customer set firstName=?, lastName=?, birthDate=? where id=?";
	private static final String READ = "select * from customer";
	private static final String READ_BY_ID = "select * from customer where id=";
	private static final String DELETE = "delete from customer where id=";
	
	
	
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
			System.out.println("Deleting customer failed");
		}
	}

	/**
	 * @param id- id of an customer to be read
	 * @return an instance of Customer loaded by given id
	 * @throws SQLException
	 */
	public static Customer loadById(int id) throws SQLException {

		Customer cus = new Customer();

		try (Connection conn = DbUtil.getConn()) {

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ_BY_ID + id);
			while (res.next()) {
				cus.setFirstName(res.getString("firstName"));
				cus.setLastName(res.getString("lastName"));
				cus.setBirthDate(res.getTimestamp("birthDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		return cus;
	}

	/**
	 * @return An array of all customers
	 * @throws SQLException
	 */
	public static Customer[] loadAll() throws SQLException {

		List<Customer> cusList = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ);

			while (res.next()) {

				Customer cus = new Customer();

				cus.setId(res.getInt("id"));
				cus.setFirstName(res.getString("firstName"));
				cus.setLastName(res.getString("lastName"));
				cus.setBirthDate(res.getTimestamp("birthDate"));

				cusList.add(cus);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		Customer[] cusArr = new Customer[cusList.size()];
		cusList.toArray(cusArr);
		return cusArr;

	}

	/**
	 * Updating parameters of an Customer instance, where id is given
	 * 
	 * @param cus
	 *            - an instance of Customer to be updated
	 * @param id
	 *            - id of an customer to be updated
	 * @return an instance of customer updated to db
	 * @throws SQLException
	 */
	public static Customer updateToDb(Customer cus, int id) throws SQLException {

		try (Connection conn = DbUtil.getConn(); 
				PreparedStatement prep = conn.prepareStatement(UPDATE)) {

			prep.setString(1, cus.getFirstName());
			prep.setString(2, cus.getLastName());
			prep.setTimestamp(3, cus.getBirthDate());


			prep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Updataing employee failed");
		}
		return cus;

	}

	/**
	 * @param cus
	 *            - an instance of Customer to be added to db
	 * @return an instance of customer added to db
	 * @throws SQLException
	 */
	public Customer addToDb(Customer cus) throws SQLException {

		try (Connection conn = DbUtil.getConn();
				PreparedStatement prep = conn.prepareStatement(ADD_TO_DB, PreparedStatement.RETURN_GENERATED_KEYS)) {
			prep.setString(1, cus.getFirstName());
			prep.setString(2, cus.getLastName());
			prep.setTimestamp(3, cus.getBirthDate());

			int result = prep.executeUpdate();

			if (result != 1) {
				throw new RuntimeException("ExecuteUpdate returned " + result);

			}

			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					cus.setId(generatedKeys.getInt(1));
					return cus;
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
