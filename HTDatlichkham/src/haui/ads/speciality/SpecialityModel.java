/**
 * 
 */
package haui.ads.speciality;

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

	// **********************************************
	public boolean addSpeciality(SpecialityObject item) {
		return this.s.addSpeciality(item);
	}

	public boolean editSpeciality(SpecialityObject item) {
		return this.s.editSpeciality(item);
	}

	public boolean delSpeciality(SpecialityObject item) {
		return this.s.delSpeciality(item);
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
					item.setSpeciality_phone(rs.getString("speciality_phone"));
					item.setSpeciality_place(rs.getString("speciality_place"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getSpecialityObjects(SpecialityObject similar, int page, byte totalperpage) {
		ArrayList<SpecialityObject> items = new ArrayList<>();
		SpecialityObject item = null;

		int at = (page - 1) * totalperpage;

		// lay du lieu
		ResultSet rs = this.s.getSpecialities(similar, at, totalperpage);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SpecialityObject();
					item.setSpeciality_id(rs.getShort("speciality_id"));
					item.setSpeciality_name(rs.getString("speciality_name"));		
					item.setSpeciality_phone(rs.getString("speciality_phone"));
					item.setSpeciality_place(rs.getString("speciality_place"));

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
