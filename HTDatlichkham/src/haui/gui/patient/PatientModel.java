/**
 * 
 */
package haui.gui.patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.objects.PatientObject;

/**
 * @author Dinh Hieu
 *
 */
public class PatientModel {
	private Patient c;

	/**
	 * 
	 */
	public PatientModel(ConnectionPool cp) {
		this.c = new PatientImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.c = null;
		super.finalize();
	}

	// chia se bo quan ly ket noi
	public ConnectionPool getConnectionPool() {
		return this.c.getConnectionPool();
	}

	// tra ve ket noi
	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// ************************************************************/
	public int addPatient(PatientObject item) {
		return this.c.addPatient(item);
	}

	public boolean delPatient(PatientObject item) {
		return this.c.delPatient(item);
	}

	public boolean editPatient(PatientObject item) {
		return this.c.editPatient(item);
	}

	// ***************************************************/
	// chuyen the tu ResultSet thanh doi tuong
	public PatientObject getPatientObject(int id) {
		PatientObject item = null;

		// lay du lieu
		ResultSet rs = this.c.getPatient(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new PatientObject();
					item.setPatient_id(rs.getInt("patient_id"));
					item.setPatient_fullname(rs.getString("patient_fullname"));
					item.setPatient_gender(rs.getShort("patient_gender"));
					item.setPatient_address(rs.getString("patient_address"));				
					item.setPatient_birthday(rs.getString("patient_birthday"));
					item.setPatient_phone(rs.getString("patient_phone"));
					item.setPatient_code(rs.getString("patient_code"));

				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getPatientObjects(PatientObject similar) {
		ArrayList items = new ArrayList<>();
		PatientObject item = null;

		ResultSet rs = this.c.getPatients(similar);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new PatientObject(); // khoi tao bo nho luu tru
					item.setPatient_id(rs.getInt("patient_id"));
					item.setPatient_fullname(rs.getString("patient_fullname"));
					item.setPatient_gender(rs.getShort("patient_gender"));
					item.setPatient_address(rs.getString("patient_address"));					
					item.setPatient_birthday(rs.getString("patient_birthday"));
					item.setPatient_phone(rs.getString("patient_phone"));
					item.setPatient_code(rs.getString("patient_code"));
					// can dung bao nhieu lay bay nhieu

					items.add(item); // Dua vao danh sach
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return items;
	}

}
