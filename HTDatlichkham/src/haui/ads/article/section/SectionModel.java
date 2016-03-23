/**
 * 
 */
package haui.ads.article.section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public class SectionModel {
	private Section s;

	/**
	 * 
	 */
	public SectionModel(ConnectionPool cp) {
		this.s = new SectionImpl(cp, "Section");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.s = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.s.getConnectionPool();
	}

	public void releaseConnection() {
		this.s.releaseConnection();
	}

	// **********************************************
	public boolean addSection(SectionObject item) {
		return this.s.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.s.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.s.delSection(item);
	}

	// **************************************

	// chuyen tu Resultset thanh doi tuong
	public SectionObject getSectionObject(short id) {
		SectionObject item = null;

		// lay du lieu
		ResultSet rs = this.s.getSection(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_notes(rs.getString("section_notes"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList getSectionObjects(SectionObject similar, int page, byte totalperpage) {
		ArrayList<SectionObject> items = new ArrayList<>();
		SectionObject item = null;

		int at = (page - 1) * totalperpage;

		// lay du lieu
		ResultSet rs = this.s.getSections(similar, at, totalperpage);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));
					item.setSection_notes(rs.getString("section_notes"));

					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;

	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		SectionModel sm = new SectionModel(cp);

		// lay danh sach doi tuong
		ArrayList<SectionObject> items = sm.getSectionObjects(null, 1, (byte) 15);
		sm.releaseConnection();

		// hien thi
		for (SectionObject item : items) {
			System.out.println(item.getSection_id() + "\t");
			System.out.println(item.getSection_name() + "\t");
			System.out.println(item.getSection_created_date());
		}
	}

}
