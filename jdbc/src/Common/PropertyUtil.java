package Common;

/**
 * @description : this class are  used to get properties file data and create sql connection
 * @author Kailas
 * Date : 2019/7/22
 *
 ***/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PropertyUtil {
	Connection objconnection = null;
	Statement objstatement = null;
	ResourceBundle rb = null;
	String className = null;
	String dbname = null;
	String url = null;
	String uname = null;
	String pass = null;

	// to read data from properties file
	public void readProperty() {
		try {

			rb = ResourceBundle.getBundle("com.uks.jdbc.Day1.ass3.settings");
			className = rb.getString("database.driverClass");
			dbname = rb.getString("database.name");
			url = rb.getString("database.url");
			uname = rb.getString("database.username");
			pass = rb.getString("database.password");
		} catch (Exception e) {
			System.out.println("properties file path not correct");
		}

	}
	// make connection using properties data
	public Connection connectToDatabse() {
		try {
			// Register JDBC driver
			Class.forName(className);
			// JDBC driver name and database URL to get connection
			objconnection = DriverManager.getConnection(url + dbname, uname, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException in connects");

		} catch (SQLException e) {
			System.out.println("SQLException in connects");
		}
		System.out.println("Connected to database");
		return objconnection;
	}

	/**
	 * It is used to disconnect from database
	 *
	 * @param connection
	 * @throws SQLException
	 */
	public void disconnect() {

		try {
			if (objstatement != null) {
				objstatement.close();
			}
			if (objstatement != null) {
				objconnection.close();
			}
			System.out.println("Closing connection");

		} catch (SQLException objSQLException) {
			System.out.println("SQL exceution ocuured");
			objSQLException.printStackTrace();
		}
	}


}
