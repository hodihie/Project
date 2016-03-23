/**
 * 
 */
package haui;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dinh Hieu
 *
 */
public interface ConnectionPool {
	// cung cap ket noi
	public Connection getconnection(String objectName) throws SQLException;

	// yeu cau tra ve ket noi
	public void releaseConnection(Connection con, String objectName) throws SQLException;
}
