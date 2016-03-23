/**
 * 
 */
package haui.ads.article.section;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.basic.BasicImpl;
import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public class SectionImpl extends BasicImpl implements Section {

	/**
	 * @param cp
	 * @param objectName
	 */
	public SectionImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * haui.ads.article.section.Section#addSction(haui.objects.SectionObject)
	 */
	@Override
	public boolean addSection(SectionObject item) {
		String sql = " INSERT INTO tblsection( ";
		sql += " section_name, section_notes, ";
		sql += " section_created_date, section_manager_id, ";
		sql += " section_enable, section_delete, ";
		sql += " section_last_modified, section_created_author_id, ";
		sql += " section_name_en, section_language) ";
		sql += " VALUE(?,?,?,?,?,?,?,?,?,?) ";

		PreparedStatement pre = null;
		try {
			pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setString(3, item.getSection_created_date());
			pre.setInt(4, item.getSection_manager_id());
			pre.setBoolean(5, item.isSection_enable());
			pre.setBoolean(6, item.isSection_delete());
			pre.setString(7, item.getSection_last_modified());
			pre.setInt(8, item.getSection_created_author_id());
			pre.setString(9, item.getSection_name_en());
			pre.setByte(10, item.getSection_language());

			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * haui.ads.article.section.Section#editSection(haui.objects.SectionObject)
	 */
	@Override
	public boolean editSection(SectionObject item) {
		String sql = " UPDATE tblsection ";
		sql += " SET section_name=?, section_notes=?, ";
		sql += " section_manager_id=?, ";
		sql += " section_enable=?, section_delete=?, ";
		sql += " section_last_modified=?, ";
		sql += " section_name_en=?, section_language=? ";
		sql += " WHERE section_id=? ";

		PreparedStatement pre = null;
		try {
			pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setInt(3, item.getSection_manager_id());
			pre.setBoolean(4, item.isSection_enable());
			pre.setBoolean(5, item.isSection_delete());
			pre.setString(6, item.getSection_last_modified());
			pre.setString(7, item.getSection_name_en());
			pre.setByte(8, item.getSection_language());

			pre.setShort(9, item.getSection_id());
			return this.edit(pre);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * haui.ads.article.section.Section#delSection(haui.objects.SectionObject)
	 */
	@Override
	public boolean delSection(SectionObject item) {
		// kiem tra su toan ven 1-nhieu
		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = " DELETE FROM tblsection WHERE section id=? ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getSection_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean isEmpty(SectionObject item) {
		boolean flag = true;

		String sql = " SELECT category_id FROM tblcategory ";
		sql += " WHERE category_section_id=" + item.getSection_id();

		ResultSet rs = this.get(sql, 0);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = false;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.section.Section#getSection(short)
	 */
	@Override
	public ResultSet getSection(short id) {
		String sql = " SELECT * FROM tblsection WHERE section_id=?  ";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * haui.ads.article.section.Section#getSections(haui.objects.SectionObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total) {
		String sql = " SELECT * FROM tblsection ";

		sql += " ";// menh de Where

		sql += " ORDER BY section_name ASC ";
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	// test
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		Section s = new SectionImpl(cp, "Section");
		ResultSet rs = s.getSections(null, 0, (byte) 15);
		s.releaseConnection();

		try {
			while (rs.next()) {
				System.out.println(rs.getInt("section_id"));
				System.out.println(rs.getString("section_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		// Tao doi tuong moi
//		SectionObject nItem = new SectionObject();
//		nItem.setSection_name("Bai viet");
//		nItem.setSection_created_date("11/06/2015");
//
//		// thuc hien them
//		boolean result = s.addSection(nItem);
//		if (!result) {
//			System.out.println("\n**** THEM KHONG THANH CONG ****\n");
//		}

		// Tao doi tuong moi
		SectionObject nItem1 = new SectionObject();
		nItem1.setSection_id((short) 2);
		nItem1.setSection_name("Bai moi");
		nItem1.setSection_created_date("11/06/2015");

		// thuc hien sua
		boolean result1 = s.editSection(nItem1);

		if (!result1) {
			System.out.println("\n**** SUA KHONG THANH CONG ****\n");
		}

	}

}
