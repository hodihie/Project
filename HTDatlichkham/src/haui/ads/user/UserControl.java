/**
 * 
 */
package haui.ads.user;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class UserControl {
	private UserModel um;

	/**
	 * 
	 */
	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	protected void finalize() throws Throwable {
		this.um = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.um.getConnectionPool();
	}

	public void releaseConnection() {
		this.um.releaseConnection();
	}

	// *************************************/
	public boolean addUser(UserObject item) {
		return this.um.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.um.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.um.delUser(item);
	}

	// **********************************************/
	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}

	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}

	// ***********************************************/
	public String viewUsers(UserObject similar, int page, byte total, UserObject user) {
		ArrayList items = this.um.getUserObjects(similar, page, total);
		return UserLibrary.viewUsers(items,user);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		// tao doi tuong thuc thi chuc nang
		UserControl uc = new UserControl(cp);
		// lay du lieu html hien thi
		//String viewusers = uc.viewUsers(null, 1, (byte)15);
		// tra ve ket noi
		uc.releaseConnection();
		// hien thi
		//System.out.println(viewusers);
	}
}
