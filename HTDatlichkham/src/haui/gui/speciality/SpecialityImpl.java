/**
 * 
 */
package haui.gui.speciality;

import java.sql.ResultSet;

import haui.ConnectionPool;
import haui.gui.basic.BasicImpl;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityImpl extends BasicImpl implements Speciality {

	/**
	 * @param cp
	 * @param objectName
	 */
	public SpecialityImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	

	/* (non-Javadoc)
	 * @see haui.ads.speciality.Speciality#getSpecialityr(int)
	 */
	@Override
	public ResultSet getSpeciality(int id) {
		String sql = " SELECT * FROM tblspeciality WHERE speciality_id=?  ";
		return this.get(sql, id);
	}

	/* (non-Javadoc)
	 * @see haui.ads.speciality.Speciality#getSpecialities(haui.objects.SpecialityObject, int, byte)
	 */
	@Override
	public ResultSet getSpecialities(SpecialityObject similar) {
		String sql = " SELECT * FROM tblspeciality ";

		sql += " ";// menh de Where

		sql += " ORDER BY speciality_name ASC ";	

		return this.gets(sql);
	}

	

}
