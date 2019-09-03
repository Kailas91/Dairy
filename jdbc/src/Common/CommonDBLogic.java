package Common;
/**
 * this is used to get connection info from property file
 *
 * @author Kailas
 * Date : 23/7/2019
 */
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CommonDBLogic {
	Connection objconnection = null;
	Statement objstatement = null;
	ResourceBundle rb = null;


	/**
	 * It is used to Read properties file and connect to database
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public Connection connect(String className,String dbURL) throws ClassNotFoundException, SQLException, IOException {

		try {


			Class.forName(className);
			objconnection = DriverManager.getConnection(dbURL);

			if (objconnection != null) {
				System.out.println("Connected To DataBase");
			}
			return objconnection;

		} finally {

			className = null;

		}
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