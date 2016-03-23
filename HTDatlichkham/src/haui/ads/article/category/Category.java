/**
 * 
 */
package haui.ads.article.category;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.CategoryObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Category extends ShareControl {
	public boolean addCategory(CategoryObject item);
	public boolean editCategory(CategoryObject item);
	public boolean delCategory(CategoryObject item);
	
	public ResultSet getCategory(short id);
	public ResultSet getCategories(CategoryObject similar, int at, byte total);
}
