/**
 * 
 */
package haui.ads.patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
import haui.objects.PatientObject;

/**
 * @author Dinh Hieu
 *
 */
public class PatientImpl extends BasicImpl implements Patient {

	/**
	 * @param cp
	 * @param objectName
	 */
	public PatientImpl(ConnectionPool cp) {
		super(cp, "Patient");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.Patient.Patient#addPatient(haui.objects.PatientObject)
	 */
	@Override
	public int addPatient(PatientObject item) {

		String sql = "INSERT INTO tblPatient(Patient_fullname,Patient_gender, Patient_address, ";
		sql += "Patient_phone, Patient_email, ";
		sql += "Patient_birthday,Patient_code) ";
		sql += " VALUE(?,?,?,?,?,?,?) ";

		int generatedKey = 0;
		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Truyen gia tri
			pre.setString(1, item.getPatient_fullname());
			pre.setShort(2, item.getPatient_gender());
			pre.setString(3, item.getPatient_address());
			pre.setString(4, item.getPatient_phone());
			pre.setString(5, item.getPatient_email());
			pre.setString(6, item.getPatient_birthday());
			pre.setString(7, item.getPatient_code());

			this.add(pre);
			ResultSet rs = pre.getGeneratedKeys();

			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.Patient.Patient#editPatient(haui.objects.PatientObject)
	 */
	@Override
	public boolean editPatient(PatientObject item) {
		String sql = "UPDATE tblPatient SET Patient_fullname=?,Patient_gender=?, Patient_address=?, ";
		sql += "Patient_phone=?, Patient_email=?, ";
		sql += "Patient_birthday=?,Patient_code=? ";
		sql += " WHERE Patient_id=? ";

		try {
			// bien dich
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyen gia tri
			pre.setString(1, item.getPatient_fullname());
			pre.setShort(2, item.getPatient_gender());
			pre.setString(3, item.getPatient_address());
			pre.setString(4, item.getPatient_phone());
			pre.setString(5, item.getPatient_email());
			pre.setString(6, item.getPatient_birthday());
			pre.setString(7, item.getPatient_code());

			pre.setInt(8, item.getPatient_id());

			return this.edit(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.Patient.Patient#delPatient()
	 */
	@Override
	public boolean delPatient(PatientObject item) {
		// kiem tra su lien quan
		if (this.checkForDel(item)) {
			return false;
		}

		String sql = "DELETE FROM tblPatient WHERE Patient_id=?";

		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getPatient_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// kiem tra xem bai bao nao lien quan den Patient ko, neu con thi ko xoa dc
	private boolean checkForDel(PatientObject item) {
		boolean flag = false;

		String sql = "SELECT apointment_id FROM tblapointment ";
		sql += "WHERE apointment_Patient_id=" + item.getPatient_id();

		ResultSet rs = this.get(sql, 0);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.Patient.Patient#getPatient(int)
	 */
	@Override
	public ResultSet getPatient(int id) {
		String sql = "SELECT * FROM tblPatient WHERE Patient_id=?";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.Patient.Patient#getPatients(haui.objects.PatientObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getPatients(PatientObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblPatient ";
		sql += " ORDER BY Patient_fullname ASC ";

		return this.gets(sql);
	}

	// test
	// public static void main(String[] args) {
	// ConnectionPool cp = new ConnectionPoolImpl();
	// Patient u = new PatientImpl(cp);
	//
	// ResultSet rs = u.getPatients(null);
	// u.releaseConnection();
	//
	// try {
	// while (rs.next()) {
	// System.out.print(rs.getInt("Patient_id") + "\t");
	// System.out.print(rs.getString("Patient_fullname") + "\t");
	// System.out.println(rs.getString("Patient_email") + "\t");
	//
	// }
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// }
	// }

}
