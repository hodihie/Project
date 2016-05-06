/**
 * 
 */
package haui.ads.user;

import java.util.ArrayList;

import haui.ConnectionPool;
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
	public String viewUsers(UserObject similar, int page, UserObject user, byte totalperpage) {
		ArrayList items = this.um.getUserObjects(similar, page, totalperpage);
		int total = this.um.getCount();
		return UserLibrary.viewUsers(items, user, total, page, totalperpage);
	}
}
