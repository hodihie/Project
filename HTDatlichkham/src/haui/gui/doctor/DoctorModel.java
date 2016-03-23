/**
 * 
 */
package haui.gui.doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class DoctorModel {

	private Doctor d;

	/**
	 * 
	 */
	public DoctorModel(ConnectionPool cp) {
		this.d = new DoctorImpl(cp, "Doctor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.d = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.d.getConnectionPool();
	}

	public void releaseConnection() {
		this.d.releaseConnection();
	}

	// **************************************

	// chuyen tu Resultset thanh doi tuong
	public DoctorObject getDoctorObject(int id) {
		DoctorObject item = null;

		// lay du lieu
		ResultSet rs = this.d.getDoctor(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new DoctorObject();
					item.setDoctor_id(rs.getShort("doctor_id"));
					item.setDoctor_name(rs.getString("doctor_name"));
					item.setDoctor_age(rs.getShort("doctor_age"));
					item.setDoctor_workroom(rs.getString("doctor_workroom"));
					item.setDoctor_gender(rs.getShort("doctor_gender"));
					item.setDoctor_degree(rs.getString("doctor_degree"));
					item.setDoctor_experience(rs.getString("doctor_experience"));
					item.setDoctor_img(rs.getString("doctor_img"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getDoctorObjects(DoctorObject similar, int specialityId) {
		ArrayList<DoctorObject> items = new ArrayList<>();
		DoctorObject item = null;

		// lay du lieu
		ResultSet rs = this.d.getDoctors(similar, specialityId);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new DoctorObject();
					item.setDoctor_id(rs.getShort("doctor_id"));
					item.setDoctor_name(rs.getString("doctor_name"));
					item.setDoctor_age(rs.getShort("doctor_age"));
					item.setDoctor_workroom(rs.getString("doctor_workroom"));
					item.setDoctor_gender(rs.getShort("doctor_gender"));
					item.setDoctor_degree(rs.getString("doctor_degree"));
					item.setDoctor_experience(rs.getString("doctor_experience"));
					item.setDoctor_img(rs.getString("doctor_img"));
					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;

	}
	
	public ArrayList getDoctorObjects(DoctorObject similar) {
		ArrayList<DoctorObject> items = new ArrayList<>();
		DoctorObject item = null;

		// lay du lieu
		ResultSet rs = this.d.getDoctors(similar);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new DoctorObject();
					item.setDoctor_id(rs.getShort("doctor_id"));
					item.setDoctor_name(rs.getString("doctor_name"));
					item.setDoctor_age(rs.getShort("doctor_age"));
					item.setDoctor_workroom(rs.getString("doctor_workroom"));
					item.setDoctor_gender(rs.getShort("doctor_gender"));
					item.setDoctor_degree(rs.getString("doctor_degree"));
					item.setDoctor_experience(rs.getString("doctor_experience"));
					item.setDoctor_img(rs.getString("doctor_img"));
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
