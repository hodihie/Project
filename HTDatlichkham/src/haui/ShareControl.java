/**
 * 
 */
package haui;

/**
 * @author Dinh Hieu
 *
 */
public interface ShareControl {
	// chia se bo quanly ket noi giua cac doi tuong basic voi nhau
	public ConnectionPool getConnectionPool();

	// yeu cau cac doi tuong su dung ket noi phai tra lai ket noi
	public void releaseConnection();
}
