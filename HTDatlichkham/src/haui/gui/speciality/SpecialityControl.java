/**
 * 
 */
package haui.gui.speciality;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;

import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityControl {

	private SpecialityModel sm;

	/**
	 * 
	 */
	public SpecialityControl(ConnectionPool cp) {
		this.sm = new SpecialityModel(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.sm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.sm.getConnectionPool();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	// ************************************************
	public SpecialityObject getSpecialityObject(short id) {
		return this.sm.getSpecialityObject(id);
	}

	public String viewSpecialityObjects(SpecialityObject similar) {
		ArrayList items = this.sm.getSpecialityObjects(similar);
		return SpecialityLibrary.viewSpecialities(items);
	}

	// *****************************************
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		SpecialityControl sc = new SpecialityControl(cp);
		String view = sc.viewSpecialityObjects(null);
		sc.releaseConnection();
		System.out.println(view);
	}

}
