/**
 * 
 */
package haui.gui.patient;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.PatientObject;

/**
 * @author Dinh Hieu
 *
 */
public class PatientControl {
	private PatientModel cm;

	/**
	 * 
	 */
	public PatientControl(ConnectionPool cp) {
		this.cm = new PatientModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.cm.getConnectionPool();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// *************************************/
	public int addPatient(PatientObject item) {
		return this.cm.addPatient(item);
	}

	public boolean editPatient(PatientObject item) {
		return this.cm.editPatient(item);
	}

	public boolean delPatient(PatientObject item) {
		return this.cm.delPatient(item);
	}

	// **********************************************/
	public PatientObject getPatientObject(int id) {
		return this.cm.getPatientObject(id);
	}

	public ArrayList getPatientObject(PatientObject similar) {
		return this.cm.getPatientObjects(similar);
	}
	
}
