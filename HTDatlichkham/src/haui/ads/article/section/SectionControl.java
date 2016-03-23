/**
 * 
 */
package haui.ads.article.section;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public class SectionControl {
	private SectionModel sm;

	/**
	 * 
	 */
	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
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

	public void releaseConnectionPool() {
		this.sm.releaseConnection();
	}

	// *******************************************************
	public boolean addSection(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sm.delSection(item);
	}

	// ************************************************
	public SectionObject getSectionObject(short id) {
		return this.sm.getSectionObject(id);
	}

	// **************************************************
	public String viewSections(SectionObject similar, int page, byte total) {
		ArrayList items = this.sm.getSectionObjects(similar, page, total);
		return SectionLibrary.viewSections(items);
	}

	// *****************************************
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		SectionControl sc = new SectionControl(cp);
		String viewsections = sc.viewSections(null, 1, (byte) 15);
		sc.releaseConnectionPool();
		System.out.println(viewsections);
	}

}
