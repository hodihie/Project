/**
 * 
 */
package haui.gui.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import haui.ShareControl;

/**
 * @author Dinh Hieu
 *
 */
public interface Basic extends ShareControl {
	
	public boolean add(PreparedStatement pre);
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);

	public ResultSet get(String sql, int value);

	public ResultSet gets(String sql);// lay nhieu ban ghi trong 1 resulset
	public ResultSet gets(String sql,int value);
	public ResultSet[] gets(String[] sqls);// lay nhieu resultset
}
