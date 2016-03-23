/**
 * 
 */
package haui.gui.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.apt.model.ArrayTypeImpl;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleModel {
	private Article a;

	/**
	 * 
	 */
	public ArticleModel(ConnectionPool cp) {
		this.a = new ArticleImpl(cp, "Article");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.a = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.a.getConnectionPool();
	}

	public void releaseConnection() {
		this.a.releaseConnection();
	}

	// ******************************
	public boolean addArticle(ArticleObject item) {
		return this.addArticle(item);
	}

	public boolean editArticle(ArticleObject item) {
		return this.editArticle(item);
	}

	public boolean delArticle(ArticleObject item) {
		return this.delArticle(item);
	}

	// *************************************
	// chuyentu ResultSet thanh doi tuong
	public ArticleObject getArticleObject(int id) {
		ArticleObject item = null;

		// lay du lieu
		ResultSet rs = this.a.getArticle(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleObject();

					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_url_link(rs.getString("article_url_link"));

					// doi tuong ong
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));

					// doi tuong cha
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList getArticleObjects(ArticleObject similar, int page, byte totalperpage, boolean isMostvisited) {
		ArrayList<ArticleObject> items = new ArrayList<ArticleObject>();
		ArticleObject item = null;
		int at = (page - 1) * totalperpage;

		// lay du lieu
		ResultSet rs = this.a.getArticles(similar, at, totalperpage, isMostvisited);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ArticleObject();

					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_url_link(rs.getString("article_url_link"));
					
					// doi tuong ong
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));

					// doi tuong cha
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));

					items.add(item);

				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

}
