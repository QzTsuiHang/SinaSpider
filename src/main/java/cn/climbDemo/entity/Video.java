package cn.climbDemo.entity;

public class Video {
	
	
	private int id;	//编号
	private String videoModuleRule; //获取video模块规则
	private String videoName; 	  //视频名称
	private String videoImageUrl; //视频图片链接
	private String videoUrl;	//视频链接
	private String videoPath;	// 视频存储位置
	private String videoTranspondNumber;	// 视频转发数
	private String videoCommentNumber;		// 视频评论数
	private String videoLikeNumber;		// 视频点赞数
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	
	public String getVideoTranspondNumber() {
		return videoTranspondNumber;
	}
	public void setVideoTranspondNumber(String videoTranspondNumber) {
		this.videoTranspondNumber = videoTranspondNumber;
	}
	public String getVideoCommentNumber() {
		return videoCommentNumber;
	}
	public void setVideoCommentNumber(String videoCommentNumber) {
		this.videoCommentNumber = videoCommentNumber;
	}
	public String getVideoLikeNumber() {
		return videoLikeNumber;
	}
	public void setVideoLikeNumber(String videoLikeNumber) {
		this.videoLikeNumber = videoLikeNumber;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoImageUrl() {
		return videoImageUrl;
	}
	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoModuleRule() {
		return videoModuleRule;
	}
	public void setVideoModuleRule(String videoModuleRule) {
		this.videoModuleRule = videoModuleRule;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	
}
