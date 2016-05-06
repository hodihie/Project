/**
 * 
 */
package haui.ads.article;

import java.util.ArrayList;

import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleLibrary {
	public static String viewArticles(ArrayList<ArticleObject> items) {
		String tmp = "";
		int i = 0;
		for (ArticleObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + i + "</td>";
			tmp += "<td>" + item.getArticle_created_date() + "</td>";
			tmp += "<td>" + item.getArticle_title() + "</td>";
			tmp += "<td>" + item.getCategory_name() + "</td>";
			tmp += "<td>" + item.getSection_name() + "</td>";
			tmp += "<td>" + item.getArticle_author_name() + "</td>";
			tmp += "<td>" + item.getArticle_visited() + "</td>";
			tmp += "<td class=ED><a href=\"/adv/article/ae?id="+item.getArticle_id()+"\"><img src=\"/adv/imgs/icons/edit.png\" class=\"icon\"></a></td>";
			tmp += "<td class=ED><a href=\"/adv/artilce/del?id="+item.getArticle_id()+"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\"><img src=\"/adv/imgs/icons/delete.png\" class=\"icon\"></a></td>";
			tmp += "<td class=ID>" + item.getArticle_id() + "</td>";
			tmp += "</tr>";

			
		}
		return tmp;
	}
}
