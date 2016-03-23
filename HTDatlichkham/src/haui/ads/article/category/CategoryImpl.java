/**
 * 
 */
package haui.ads.article.category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.article.section.SectionImpl;
import haui.objects.CategoryObject;
import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public class CategoryImpl extends SectionImpl implements Category {

	/**
	 * 
	 */
	public CategoryImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.category.Category#addCategory(haui.objects.
	 * CategoryObject)
	 */
	@Override
	public boolean addCategory(CategoryObject item) {
		String sql = " INSERT INTO tblcategory( ";
		sql += " category_name, category_section_id, category_notes, ";
		sql += " category_created_date, category_created_author_id, category_last_modified, ";
		sql += " category_manager_id, category_enable, category_delete, ";
		sql += " category_image, category_name_en, category_language) ";
		sql += " VALUE(?,?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_created_date());
			pre.setInt(5, item.getCategory_created_author_id());
			pre.setString(6, item.getCategory_last_modified());
			pre.setInt(7, item.getCategory_manager_id());
			pre.setBoolean(8, item.isCategory_enable());
			pre.setBoolean(9, item.isCategory_delete());
			pre.setString(10, item.getCategory_image());
			pre.setString(11, item.getCategory_name_en());
			pre.setByte(12, item.getCategory_language());

			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.category.Category#editCategory(haui.objects.
	 * CategoryObject)
	 */
	@Override
	public boolean editCategory(CategoryObject item) {
		String sql = " UPDATE tblcategory ";
		sql += " SET category_name=?, category_section_id=?, category_notes=?, ";
		sql += " category_last_modified=?, ";
		sql += " category_manager_id=?, category_enable=?, category_delete=?, ";
		sql += " category_image=?, category_name_en=?, category_language=? ";
		sql += " WHERE category_id=? ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_last_modified());
			pre.setInt(5, item.getCategory_manager_id());
			pre.setBoolean(6, item.isCategory_enable());
			pre.setBoolean(7, item.isCategory_delete());
			pre.setString(8, item.getCategory_image());
			pre.setString(9, item.getCategory_name_en());
			pre.setByte(10, item.getCategory_language());

			pre.setShort(11, item.getCategory_id());

			return this.edit(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.category.Category#delCategory(haui.objects.
	 * CategoryObject)
	 */
	@Override
	public boolean delCategory(CategoryObject item) {
		// kiem tra su toan ven 1-n
		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblcategory WHERE category_id=? ";

		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getCategory_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	private boolean isEmpty(CategoryObject item) {
		boolean flag = true;

		String sql = " SELECT article_id FROM tblarticle  ";
		sql += " WHERE article_category_id=" + item.getCategory_id();

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
	 * @see haui.ads.article.category.Category#getCategory(short)
	 */
	@Override
	public ResultSet getCategory(short id) {
		String sql = " SELECT * FROM tblcategory  ";
		sql += " LEFT JOIN tblsection ON category_section_id=section_id ";
		sql+=" WHERE category_id=? ";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.category.Category#getCategories(haui.objects.
	 * CategoryObject, int, byte)
	 */
	@Override
	public ResultSet getCategories(CategoryObject similar, int at, byte total) {
		String sql = " SELECT * FROM tblcategory ";
		sql += " LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "  ";// menh de where
		sql += " ORDER BY category_name ASC ";
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);

	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		Category c = new CategoryImpl(cp, "Category");

		ResultSet rs = c.getCategories(null, 0, (byte) 15);
		c.releaseConnection();
		try {
			while (rs.next()) {
				System.out.print(rs.getInt("category_id") + "\t");
				System.out.print(rs.getString("category_section_id")+"\t");
				System.out.println(rs.getString("category_created_author_id")+"\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
