/**
 * 
 */
package haui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

/**
 * @author Dinh Hieu
 *
 */
public class ConnectionPoolImpl implements ConnectionPool {

	// object's properties
	// tai khoan truy cap
	private String username;
	private String userpass;

	// trinh dieu khien
	private String driver;

	// duong dan cua csdl
	private String url;

	// doi tuong luu tru cac ket noi
	private Stack pool;

	/**
	 * 
	 */
	public ConnectionPoolImpl() {
		// xac dinh tai khoan truy cap
		this.username = "root";
		this.userpass = "123456";
//		this.username = "datlichk_hieu";
//		this.userpass = "123456h";

		// xac dinh trinh dieu khien
		this.driver = "com.mysql.jdbc.Driver";

		// nap trinh dieu khien
		this.loadDriver();

		// xac dinh duong dan
		this.url = "jdbc:mysql://localhost:3306/htdatlichkham_data";
		//this.url = "jdbc:mysql://localhost:3306/datlichk_data";
		//this.url = "jdbc:mysql://node29286-datlichkham.jelastic.skali.net/htdatlichkham_data";

		// khoi tao doi tuong luu tru ket noi
		this.pool = new Stack<>();
	}

	private void loadDriver() {
		try {
			Class.forName(this.driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * getConnection
	 * 
	 * @param objectName String
	 * 
	 * @return Connection
	 * 
	 * @throws SQLException
	 * 
	 */
	@Override
	public Connection getconnection(String objectName) throws SQLException {
		if (this.pool.isEmpty()) {
			System.out.println(objectName + " had created a new connection");
			return DriverManager.getConnection(this.url, this.username, this.userpass);
		} else {
			System.out.println(objectName + " had poped the Connection.");
			return (Connection) this.pool.pop();
		}
	}

	/*
	 * releaseConnection
	 * 
	 * @param con Connection
	 * 
	 * @param objectName String
	 * 
	 * @throws SQLExeption
	 * 
	 */
	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		System.out.println(objectName + " had push the Connection.");
		this.pool.push(con);
	}

	protected void finalize() throws Throwable {
		this.username = null;
		this.userpass = null;
		this.driver = null;
		this.url = null;

		this.pool.clear();
		this.pool = null;
		super.finalize();
		System.runFinalization();
		System.out.println("Connection Pool is closed.");

	}

}
