/**
 * 
 */
package haui.ads.article;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Article extends ShareControl {
	public boolean addArticle(ArticleObject item);
	public boolean editArticle(ArticleObject item);
	public boolean delArticle(ArticleObject item);
	
	public ResultSet getArticle(int id);
	public ResultSet getArticle(int id, boolean isUpdated);
	
	public ResultSet getArticles(ArticleObject similar,int at, byte total);
}
