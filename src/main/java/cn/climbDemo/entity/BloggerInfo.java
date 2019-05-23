package cn.climbDemo.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 博主信息表
 * 
 *
 */
public class BloggerInfo {

	private int id;
	private String bloggerName; //博主名称
	private String bloggerJob;	//博主职业
	private String attentionNumber;//博主关注数
	private String fansNumber;		//博主粉丝数
	private String tweetNumber;	//发出微博数量
	private Set<BloggerTweet> blogerTweetSet = new LinkedHashSet<>(); //博主微博
	
	
	public Set<BloggerTweet> getBlogerTweetSet() {
		return blogerTweetSet;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloggerName() {
		return bloggerName;
	}
	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}
	public String getBloggerJob() {
		return bloggerJob;
	}
	public void setBloggerJob(String bloggerJob) {
		this.bloggerJob = bloggerJob;
	}
	public String getAttentionNumber() {
		return attentionNumber;
	}
	public void setAttentionNumber(String attentionNumber) {
		this.attentionNumber = attentionNumber;
	}
	public String getFansNumber() {
		return fansNumber;
	}
	public void setFansNumber(String fansNumber) {
		this.fansNumber = fansNumber;
	}
	public String getTweetNumber() {
		return tweetNumber;
	}
	public void setTweetNumber(String tweetNumber) {
		this.tweetNumber = tweetNumber;
	}

	
}
