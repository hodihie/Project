/**
 * 
 */
package haui.gui.apointment;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.user.UserControl;
import haui.objects.ApointmentObject;
import haui.objects.ArticleObject;
import haui.objects.RequestSMSObject;
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
	
	public boolean addRequestSMS(RequestSMSObject item) {
		return this.am.addRequestSMS(item);
	}

	// ************************************************
	public ApointmentObject getApointmentObject(short id) {
		return this.am.getApointmentObject(id);
	}
	
	public ArrayList getNextApointmentsByDocId(short docId, String currentDate) {
		return this.am.getApointmentObjectByDocId(docId, currentDate);
	}

	public ArrayList getApointmentObjects(ApointmentObject similar) {
		return this.am.getApointmentObjects(similar);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		// tao doi tuong thuc thi chuc nang
		ApointmentControl ac = new ApointmentControl(cp);
		ApointmentObject similar = new ApointmentObject();
		ArrayList<ApointmentObject> items = ac.getApointmentObjects(similar);
		ac.releaseConnection();
		// hien thi
		for (ApointmentObject item : items) {
			System.out.println(item.getApointment_date());
		}
	}

}
