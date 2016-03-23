/**
 * 
 */
package haui.ads.article.section;

import java.util.ArrayList;

import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public class SectionLibrary {
	public static String viewSections(ArrayList<SectionObject> items) {
		String tmp = "";
		int i = 0;
		for (SectionObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += " <td class=NO>" + (i) + "</td> ";
			tmp += " <td class=NAME>" + item.getSection_name() + "</td> ";
			tmp += " <td>" + item.getSection_created_date() + "</td> ";
			tmp += " <td>" + item.getSection_created_author_id() + "</td> ";
			tmp += " <td>" + item.getSection_notes() + "</td> ";
			tmp += " <td class=ED><a href=\"\">Sửa</a></td> ";
			tmp += " <td class=ED><a href=\"\">Xóa</a></td> ";
			tmp += " <td class=ID>" + item.getSection_id() + "</td> ";
			tmp += "</tr>";
			//tmp += " \n";

		}
		return tmp;

	}
}
