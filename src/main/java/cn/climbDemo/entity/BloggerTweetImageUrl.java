package cn.climbDemo.entity;


/**
 * 博主发出微博的图片url类
 *
 */
public class BloggerTweetImageUrl {

	private int id;
	private int tId;
	private String imageUrl;
	private String imageName;
	
	
	public int getTId() {
		return tId;
	}
	public void setTId(int tId) {
		this.tId = tId;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
