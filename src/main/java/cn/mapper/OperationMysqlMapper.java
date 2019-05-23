package cn.mapper;

import java.util.List;

import cn.climbDemo.entity.BloggerInfo;
import cn.climbDemo.entity.BloggerTweet;
import cn.climbDemo.entity.BloggerTweetImageUrl;
import cn.climbDemo.entity.Keywords;
import cn.climbDemo.entity.WebSite;

public interface OperationMysqlMapper {

	/**
	 * 获取规则
	 */
	WebSite getWebSite();
	
	/**
	 * 获取关键字
	 */
	List<Keywords> queryKeyWords();
	
	/**
	 * 插入博主信息
	 */
	void insertBloggerInfo(BloggerInfo bloggerInfo);
	
	/**
	 * 插入博主发出微博信息
	 * @param bloggerTweet
	 */
	void insertBloggerTweet(BloggerTweet bloggerTweet);
	
	/**
	 * 插入博主发出微博的图片链接
	 * @param bloggerTweetImageUrl
	 */
	void insertBloggerTweetImageUrl(BloggerTweetImageUrl bloggerTweetImageUrl);
	
	
	
	
	void updateKeyWord(int id);
	
	void updateKeyWords();
	
}
