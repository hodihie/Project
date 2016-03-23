/**
 * 
 */
package haui.ads.article.category;

import java.util.ArrayList;

import haui.objects.CategoryObject;

/**
 * @author Dinh Hieu
 *
 */
public class CategoryLibrary {
	public static String viewCategories(ArrayList<CategoryObject> items) {
		String tmp = "";
		int i = 0;
		for (CategoryObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\"> " : "<tr>";
			tmp += "<td class=NO>" + i + "</td>";
			tmp += "<td class=NAME>" + item.getCategory_name() + "</td>";
			tmp += "<td>" + item.getCategory_created_date() + "</td>";
			tmp += "<td>" + item.getSection_name() + "</td>";
			tmp += "<td>" + item.getCategory_created_author_id() + "</td>";
			tmp += "<td>" + item.getCategory_notes() + "</td>";
			tmp += "<td class=ED><a href=\"\">Sửa</a></td>";
			tmp += "<td class=ED><a href=\"\">Xóa</a></td>";
			tmp += "<td class=ID>" + item.getCategory_id() + "</td>";
			tmp += "</tr>";

			tmp += "\n";
		}
		return tmp;
	}
}
