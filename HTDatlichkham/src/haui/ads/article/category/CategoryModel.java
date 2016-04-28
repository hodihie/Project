/**
 * 
 */
package haui.ads.article.category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;
import haui.objects.CategoryObject;

/**
 * @author Dinh Hieu
 *
 */
public class CategoryModel {
	private Category c;

	/**
	 * 
	 */
	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp, "Category");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.c = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.c.getConnectionPool();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// ******************************************
	public boolean addCategory(CategoryObject item) {
		return this.c.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.c.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.c.delCategory(item);
	}

	// ****************************************
	// chuyen tu ResultSet thanh doi tuong
	public CategoryObject getCategoryObject(short id) {
		CategoryObject item = null;

		// lay du lieu
		ResultSet rs = this.c.getCategory(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_notes("category_notes");

					// doi tuong cha
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name("section_name");
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList getCategoryObjects(CategoryObject similar, int page, byte totalperpage){
		ArrayList<CategoryObject> items= new ArrayList<CategoryObject>();
		CategoryObject item=null;
		
		int at=(page-1)*totalperpage;
		
		//lay du lieu
		ResultSet rs= this.c.getCategories(similar, at, totalperpage);
		if(rs!=null){
			try {
				while(rs.next()){
					item= new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_created_author_id(rs.getInt("category_created_author_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					
					//doi tuong cha
					item.setSection_name(rs.getString("section_name"));					
					
					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return items;
	}
	
	//test
	public static void main(String[] args) {
		ConnectionPool cp= new ConnectionPoolImpl();
		CategoryModel cm= new CategoryModel(cp);
		
//		//lay ra 1 doi tuong
//		CategoryObject item= cm.getCategoryObject((short)20);
//		System.out.println(item);
		
		//lay ra danh sach doi tuong
		ArrayList<CategoryObject> items= cm.getCategoryObjects(null, 1, (byte)15);
		cm.releaseConnection();
		for(CategoryObject item:items){
			System.out.println(item);
		}
	}

}
