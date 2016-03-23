/**
 * 
 */
package haui.ads.speciality;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.doctor.DoctorLibrary;
import haui.objects.DoctorObject;
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

	// *******************************************************
	public boolean addSpeciality(SpecialityObject item) {
		return this.sm.addSpeciality(item);
	}

	public boolean editSpeciality(SpecialityObject item) {
		return this.sm.editSpeciality(item);
	}

	public boolean delSpeciality(SpecialityObject item) {
		return this.sm.delSpeciality(item);
	}

	// ************************************************
	public SpecialityObject getSpecialityObject(short id) {
		return this.sm.getSpecialityObject(id);
	}

	public ArrayList getSpecialityObjects(SpecialityObject similar, int page, byte total) {
		return this.sm.getSpecialityObjects(similar, page, total);
	}

	public String viewSpecialityObjects(SpecialityObject similar, int page, byte total) {
		ArrayList items = this.sm.getSpecialityObjects(similar, page, total);
		return SpecialityLibrary.viewSpecialites(items);
	}

	// *****************************************
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		SpecialityControl sc = new SpecialityControl(cp);
		ArrayList list = sc.getSpecialityObjects(null, 1, (byte) 15);
		sc.releaseConnection();
		System.out.println(list.get(0));
	}

}
