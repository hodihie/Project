/**
 * 
 */
package haui.ads.article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.ads.article.category.CategoryImpl;
import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleImpl extends CategoryImpl implements Article {
	/**
	 * 
	 */
	public ArticleImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#addArticle(haui.objects.ArticleObject)
	 */
	@Override
	public boolean addArticle(ArticleObject item) {
		String sql = " INSERT INTO tblarticle( ";
		sql += " article_title, article_summary, article_content, ";
		sql += " article_created_date, article_last_modified, article_image, ";
		sql += " article_category_id, article_section_id, article_visited, ";
		sql += " article_author_name, article_enable, article_url_link, ";
		sql += " article_tag, article_title_en, article_summary_en, ";
		sql += " article_content_en, article_tag_en, article_fee, article_isfee, ";
		sql += " article_delete, article_deleted_date, article_restored_date, ";
		sql += " article_modified_author_name, article_author_permission, article_source";
		sql += " article_language, article_focus) ";
		sql += " VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			pre.setString(4, item.getArticle_created_date());
			pre.setString(5, item.getArticle_last_modified());
			pre.setString(6, item.getArticle_image());
			pre.setShort(7, item.getArticle_category_id());
			pre.setShort(8, item.getArticle_section_id());
			pre.setShort(9, item.getArticle_visited());
			pre.setString(10, item.getArticle_author_name());
			pre.setBoolean(11, item.isArticle_enable());
			pre.setString(12, item.getArticle_url_link());
			pre.setString(13, item.getArticle_tag());
			pre.setString(14, item.getArticle_tag_en());
			pre.setString(15, item.getArticle_summary_en());
			pre.setString(16, item.getArticle_content_en());
			pre.setString(17, item.getArticle_tag_en());
			pre.setInt(18, item.getArticle_fee());
			pre.setBoolean(19, item.isArticle_isfee());
			pre.setBoolean(20, item.isArticle_delete());
			pre.setString(21, item.getArticle_deleted_date());
			pre.setString(22, item.getArticle_restored_date());
			pre.setString(23, item.getArticle_modified_author_name());
			pre.setShort(24, item.getArticle_author_permission());
			pre.setString(25, item.getArticle_source());
			pre.setByte(26, item.getArticle_language());
			pre.setBoolean(27, item.isArticle_focus());

			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#editArticle(haui.objects.ArticleObject)
	 */
	@Override
	public boolean editArticle(ArticleObject item) {
		String sql = " UPDATE tblarticle ";
		sql += " SET article_title, article_summary, article_content, ";
		sql += " article_last_modified, article_image, ";
		sql += " article_category_id, article_section_id, article_visited, ";
		sql += " article_author_name, article_enable, article_url_link, ";
		sql += " article_tag, article_title_en, article_summary_en, ";
		sql += " article_content_en, article_tag_en, article_fee, article_isfee, ";
		sql += " article_delete, article_deleted_date, article_restored_date, ";
		sql += " article_modified_author_name, article_author_permission, article_source";
		sql += " article_language, article_focus ";
		sql += " WHERE article_id=? ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			pre.setString(4, item.getArticle_last_modified());
			pre.setString(5, item.getArticle_image());
			pre.setShort(6, item.getArticle_category_id());
			pre.setShort(7, item.getArticle_section_id());
			pre.setShort(8, item.getArticle_visited());
			pre.setString(9, item.getArticle_author_name());
			pre.setBoolean(10, item.isArticle_enable());
			pre.setString(11, item.getArticle_url_link());
			pre.setString(12, item.getArticle_tag());
			pre.setString(13, item.getArticle_tag_en());
			pre.setString(14, item.getArticle_summary_en());
			pre.setString(15, item.getArticle_content_en());
			pre.setString(16, item.getArticle_tag_en());
			pre.setInt(17, item.getArticle_fee());
			pre.setBoolean(18, item.isArticle_isfee());
			pre.setBoolean(19, item.isArticle_delete());
			pre.setString(20, item.getArticle_deleted_date());
			pre.setString(21, item.getArticle_restored_date());
			pre.setString(22, item.getArticle_modified_author_name());
			pre.setShort(23, item.getArticle_author_permission());
			pre.setString(24, item.getArticle_source());
			pre.setByte(25, item.getArticle_language());
			pre.setBoolean(26, item.isArticle_focus());

			pre.setInt(27, item.getArticle_id());

			return this.edit(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#delArticle(haui.objects.ArticleObject)
	 */
	@Override
	public boolean delArticle(ArticleObject item) {
		String sql = " DELETE FROM tblarticle WHERE article_id=? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getArticle_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#getArticle(int)
	 */
	@Override
	public ResultSet getArticle(int id) {
		String sql = " SELECT * FROM tblarticle ";
		sql += " LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += " LEFT JOIN tblsection ON article_section_id=section_id ";
		sql += " WHERE article_id=? ";
		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#getArticle(int, boolean)
	 */
	@Override
	public ResultSet getArticle(int id, boolean isUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#getArticles(haui.objects.ArticleObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total) {
		String sql = " SELECT * FROM tblarticle ";
		sql += " LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += " LEFT JOIN tblsection ON article_section_id=section_id ";
		sql += "";
		sql += " ORDER BY article_title DESC ";
		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		ArticleImpl art = new ArticleImpl(cp, "Article");
		ResultSet rs = art.getArticles(null, 0, (byte) 15);
		art.releaseConnection();
		try {
			while (rs.next()) {
				System.out.print(rs.getInt("article_id") + "\t");
				System.out.println(rs.getString("article_title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
