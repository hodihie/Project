/**
 * 
 */
package haui.gui.article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ads.article.category.CategoryImpl;
import haui.objects.ArticleObject;
import haui.objects.UserObject;
import sql.gui.MakeConditions;

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
	 * @see haui.ads.article.Article#getArticle(int)
	 */
	@Override
	public ResultSet getArticle(int id) {
		return this.getArticle(id, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#getArticle(int, boolean)
	 */
	@Override
	public ResultSet getArticle(int id, boolean isUpdated) {
		String sql = " SELECT * FROM tblarticle ";
		sql += " LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += " LEFT JOIN tblsection ON article_section_id=section_id ";
		sql += " WHERE article_id=? ";

		String sqlUpdate = " UPDATE tbleartile SET article_visited=article_visited +1 ";
		sqlUpdate += " WHERE article_id=? ";

		int resultUpdate = 0;
		if (isUpdated) {
			PreparedStatement preUpdate;
			try {
				preUpdate = this.con.prepareStatement(sqlUpdate);
				preUpdate.setInt(1, id);
				resultUpdate = preUpdate.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return this.get(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.article.Article#getArticles(haui.objects.ArticleObject,
	 * int, byte)
	 */
	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total, boolean isMostVisited) {
		String sql = " SELECT * FROM tblarticle ";
		sql += " LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += " LEFT JOIN tblsection ON article_section_id=section_id ";

		String conds = MakeConditions.createCondition(similar);
		if (!conds.equalsIgnoreCase("")) {
			sql += " WHERE " + conds + " ";
		}
		if (isMostVisited) {
			sql += " ORDER BY article_visited DESC ";
		} else {
			sql += " ORDER BY article_id DESC ";
		}

		sql += " LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.gui.article.Article#getArticles(haui.objects.ArticleObject,
	 * int, byte, haui.objects.UserObject)
	 */
	@Override
	public ResultSet[] getArticles(ArticleObject similar, int at, byte total, UserObject user) {
		// TODO Auto-generated method stub
		return null;
	}

}
