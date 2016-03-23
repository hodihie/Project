/**
 * 
 */
package haui.gui.customer;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.CustomerObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Customer extends ShareControl {

	public int addCustomer(CustomerObject item);
	public boolean editCustomer(CustomerObject item);
	public boolean delCustomer(CustomerObject item);

	public ResultSet getCustomer(int id);	
	public ResultSet getCustomers(CustomerObject similar);
}
