package cn.climbDemo.service;

import java.util.LinkedHashSet;
import java.util.Set;

import cn.climbDemo.dao.OperationMongodb;
import cn.climbDemo.dao.OperationMysql;
import cn.climbDemo.entity.BloggerInfo;
import cn.climbDemo.entity.BloggerTweetImageUrl;
import cn.climbDemo.entity.Video;
import cn.climbDemo.entity.WebSite;

/**
 * 本类提供一些公用变量和公共方法
 * 
 */
public class ShareVar {

	
	
	// 字符操作类
	public static StringDenoising strDenoising = new StringDenoising();

	// 操作MySQL数据库
	public static OperationMysql opMysql = new OperationMysql();

	// 操作Mongodb数据库
	public static OperationMongodb opMongoDB = new OperationMongodb();
	
	
	
	public static Set<BloggerInfo> bloggerSet = new LinkedHashSet<BloggerInfo>();// 博主信息集合
	private static int bloggerId=1; // 博主id
	public synchronized static int getBloggerId() {
		int id = bloggerId;
		bloggerId++;
		return id;
	}
	private static int bloggetTweetId = 1; //博主微博id
	public synchronized static int getBloggetTweetId() {
		int id =bloggetTweetId;
		bloggetTweetId++;
		return id;
	}
	

	




	// 视频集合
	public static Set<Video> videoSet = new LinkedHashSet<Video>();
	private static int videoId = 1; //视频id
	public synchronized static int getVideoId() {
		int id = videoId;
		videoId++;
		return id;
	}


	public static Set<BloggerTweetImageUrl> imageSet = new LinkedHashSet<BloggerTweetImageUrl>(); // 图片集合
	// public static Set<String> imageSet = new LinkedHashSet<String>(); // 图片集合
	private static int imageId = 1; //图片id
	public synchronized static int getImageId() {
		int id = imageId;
		imageId++;
		return id;
	}
	
	
	
	// 文章集合
	public static Set<String> articleSet = new LinkedHashSet<String>();
			
	// 话题集合
	public static Set<String> topicSet = new LinkedHashSet<String>();
			
	// 规则
	public static WebSite wbs = opMysql.getWebSite(); // 获取规则
	
	/**
	 * 让线程睡眠
	 * 
	 * @param time
	 *            需要睡眠的时间
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
