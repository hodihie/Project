/**
 * 
 */
package haui.gui.article;

import java.util.ArrayList;

import haui.library.Utilities;
import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleLibrary {

	// view all news
	public static String viewAllNews(ArrayList<ArticleObject> items) {
		String tmp = "";
		
		int i=0;
		for (ArticleObject item : items) {
			 //tmp = " <div class=\"all-news\" >";
			tmp += (i % 2 == 0) ? "<div class=\"news-left\">" : "<div class=\"news-right\">";
			tmp += " <a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link=" + item.getArticle_url_link()
					+ "/ \"> ";
			tmp += " <img src=\"" + item.getArticle_image() + "\" /> ";
			tmp += " <h3>" + item.getArticle_title() + "</h3> ";
			tmp += " </a> ";
			tmp += " <p>" + item.getArticle_summary() + "</p> ";
			tmp += " <label><a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link="
					+ item.getArticle_url_link() + "/\">xem thêm</></label> ";
			tmp +="</div>";
			tmp +=( i % 2 != 0) ?" <div class=\"clr\"></div> ":" ";			
			i++;

		}
		//tmp += "</div>";

		return tmp;
	}

	// view article focus
	public static String viewFocus(ArrayList<ArticleObject> items) {
		String tmp = "";

		tmp += " <div class=\"lview\"><img id=\"img-focus\" src=\"\" ></div> ";
		tmp += " <div class=\"view\"> ";
		int i = 1;
		for (ArticleObject item : items) {
			tmp += "<a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link=" + item.getArticle_url_link()
					+ "/ \"><h3 id=\"link" + i + "\">" + item.getArticle_title() + "</h3></a>";

			tmp += "<script>";
			tmp += "$(document).ready(function(){";
			if (i == 1) {
				// set hinh dau tien khi hien thi la img cua link1
				tmp += "$(\"#img-focus\").attr('src', \"" + item.getArticle_image() + "\" );";
			}

			tmp += "$(\"#link" + i + "\").hover(function(){";
			tmp += "$(\"#img-focus\").attr('src', \"" + item.getArticle_image() + "\" );";
			tmp += "	});";
			tmp += "	});";
			tmp += "</script>";
			i++;

		}
		tmp += "</div>";

		return tmp;
	}

	// view most visited
	public static String viewMostVisited(ArrayList<ArticleObject> items) {
		String tmp = " <a href=\"\"><h2>Tin tức xem nhiều</h2></a> ";

		tmp += " <marquee direction=\"up\" scrolldelay=\"80\" scrollamount=\"3\" height=\"400px\" onmousemove=\"stop();\" onmouseout=\"start();\"> ";

		for (ArticleObject item : items) {
			tmp += " <a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link=" + item.getArticle_url_link()
					+ "/\"><h3>  ";
			tmp += item.getArticle_title();
			tmp += " </h3></a> ";
		}

		tmp += " </marquee> ";

		return tmp;
	}

	// view newest
	public static String viewNewest(ArrayList<ArticleObject> items) {
		String tmp = " <a href=\"\"><h2>Tin mới nhất</h2></a> ";

		for (ArticleObject item : items) {

			tmp += " <a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link=" + item.getArticle_url_link()
					+ "/\"> ";
			tmp += " <img src=\"" + item.getArticle_image() + "\" /> ";
			tmp += " <h3>" + item.getArticle_title() + "</h3> ";
			tmp += " </a> ";
			tmp += " <p>" + item.getArticle_summary() + "</p> ";
			tmp += " <label><a href=\"/home/tin-tuc/?art_id=" + item.getArticle_id() + "&link="
					+ item.getArticle_url_link() + "/\">xem thêm</></label> ";
			tmp += " <div class=\"clr\"></div> ";

		}

		return tmp;
	}

	// view article details
	public static String viewFocusDetails(ArticleObject item) {
		String tmp = "";

		tmp += "<h2>" + item.getArticle_title() + "</h2>";
		tmp += "<p>";
		tmp += Utilities.decode(item.getArticle_content());
		tmp += "<p>";

		return tmp;
	}
}
