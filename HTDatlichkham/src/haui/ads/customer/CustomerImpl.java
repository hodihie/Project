/**
 * 
 */
package haui.ads.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
import haui.objects.CustomerObject;

/**
 * @author Dinh Hieu
 *
 */
public class CustomerImpl extends BasicImpl implements Customer {

	/**
	 * @param cp
	 * @param objectName
	 */
	public CustomerImpl(ConnectionPool cp) {
		super(cp, "Customer");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.customer.Customer#addCustomer(haui.objects.CustomerObject)
	 */
	@Override
	public int addCustomer(CustomerObject item) {

		String sql = "INSERT INTO tblcustomer(customer_fullname,customer_gender, customer_address, ";
		sql += "customer_phone, customer_email, ";
		sql += "customer_birthday,customer_code) ";
		sql += " VALUE(?,?,?,?,?,?,?) ";

		int generatedKey = 0;
		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Truyen gia tri
			pre.setString(1, item.getCustomer_fullname());
			pre.setShort(2, item.getCustomer_gender());
			pre.setString(3, item.getCustomer_address());
			pre.setString(4, item.getCustomer_phone());
			pre.setString(5, item.getCustomer_email());
			pre.setString(6, item.getCustomer_birthday());
			pre.setString(7, item.getCustomer_code());

			this.add(pre);
			ResultSet rs = pre.getGeneratedKeys();

			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.customer.Customer#editCustomer(haui.objects.CustomerObject)
	 */
	@Override
	public boolean editCustomer(CustomerObject item) {
		String sql = "UPDATE tblcustomer SET customer_fullname=?,customer_gender=?, customer_address=?, ";
		sql += "customer_phone=?, customer_email=?, ";
		sql += "customer_birthday=?,customer_code=? ";
		sql += " WHERE customer_id=? ";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyen gia tri
			pre.setString(1, item.getCustomer_fullname());
			pre.setShort(2, item.getCustomer_gender());
			pre.setString(3, item.getCustomer_address());
			pre.setString(4, item.getCustomer_phone());
			pre.setString(5, item.getCustomer_email());
			pre.setString(6, item.getCustomer_birthday());
			pre.setString(7, item.getCustomer_code());

			pre.setInt(8, item.getCustomer_id());

			return this.edit(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.customer.Customer#delCustomer()
	 */
	@Override
	public boolean delCustomer(CustomerObject item) {
		// kiem tra su lien quan
		if (this.checkForDel(item)) {
			return false;
		}

		String sql = "DELETE FROM tblcustomer WHERE customer_id=?";

		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getCustomer_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// kiem tra xem bai bao nao lien quan den customer ko, neu con thi ko xoa dc
	private boolean checkForDel(CustomerObject item) {
		boolean flag = false;

		String sql = "SELECT apointment_id FROM tblapointment ";
		sql += "WHERE apointment_customer_id=" + item.getCustomer_id();

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
	 * @see haui.ads.customer.Customer#getCustomer(int)
	 */
	@Override
	public ResultSet getCustomer(int id) {
		String sql = "SELECT * FROM tblcustomer WHERE customer_id=?";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.customer.Customer#getCustomers(haui.objects.CustomerObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getCustomers(CustomerObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblcustomer ";
		sql += " ORDER BY customer_fullname ASC ";

		return this.gets(sql);
	}

	// test
	// public static void main(String[] args) {
	// ConnectionPool cp = new ConnectionPoolImpl();
	// Customer u = new CustomerImpl(cp);
	//
	// ResultSet rs = u.getCustomers(null);
	// u.releaseConnection();
	//
	// try {
	// while (rs.next()) {
	// System.out.print(rs.getInt("customer_id") + "\t");
	// System.out.print(rs.getString("customer_fullname") + "\t");
	// System.out.println(rs.getString("customer_email") + "\t");
	//
	// }
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// }
	// }

}
