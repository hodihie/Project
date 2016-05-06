/**
 * 
 */
package haui.ads.user;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public interface User extends ShareControl {

	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);

	public ResultSet getUser(int id);
	public ResultSet getUser(String username, String userpass);
	public ResultSet[] getUsers(UserObject similar, int at, byte totalperpage);
}
