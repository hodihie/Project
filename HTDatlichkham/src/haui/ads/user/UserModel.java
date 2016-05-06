/**
 * 
 */
package haui.ads.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.library.Utilities;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class UserModel {
	private User u;
	private int total = 0;

	/**
	 * 
	 */
	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.u = null;
		super.finalize();
	}

	// chia se bo quan ly ket noi
	public ConnectionPool getConnectionPool() {
		return this.u.getConnectionPool();
	}

	// tra ve ket noi
	public void releaseConnection() {
		this.u.releaseConnection();
	}

	// ************************************************************/
	public boolean addUser(UserObject item) {
		return this.u.addUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.u.editUser(item);
	}

	// ***************************************************/

	public int getCount() {
		return this.total;
	}

	// chuyen the tu ResultSet thanh doi tuong
	public UserObject getUserObject(int id) {
		UserObject item = null;

		// lay du lieu
		ResultSet rs = this.u.getUser(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_birthday(rs.getString("user_birthday"));

				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;

		// lay du lieu
		ResultSet rs = this.u.getUser(username, userpass);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject(); // khoi tao bo nho luu tru
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_birthday(rs.getString("user_birthday"));
					// can dung bao nhieu lay bay nhieu
					item.setUser_permission(rs.getByte("user_permission"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList getUserObjects(UserObject similar, int page, byte totalperpage) {
		ArrayList items = new ArrayList<>();
		UserObject item = null;

		// lay du lieu
		int at = (page - 1) * totalperpage;
		ResultSet[] rses = this.u.getUsers(similar, at, totalperpage);

		ResultSet rs = null;
		ResultSet rstotal = null;
		if (rses != null) {
			rs = rses[0];
			rstotal = rses[1];
		}
		this.total = Utilities.getCount(rstotal);

		if (rs != null) {
			try {
				while (rs.next()) {
					item = new UserObject(); // khoi tao bo nho luu tru
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_birthday(rs.getString("user_birthday"));
					// can dung bao nhieu lay bay nhieu

					items.add(item); // Dua vao danh sach
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return items;
	}

}
