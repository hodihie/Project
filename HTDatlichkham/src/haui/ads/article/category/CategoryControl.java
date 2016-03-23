/**
 * 
 */
package haui.ads.article.category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.CategoryObject;

/**
 * @author Dinh Hieu
 *
 */
public class CategoryControl {
	private CategoryModel cm;

	/**
	 * 
	 */
	public CategoryControl(ConnectionPool cp) {
		this.cm = new CategoryModel(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.cm.getConnectionPool();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// *********************************

	public boolean addCategory(CategoryObject item) {
		return this.cm.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.cm.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.cm.delCategory(item);
	}

	/// **************************************

	public CategoryObject getCategoryObject(short id) {
		return this.cm.getCategoryObject(id);
	}

	// ******************************************

	public String viewCategories(CategoryObject similar, int page, byte total) {
		ArrayList items = this.cm.getCategoryObjects(similar, page, total);
		return CategoryLibrary.viewCategories(items);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		CategoryControl cc= new CategoryControl(cp);
		String viewcategories= cc.viewCategories(null, 1, (byte)15);
		cc.releaseConnection();
		System.out.println(viewcategories);
	}

}
