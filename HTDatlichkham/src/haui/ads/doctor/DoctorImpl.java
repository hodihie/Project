/**
 * 
 */
package haui.ads.doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class DoctorImpl extends BasicImpl implements Doctor {

	/**
	 * @param cp
	 * @param objectName
	 */
	public DoctorImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.doctor.Doctor#getDoctorr(int)
	 */
	@Override
	public ResultSet getDoctor(int id) {
		String sql = " SELECT * FROM tbldoctor WHERE doctor_id=?  ";
		//sql += " LEFT JOIN tblspeciality ON doctor_speciality_id=speciality_id ";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.doctor.Doctor#getSpecialities(haui.objects.DoctorObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getDoctors(DoctorObject similar, int specialityId) {
		String sql = " SELECT * FROM tbldoctor ";		
		sql += " WHERE doctor_speciality_id=? ";// menh de Where
		sql += " ORDER BY doctor_name ASC ";		
		return this.gets(sql, specialityId);

	}
	
	@Override
	public ResultSet getDoctors(DoctorObject similar, int at, byte total) {
		String sql = " SELECT * FROM tbldoctor ";
		sql += " ORDER BY doctor_name ASC ";	
		sql += " LIMIT " + at + ", " + total;
		return this.gets(sql);

	}

}
