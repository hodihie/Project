/**
 * 
 */
package haui.gui.speciality;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityModel {

	private Speciality s;

	/**
	 * 
	 */
	public SpecialityModel(ConnectionPool cp) {
		this.s = new SpecialityImpl(cp, "Speciality");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.s = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.s.getConnectionPool();
	}

	public void releaseConnection() {
		this.s.releaseConnection();
	}

	// **************************************

	// chuyen tu Resultset thanh doi tuong
	public SpecialityObject getSpecialityObject(short id) {
		SpecialityObject item = null;

		// lay du lieu
		ResultSet rs = this.s.getSpeciality(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new SpecialityObject();
					item.setSpeciality_id(rs.getShort("speciality_id"));
					item.setSpeciality_name(rs.getString("speciality_name"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getSpecialityObjects(SpecialityObject similar) {
		ArrayList<SpecialityObject> items = new ArrayList<>();
		SpecialityObject item = null;

		// lay du lieu
		ResultSet rs = this.s.getSpecialities(similar);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SpecialityObject();
					item.setSpeciality_id(rs.getShort("speciality_id"));
					item.setSpeciality_name(rs.getString("speciality_name"));

					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;

	}

}
