package cn.climbDemo.entity;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * 本类为博主发出微博信息类
 *
 */
public class BloggerTweet {

	private int id;
	private int bId; // 博主id与bolger类的id相对应
	private String tweetTitle;	//微博标题
	private String tweetTime;	//微博发出时间
	private String tweetVideoUrl;	//视频url
	private String tweetVideoName;	//视频名称
	private Set<BloggerTweetImageUrl> tweetImageUrl = new LinkedHashSet<BloggerTweetImageUrl>(); // 图片url
	private String transpondNumber;	//微博转发数
	private String commentNumber;	//微博评论数
	private String likeNumber;		//微博点赞数
	
	private String tweetIVPath;		//微博视频图片存放位置
	
	
	
	public String getTweetVideoName() {
		return tweetVideoName;
	}
	public void setTweetVideoName(String tweetVideoName) {
		this.tweetVideoName = tweetVideoName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBId() {
		return bId;
	}
	public void setBId(int bId) {
		this.bId = bId;
	}
	public String getTweetTitle() {
		return tweetTitle;
	}
	public void setTweetTitle(String tweetTitle) {
		this.tweetTitle = tweetTitle;
	}
	public String getTweetTime() {
		return tweetTime;
	}
	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
	}
	
	public Set<BloggerTweetImageUrl> getTweetImageUrl() {
		return tweetImageUrl;
	}
	public String getTweetVideoUrl() {
		return tweetVideoUrl;
	}
	public void setTweetVideoUrl(String tweetVideoUrl) {
		this.tweetVideoUrl = tweetVideoUrl;
	}
	public String getTranspondNumber() {
		return transpondNumber;
	}
	public void setTranspondNumber(String transpondNumber) {
		this.transpondNumber = transpondNumber;
	}
	public String getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(String likeNumber) {
		this.likeNumber = likeNumber;
	}
	public String getTweetIVPath() {
		return tweetIVPath;
	}
	public void setTweetIVPath(String tweetIVPath) {
		this.tweetIVPath = tweetIVPath;
	}
	
	
}
