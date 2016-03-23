/**
 * 
 */
package haui.gui.article;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleControl {
	private ArticleModel am;

	/**
	 * 
	 */
	public ArticleControl(ConnectionPool cp) {
		this.am = new ArticleModel(cp);
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

	public void releaseConneciton() {
		this.am.releaseConnection();
	}

	// **********************************

	public boolean addArticle(ArticleObject item) {
		return this.am.addArticle(item);
	}

	public boolean editArticle(ArticleObject item) {
		return this.am.editArticle(item);
	}

	public boolean delArticle(ArticleObject item) {
		return this.am.delArticle(item);
	}

	// *********************************
	public ArticleObject getArticleObject(int id) {
		return this.am.getArticleObject(id);
	}

	// *********************************
	public String viewAllNews(ArticleObject similar) {
		ArrayList<ArticleObject> items = this.am.getArticleObjects(similar, 1, (byte) 6, false);
		return ArticleLibrary.viewAllNews(items);
	}
	
	
	public String viewFocus(ArticleObject similar) {
		ArrayList<ArticleObject> items = this.am.getArticleObjects(similar, 1, (byte) 5, false);
		return ArticleLibrary.viewFocus(items);
	}
	
	public String viewMostVisited(ArticleObject similar) {
		ArrayList<ArticleObject> items = this.am.getArticleObjects(similar, 1, (byte) 6, true);
		return ArticleLibrary.viewMostVisited(items);
	}
	
	public String viewNewest(ArticleObject similar) {
		ArrayList<ArticleObject> items = this.am.getArticleObjects(similar, 1, (byte) 3, false);
		return ArticleLibrary.viewNewest(items);
	}

	public String viewFocusDetails(int id) {
		ArticleObject item = this.am.getArticleObject(id);
		return ArticleLibrary.viewFocusDetails(item);

	}

}
