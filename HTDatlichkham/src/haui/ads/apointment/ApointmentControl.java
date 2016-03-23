/**
 * 
 */
package haui.ads.apointment;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.customer.CustomerControl;
import haui.ads.doctor.DoctorControl;
import haui.ads.user.UserControl;
import haui.ads.user.UserLibrary;
import haui.objects.ApointmentObject;
import haui.objects.ArticleObject;
import haui.objects.DoctorObject;
import haui.objects.SpecialityObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentControl {

	private ApointmentModel am;

	/**
	 * 
	 */
	public ApointmentControl(ConnectionPool cp) {
		this.am = new ApointmentModel(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.am = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.am.getConnectionPool();
	}

	public void releaseConnection() {
		this.am.releaseConnection();
	}

	// *************************************/
	public boolean addApointment(ApointmentObject item) {
		return this.am.addApointment(item);
	}

	public boolean editApointment(ApointmentObject item) {
		return this.am.editApointment(item);
	}

	public boolean delApointment(ApointmentObject item) {
		return this.am.delApointment(item);
	}

	// ************************************************
	public ApointmentObject getApointmentObject(short id) {
		return this.am.getApointmentObject(id);
	}

	public ArrayList getApointmentObjects(ApointmentObject similar, int page, byte total) {
		return this.am.getApointmentObjects(similar, page, total);
	}

	// ***********************************************/
	public String viewApointments(ApointmentObject similar, int page, byte total, DoctorControl dc,
			CustomerControl cc) {
		ArrayList items = this.am.getApointmentObjects(similar, page, total);
		return ApointmentLibrary.viewApointments(items, dc, cc);
	}

}
