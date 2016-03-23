/**
 * 
 */
package haui.ads.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.*;
import haui.ads.basic.BasicImpl;
import haui.objects.UserObject;
import sql.ads.MakeConditions;

/**
 * @author Dinh Hieu
 *
 */
public class UserImpl extends BasicImpl implements User {

	/**
	 * @param cp
	 * @param objectName
	 */
	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#addUser(haui.objects.UserObject)
	 */
	@Override
	public boolean addUser(UserObject item) {
		// Kiem tra su rang buoc duy nhat
		if (this.isExist(item)) {
			return false;
		}

		String sql = "INSERT INTO tbluser(user_name, user_pass, ";
		sql += "user_fullname, user_birthday, user_mobilephone, ";
		sql += "user_homephone, user_officephone, ";
		sql += "user_email, user_address, user_jobarea, ";
		sql += "user_job, user_position, user_applyyear, ";
		sql += "user_permission, user_notes, ";
		sql += "user_roles,user_logined) ";
		sql += "VALUE(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyen gia tri
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setInt(17, item.getUser_logined());

			return this.add(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isExist(UserObject item) {
		boolean flag = false;

		String sql = "SELECT user_id FROM tbluser ";
		sql += "WHERE user_name='" + item.getUser_name() + "' ";

		ResultSet rs = this.get(sql, 0);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#editUser(haui.objects.UserObject)
	 */
	@Override
	public boolean editUser(UserObject item) {
		String sql = "UPDATE tbluser SET user_pass=md5(?), ";
		sql += "user_fullname=?, user_birthday=?, user_mobilephone=?, ";
		sql += "user_homephone=?, user_officephone=?, ";
		sql += "user_email=?, user_address=?, user_jobarea=?, ";
		sql += "user_job=?, user_position=?, user_applyyear=?, ";
		sql += "user_permission=?, user_notes=?, ";
		sql += "user_roles=? ";
		sql += "WHERE user_id=?";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// truyen gia tri
			pre.setString(1, item.getUser_pass());
			pre.setString(2, item.getUser_fullname());
			pre.setString(3, item.getUser_birthday());
			pre.setString(4, item.getUser_mobilephone());
			pre.setString(5, item.getUser_homephone());
			pre.setString(6, item.getUser_officephone());
			pre.setString(7, item.getUser_email());
			pre.setString(8, item.getUser_address());
			pre.setString(9, item.getUser_jobarea());
			pre.setString(10, item.getUser_job());
			pre.setString(11, item.getUser_position());
			pre.setShort(12, item.getUser_applyyear());
			pre.setByte(13, item.getUser_permission());
			pre.setString(14, item.getUser_notes());
			pre.setString(15, item.getUser_roles());

			pre.setInt(16, item.getUser_id());

			return this.edit(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#delUser()
	 */
	@Override
	public boolean delUser(UserObject item) {
		// kiem tra su lien quan
		if (this.checkForDel(item)) {
			return false;
		}

		String sql = "DELETE FROM tbluser WHERE user_id=?";

		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getUser_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// kiem tra xem bai bao nao lien quan den user ko, neu con thi ko xoa dc
	private boolean checkForDel(UserObject item) {
		boolean flag = false;

		String sql = "SELECT article_id FROM tblarticle ";
		sql += "WHERE article_created_author_id=" + item.getUser_id();

		ResultSet rs = this.get(sql, 0);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#getUser(int)
	 */
	@Override
	public ResultSet getUser(int id) {
		String sql = "SELECT * FROM tbluser WHERE user_id=?";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultSet getUser(String username, String userpass) {
		String sql = "SELECT * FROM tbluser WHERE ";
		sql += "(user_name=? AND (user_pass=md5(?))) ";
		return this.get(sql, username, userpass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.user.User#getUsers(haui.objects.UserObject, int, byte)
	 */
	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
		String sql = "SELECT * FROM tbluser ";

		// ko hien thi user co quyen cao hon user dang dang nhap
		String conds = MakeConditions.createCondition(similar);
		if (!conds.equalsIgnoreCase("")) {
			sql += " WHERE " + conds + " ";
		}

		sql += " ORDER BY user_name ASC ";
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		User u = new UserImpl(cp);

		ResultSet rs = u.getUsers(null, 0, (byte) 15);
		u.releaseConnection();

		try {
			while (rs.next()) {
				System.out.print(rs.getInt("user_id") + "\t");
				System.out.print(rs.getString("user_name") + "\t");
				System.out.print(rs.getString("user_pass") + "\t");
				System.out.print(rs.getString("user_fullname") + "\t");
				System.out.println(rs.getString("user_email") + "\t");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
