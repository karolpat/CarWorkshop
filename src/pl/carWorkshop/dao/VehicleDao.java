package pl.carWorkshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.carWorkshop.DbUtil;
import pl.carWorkshop.dao.Employee;
import pl.carWorkshop.dao.Vehicle;

public class VehicleDao {

	private static final String ADD_TO_DB = "insert into vehicle (model, brand, productionYear, registNumber, reviewDate)"
			+ " values(?,?,?,?,?)";
	private static final String UPDATE = "update vehicle set model=?, brand=?, productionYear=?, registNumber=?, reviewDate=? where id=?";
	private static final String READ = "select * from vehicle";
	private static final String READ_BY_ID = "select * from vehicle where id=";
	private static final String DELETE = "delete from vehicle where id=";

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
	 *            - id of a vehicle to be read
	 * @return an instance of Vehicle loaded by given id
	 * @throws SQLException
	 */
	public static Vehicle loadById(int id) throws SQLException {

		Vehicle veh = new Vehicle();

		try (Connection conn = DbUtil.getConn()) {

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ_BY_ID + id);
			while (res.next()) {
				veh.setModel(res.getString("model"));
				veh.setBrand(res.getString("brand"));
				veh.setProductionYear(res.getString("productionYear"));
				veh.setRegistNumber(res.getString("registNumber"));
				veh.setReviewDate(res.getTimestamp("reviewDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		return veh;
	}

	/**
	 * @return An array of all vehicles
	 * @throws SQLException
	 */
	public static Vehicle[] loadAll() throws SQLException {

		List<Vehicle> vehList = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(READ);

			while (res.next()) {

				Vehicle veh = new Vehicle();

				veh.setModel(res.getString("model"));
				veh.setBrand(res.getString("brand"));
				veh.setProductionYear(res.getString("productionYear"));
				veh.setRegistNumber(res.getString("registNumber"));
				veh.setReviewDate(res.getTimestamp("reviewDate"));
	

				vehList.add(veh);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

		Vehicle[] vehArr = new Vehicle[vehList.size()];
		vehList.toArray(vehArr);
		return vehArr;

	}

	/**
	 * Updating parameters of a Vehicle instance, where id is given
	 * 
	 * @param emp
	 *            - an instance of Vehicle to be updated
	 * @param id
	 *            - id of a vehicle to be updated
	 * @return an instance of vehicle updated to db
	 * @throws SQLException
	 */
	public static Vehicle updateToDb(Vehicle veh, int id) throws SQLException {

		try (Connection conn = DbUtil.getConn(); PreparedStatement prep = conn.prepareStatement(UPDATE)) {

			prep.setString(1, veh.getModel());
			prep.setString(2, veh.getBrand());
			prep.setString(3, veh.getProductionYear());
			prep.setString(4, veh.getRegistNumber());
			prep.setTimestamp(5, veh.getReviewDate());
			
			prep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Updataing employee failed");
		}
		return veh;

	}

	/**
	 * @param veh
	 *            - an instance of Vehicle to be added to db
	 * @return an instance of vehicle added to db
	 * @throws SQLException
	 */
	public Vehicle addToDb(Vehicle veh) throws SQLException {

		try (Connection conn = DbUtil.getConn();
				PreparedStatement prep = conn.prepareStatement(ADD_TO_DB, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			prep.setString(1, veh.getModel());
			prep.setString(2, veh.getBrand());
			prep.setString(3, veh.getProductionYear());
			prep.setString(4, veh.getRegistNumber());
			prep.setTimestamp(5, veh.getReviewDate());

			int result = prep.executeUpdate();

			if (result != 1) {
				throw new RuntimeException("ExecuteUpdate returned " + result);

			}

			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					veh.setId(generatedKeys.getInt(1));
					return veh;
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
