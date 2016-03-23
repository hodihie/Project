/**
 * 
 */
package haui.ads.doctor;

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

	public String viewDoctors(DoctorObject similar, int page, byte total) {
		ArrayList items = this.dm.getDoctorObjects(similar, page, total);
		return DoctorLibrary.viewDoctors(items);
	}

}
