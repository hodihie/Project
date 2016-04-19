/**
 * 
 */
package haui.ads.apointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentImpl extends BasicImpl implements Apointment {

	/**
	 * @param cp
	 * @param objectName
	 */
	public ApointmentImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.apointment.Apointment#getApointment(int)
	 */
	@Override
	public ResultSet getApointment(int id) {
		String sql = " SELECT * FROM tblapointment WHERE apointment_id=?  ";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.apointment.Apointment
	 * 
	 */
	@Override
	public ResultSet getApointments(ApointmentObject similar, int at, byte total) {
		String sql = " SELECT * FROM tblapointment ";
		sql += " ORDER BY apointment_id ASC";		
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.gui.apointment.Apointment#addApointment(haui.objects.
	 * ApointmentObject)
	 */
	@Override
	public boolean addApointment(ApointmentObject item) {
		String sql = "INSERT INTO tblapointment(apointment_customer_id,apointment_doctor_id, ";
		sql += "apointment_date, apointment_created_date, ";
		sql += "apointment_time, apointment_symptom) ";
		sql += "VALUE(?,?,?,?,?,?)";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyen gia tri
			pre.setInt(1, item.getApointment_customer_id());			
			pre.setInt(2, item.getApointment_doctor_id());
			pre.setString(3, item.getApointment_date());
			pre.setString(4, item.getApointment_created_date());			
			pre.setString(6, item.getApointment_symptom());

			return this.add(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.gui.apointment.Apointment#editApointment(haui.objects.
	 * ApointmentObject)
	 */
	@Override
	public boolean editApointment(ApointmentObject item) {
		String sql = " UPDATE tblapointment set apointment_customer_id=?,apointment_doctor_id=?, ";
		sql += " apointment_date=?,apointment_created_date=?, ";
		sql += " apointment_time=?, apointment_symptom=? ";
		sql += " WHERE apointment_id=?";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyen gia tri
			pre.setInt(1, item.getApointment_customer_id());			
			pre.setInt(2, item.getApointment_doctor_id());			
			pre.setString(3, item.getApointment_date());
			pre.setString(4, item.getApointment_created_date());			
			pre.setString(6, item.getApointment_symptom());

			pre.setInt(7, item.getApointment_id());

			return this.edit(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.gui.apointment.Apointment#delApointment(haui.objects.
	 * ApointmentObject)
	 */
	@Override
	public boolean delApointment(ApointmentObject item) {
		String sql = "DELETE FROM tblapointment WHERE apointment_id=?";

		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getApointment_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
