/**
 * 
 */
package haui.ads.speciality;

import java.sql.ResultSet;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
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
	 * @see haui.ads.speciality.Speciality#addSpeciality(haui.objects.SpecialityObject)
	 */
	@Override
	public boolean addSpeciality(SpecialityObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see haui.ads.speciality.Speciality#editSpeciality(haui.objects.SpecialityObject)
	 */
	@Override
	public boolean editSpeciality(SpecialityObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see haui.ads.speciality.Speciality#delSpeciality(haui.objects.SpecialityObject)
	 */
	@Override
	public boolean delSpeciality(SpecialityObject item) {
		// TODO Auto-generated method stub
		return false;
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
	public ResultSet getSpecialities(SpecialityObject similar, int at, byte total) {
		String sql = " SELECT * FROM tblspeciality ";

		sql += " ";// menh de Where

		sql += " ORDER BY speciality_name ASC ";
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	

}
