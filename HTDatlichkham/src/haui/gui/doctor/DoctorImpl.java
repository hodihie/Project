/**
 * 
 */
package haui.gui.doctor;

import java.sql.ResultSet;

import haui.ConnectionPool;
import haui.gui.basic.BasicImpl;
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

	/* (non-Javadoc)
	 * @see haui.gui.doctor.Doctor#getDoctors(haui.objects.DoctorObject)
	 */
	@Override
	public ResultSet getDoctors(DoctorObject similar) {
		String sql = " SELECT * FROM tbldoctor ";		
		sql += " ORDER BY doctor_name ASC ";		
		return this.gets(sql);
	}

	

}
