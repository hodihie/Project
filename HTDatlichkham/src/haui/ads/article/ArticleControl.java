/**
 * 
 */
package haui.ads.article;

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
	public String viewArticles(ArticleObject similar, int page, byte total) {
		ArrayList items = this.am.getArticleObjects(similar, page, total);
		return ArticleLibrary.viewArticles(items);
	}

	// test
	public static void main(String[] args) {

		ConnectionPool cp = new ConnectionPoolImpl();

		ArticleControl sc = new ArticleControl(cp);

		String viewarticles = sc.viewArticles(null, 1, (byte) 15);

		sc.releaseConneciton();

		System.out.print(viewarticles);
	}

}
