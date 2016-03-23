/**
 * 
 */
package haui.gui.doctor;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.DoctorObject;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public class DoctorControl {

	private DoctorModel dm;

	/**
	 * 
	 */
	public DoctorControl(ConnectionPool cp) {
		this.dm = new DoctorModel(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.dm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.dm.getConnectionPool();
	}

	public void releaseConnection() {
		this.dm.releaseConnection();
	}

	// ************************************************
	public DoctorObject getDoctorObject(int id) {
		return this.dm.getDoctorObject(id);
	}

	public ArrayList getDoctorObjects(DoctorObject similar, int specialityId) {
		return this.dm.getDoctorObjects(similar, specialityId);
	}

	public String viewDoctorObject(int doctorId) {
		DoctorObject item = this.dm.getDoctorObject(doctorId);
		return DoctorLibrary.viewDoctorObject(item);
	}
	
	public String viewDoctorObjects(DoctorObject similar) {
		ArrayList<DoctorObject> items = this.dm.getDoctorObjects(similar);
		return DoctorLibrary.viewDoctorObjects(items);
	}

}
