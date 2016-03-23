/**
 * 
 */
package haui.gui.customer;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.CustomerObject;

/**
 * @author Dinh Hieu
 *
 */
public class CustomerControl {
	private CustomerModel cm;

	/**
	 * 
	 */
	public CustomerControl(ConnectionPool cp) {
		this.cm = new CustomerModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.cm.getConnectionPool();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// *************************************/
	public int addCustomer(CustomerObject item) {
		return this.cm.addCustomer(item);
	}

	public boolean editCustomer(CustomerObject item) {
		return this.cm.editCustomer(item);
	}

	public boolean delCustomer(CustomerObject item) {
		return this.cm.delCustomer(item);
	}

	// **********************************************/
	public CustomerObject getCustomerObject(int id) {
		return this.cm.getCustomerObject(id);
	}

	public ArrayList getCustomerObject(CustomerObject similar) {
		return this.cm.getCustomerObjects(similar);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		// tao doi tuong thuc thi chuc nang
		CustomerControl uc = new CustomerControl(cp);
		// lay du lieu html hien thi
		// String viewcustomers = uc.viewCustomers(null, 1, (byte)15);
		// tra ve ket noi
		uc.releaseConnection();
		// hien thi
		// System.out.println(viewcustomers);
	}
}
