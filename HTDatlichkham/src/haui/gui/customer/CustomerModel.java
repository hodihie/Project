/**
 * 
 */
package haui.gui.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.objects.CustomerObject;

/**
 * @author Dinh Hieu
 *
 */
public class CustomerModel {
	private Customer c;

	/**
	 * 
	 */
	public CustomerModel(ConnectionPool cp) {
		this.c = new CustomerImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.c = null;
		super.finalize();
	}

	// chia se bo quan ly ket noi
	public ConnectionPool getConnectionPool() {
		return this.c.getConnectionPool();
	}

	// tra ve ket noi
	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// ************************************************************/
	public int addCustomer(CustomerObject item) {
		return this.c.addCustomer(item);
	}

	public boolean delCustomer(CustomerObject item) {
		return this.c.delCustomer(item);
	}

	public boolean editCustomer(CustomerObject item) {
		return this.c.editCustomer(item);
	}

	// ***************************************************/
	// chuyen the tu ResultSet thanh doi tuong
	public CustomerObject getCustomerObject(int id) {
		CustomerObject item = null;

		// lay du lieu
		ResultSet rs = this.c.getCustomer(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CustomerObject();
					item.setCustomer_id(rs.getInt("customer_id"));
					item.setCustomer_fullname(rs.getString("customer_fullname"));
					item.setCustomer_gender(rs.getShort("customer_gender"));
					item.setCustomer_address(rs.getString("customer_address"));
					item.setCustomer_email(rs.getString("customer_email"));
					item.setCustomer_birthday(rs.getString("customer_birthday"));
					item.setCustomer_phone(rs.getString("customer_phone"));
					item.setCustomer_code(rs.getString("customer_code"));

				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getCustomerObjects(CustomerObject similar) {
		ArrayList items = new ArrayList<>();
		CustomerObject item = null;

		ResultSet rs = this.c.getCustomers(similar);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new CustomerObject(); // khoi tao bo nho luu tru
					item.setCustomer_id(rs.getInt("customer_id"));
					item.setCustomer_fullname(rs.getString("customer_fullname"));
					item.setCustomer_gender(rs.getShort("customer_gender"));
					item.setCustomer_address(rs.getString("customer_address"));
					item.setCustomer_email(rs.getString("customer_email"));
					item.setCustomer_birthday(rs.getString("customer_birthday"));
					item.setCustomer_phone(rs.getString("customer_phone"));
					item.setCustomer_code(rs.getString("customer_code"));
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
