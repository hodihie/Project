/**
 * 
 */
package haui.ads.apointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ads.doctor.Doctor;
import haui.ads.doctor.DoctorImpl;
import haui.ads.doctor.DoctorModel;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentModel {

	private Apointment a;
	private DoctorModel dm;

	/**
	 * 
	 */
	public ApointmentModel(ConnectionPool cp) {
		this.a = new ApointmentImpl(cp, "Apointment");
		dm = new DoctorModel(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.a = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.a.getConnectionPool();
	}

	public void releaseConnection() {
		this.a.releaseConnection();
	}

	// ************************************************************/
	public boolean addApointment(ApointmentObject item) {
		return this.a.addApointment(item);
	}

	public boolean delApointment(ApointmentObject item) {
		return this.a.delApointment(item);
	}

	public boolean editApointment(ApointmentObject item) {
		return this.a.editApointment(item);
	}

	// **************************************

	// chuyen tu Resultset thanh doi tuong
	public ApointmentObject getApointmentObject(int id) {
		ApointmentObject item = null;

		// lay du lieu
		ResultSet rs = this.a.getApointment(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ApointmentObject();
					item.setApointment_id(rs.getInt("apointment_id"));
					item.setApointment_doctor_id(rs.getInt("apointment_doctor_id"));
					item.setApointment_customer_id(rs.getInt("apointment_customer_id"));
					item.setApointment_created_date(rs.getString("apointment_created_date"));
					item.setApointment_date(rs.getString("apointment_date"));
					item.setApointment_time(rs.getString("apointment_time"));
					item.setApointment_symptom(rs.getString("apointment_symptom"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getApointmentObjects(ApointmentObject similar, int page, byte totalperpage) {
		ArrayList<ApointmentObject> items = new ArrayList<>();
		ApointmentObject item = null;

		// lay du lieu
		int at = (page - 1) * totalperpage;
		ResultSet rs = this.a.getApointments(similar, at, totalperpage);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ApointmentObject();
					item.setApointment_id(rs.getInt("apointment_id"));
					item.setApointment_doctor_id(rs.getInt("apointment_doctor_id"));
					item.setApointment_customer_id(rs.getInt("apointment_customer_id"));
					item.setApointment_created_date(rs.getString("apointment_created_date"));
					item.setApointment_date(rs.getString("apointment_date"));
					item.setApointment_time(rs.getString("apointment_time"));
					item.setApointment_symptom(rs.getString("apointment_symptom"));					
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
