package cn.climbDemo.entity;

/**
 * 本类为采集微博规则类
 * 
 *
 */
public class WebSite {
		
	private int id;  				//编号
	private String crawerUrl;	    //要打开的网址
	
	private String clickAccountNumberRule; //点击账号规则
	private String clickPasswordRule;   // 点击密码规则
	private String clickRegisterRule;   //点击登录规则
	
	private String searchInputRule;	//搜索框规则
	private String clickSearchRule;	    //点击搜索规则
	
	private String clickLookPersonRule; //点击找人规则
	private String cssGetPersonUrlRule;  //css获取查询博主url规则
	private String xpathGetPersonUrlRule;//xpath获取查询博主url规则
	
	private String clickAllTweetRule; //点击全部微博规则
	private String bloggerNameRule; //博主名称规则
	private String bloggerJobRule;	//博主工作规则
	private String bloggerAFTRule;	//博主关注、粉丝、微博数量规则
	private String tweetModuleRule;	//微博模块规则
	private String tweetClickFullTitleRule;	//微博点击全文规则
	private String tweetTitleRule;	//微博标题规则
	private String tweetTimeRule;	//微博发出时间规则
	private String tweetImageUrlRule;	//微博图片规则
	private String tweetVideoUrlRule;	//微博视频规则
	private String tweetTCLNumberRule;	//微博转发评论点赞规则
	private String tweetIVPath;		//微博图片视频存放位置
	private String tweetNextRule;	//博主微博下一页规则
	
	

	
	private String articleRule;    //点击文章规则
	private String getArticleUrlRule; //获取文章规则
	private String nextArticleRule;//点击文章下一页规则
	private String articleTitleRule; //文章标题规则
	private String articleAuthorRule;//文章作者规则
	private String articleTimeRule;  //文章发布时间规则
	private String articleSourceUrlRule; //文章源网址规则
	private String articleReadNumber;	//文章阅读数规则
	private String articleContenrRule; //文章内容规则
	private String articleTCLRule;	//文章转发、评论、点赞规则
	
	
	
	
	private String clickVideoRule;	   //点击视频规则
	private String videoModuleRule;	   // 获取video模块规则
	
	private String videoClickFullTitleRule; // 点击视频名称点开全文规则
	private String videoTitleRule;  //获取视频标题规则
	private String videoImageUrlRule; //获取视频图片url规则
	private String videoUrlRule;   //获取视频链接规则
	private String videoTCLNumberRrule;	//视频转发评论点赞数量规则
	private String videoPath;	//视频存放位置
	private String nextVideoRule;  //点击视频下一页规则

	

	private String imageRule;	   //点击图片规则
	private String getImageRule;   //获取图片规则
	
	private String topicRule; 	   //点击话题规则
	private String getTopicRule;   //获取话题规则
	
	private int pagenumber;	   //采集页数


	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public String getArticleTitleRule() {
		return articleTitleRule;
	}


	public String getVideoClickFullTitleRule() {
		return videoClickFullTitleRule;
	}

	public void setVideoClickFullTitleRule(String videoClickFullTitleRule) {
		this.videoClickFullTitleRule = videoClickFullTitleRule;
	}


	public void setArticleTitleRule(String articleTitleRule) {
		this.articleTitleRule = articleTitleRule;
	}

	public String getArticleAuthorRule() {
		return articleAuthorRule;
	}

	public void setArticleAuthorRule(String articleAuthorRule) {
		this.articleAuthorRule = articleAuthorRule;
	}

	public String getArticleTimeRule() {
		return articleTimeRule;
	}

	public void setArticleTimeRule(String articleTimeRule) {
		this.articleTimeRule = articleTimeRule;
	}

	public String getArticleSourceUrlRule() {
		return articleSourceUrlRule;
	}

	public void setArticleSourceUrlRule(String articleSourceUrlRule) {
		this.articleSourceUrlRule = articleSourceUrlRule;
	}

	public String getArticleReadNumber() {
		return articleReadNumber;
	}

	public void setArticleReadNumber(String articleReadNumber) {
		this.articleReadNumber = articleReadNumber;
	}

	public String getArticleContenrRule() {
		return articleContenrRule;
	}

	public void setArticleContenrRule(String articleContenrRule) {
		this.articleContenrRule = articleContenrRule;
	}

	public String getArticleTCLRule() {
		return articleTCLRule;
	}

	public void setArticleTCLRule(String articleTCLRule) {
		this.articleTCLRule = articleTCLRule;
	}

	public String getClickAllTweetRule() {
		return clickAllTweetRule;
	}

	public void setClickAllTweetRule(String clickAllTweetRule) {
		this.clickAllTweetRule = clickAllTweetRule;
	}

	public String getTweetNextRule() {
		return tweetNextRule;
	}

	public void setTweetNextRule(String tweetNextRule) {
		this.tweetNextRule = tweetNextRule;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getCrawerUrl() {
		return crawerUrl;
	}

	


	public String getTweetClickFullTitleRule() {
		return tweetClickFullTitleRule;
	}

	public void setTweetClickFullTitleRule(String tweetClickFullTitleRule) {
		this.tweetClickFullTitleRule = tweetClickFullTitleRule;
	}

	public void setCrawerUrl(String crawerUrl) {
		this.crawerUrl = crawerUrl;
	}


	
	public String getTweetModuleRule() {
		return tweetModuleRule;
	}

	public void setTweetModuleRule(String tweetModuleRule) {
		this.tweetModuleRule = tweetModuleRule;
	}

	public String getBloggerNameRule() {
		return bloggerNameRule;
	}
	
	public String getBloggerAFTRule() {
		return bloggerAFTRule;
	}

	public void setBloggerAFTRule(String bloggerAFTRule) {
		this.bloggerAFTRule = bloggerAFTRule;
	}

	public void setBloggerNameRule(String bloggerNameRule) {
		this.bloggerNameRule = bloggerNameRule;
	}

	public String getBloggerJobRule() {
		return bloggerJobRule;
	}

	public void setBloggerJobRule(String bloggerJobRule) {
		this.bloggerJobRule = bloggerJobRule;
	}

	

	public String getTweetTitleRule() {
		return tweetTitleRule;
	}

	public void setTweetTitleRule(String tweetTitleRule) {
		this.tweetTitleRule = tweetTitleRule;
	}

	public String getTweetTimeRule() {
		return tweetTimeRule;
	}

	public void setTweetTimeRule(String tweetTimeRule) {
		this.tweetTimeRule = tweetTimeRule;
	}

	

	public String getTweetImageUrlRule() {
		return tweetImageUrlRule;
	}

	public void setTweetImageUrlRule(String tweetImageUrlRule) {
		this.tweetImageUrlRule = tweetImageUrlRule;
	}

	public String getTweetVideoUrlRule() {
		return tweetVideoUrlRule;
	}

	public void setTweetVideoUrlRule(String tweetVideoUrlRule) {
		this.tweetVideoUrlRule = tweetVideoUrlRule;
	}

	
	public String getTweetTCLNumberRule() {
		return tweetTCLNumberRule;
	}

	public void setTweetTCLNumberRule(String tweetTCLNumberRule) {
		this.tweetTCLNumberRule = tweetTCLNumberRule;
	}

	

	public String getVideoTCLNumberRrule() {
		return videoTCLNumberRrule;
	}

	public void setVideoTCLNumberRrule(String videoTCLNumberRrule) {
		this.videoTCLNumberRrule = videoTCLNumberRrule;
	}

	public String getTweetIVPath() {
		return tweetIVPath;
	}

	public void setTweetIVPath(String tweetIVPath) {
		this.tweetIVPath = tweetIVPath;
	}



	public String getSearchInputRule() {
		return searchInputRule;
	}

	public void setSearchInputRule(String searchInputRule) {
		this.searchInputRule = searchInputRule;
	}


	public String getClickAccountNumberRule() {
		return clickAccountNumberRule;
	}

	public void setClickAccountNumberRule(String clickAccountNumberRule) {
		this.clickAccountNumberRule = clickAccountNumberRule;
	}

	public String getClickPasswordRule() {
		return clickPasswordRule;
	}

	public void setClickPasswordRule(String clickPasswordRule) {
		this.clickPasswordRule = clickPasswordRule;
	}

	public String getClickRegisterRule() {
		return clickRegisterRule;
	}

	public void setClickRegisterRule(String clickRegisterRule) {
		this.clickRegisterRule = clickRegisterRule;
	}

	public String getClickSearchRule() {
		return clickSearchRule;
	}

	public void setClickSearchRule(String clickSearchRule) {
		this.clickSearchRule = clickSearchRule;
	}

	public String getClickLookPersonRule() {
		return clickLookPersonRule;
	}

	public void setClickLookPersonRule(String clickLookPersonRule) {
		this.clickLookPersonRule = clickLookPersonRule;
	}

	public String getCssGetPersonUrlRule() {
		return cssGetPersonUrlRule;
	}

	public void setCssGetPersonUrlRule(String cssGetPersonUrlRule) {
		this.cssGetPersonUrlRule = cssGetPersonUrlRule;
	}

	public String getXpathGetPersonUrlRule() {
		return xpathGetPersonUrlRule;
	}

	public void setXpathGetPersonUrlRule(String xpathGetPersonUrlRule) {
		this.xpathGetPersonUrlRule = xpathGetPersonUrlRule;
	}

	public String getArticleRule() {
		return articleRule;
	}

	public void setArticleRule(String articleRule) {
		this.articleRule = articleRule;
	}

	public String getGetArticleUrlRule() {
		return getArticleUrlRule;
	}

	public void setGetArticleUrlRule(String getArticleUrlRule) {
		this.getArticleUrlRule = getArticleUrlRule;
	}

	public String getNextArticleRule() {
		return nextArticleRule;
	}

	public void setNextArticleRule(String nextArticleRule) {
		this.nextArticleRule = nextArticleRule;
	}

	public String getClickVideoRule() {
		return clickVideoRule;
	}

	public void setClickVideoRule(String clickVideoRule) {
		this.clickVideoRule = clickVideoRule;
	}

	public String getVideoModuleRule() {
		return videoModuleRule;
	}

	public void setVideoModuleRule(String videoModuleRule) {
		this.videoModuleRule = videoModuleRule;
	}

	
	
	public String getVideoTitleRule() {
		return videoTitleRule;
	}

	public void setVideoTitleRule(String videoTitleRule) {
		this.videoTitleRule = videoTitleRule;
	}

	

	public String getVideoImageUrlRule() {
		return videoImageUrlRule;
	}

	public void setVideoImageUrlRule(String videoImageUrlRule) {
		this.videoImageUrlRule = videoImageUrlRule;
	}

	public String getVideoUrlRule() {
		return videoUrlRule;
	}

	public void setVideoUrlRule(String videoUrlRule) {
		this.videoUrlRule = videoUrlRule;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getNextVideoRule() {
		return nextVideoRule;
	}

	public void setNextVideoRule(String nextVideoRule) {
		this.nextVideoRule = nextVideoRule;
	}

	public String getImageRule() {
		return imageRule;
	}

	public void setImageRule(String imageRule) {
		this.imageRule = imageRule;
	}

	public String getGetImageRule() {
		return getImageRule;
	}

	public void setGetImageRule(String getImageRule) {
		this.getImageRule = getImageRule;
	}

	public String getTopicRule() {
		return topicRule;
	}

	public void setTopicRule(String topicRule) {
		this.topicRule = topicRule;
	}

	public String getGetTopicRule() {
		return getTopicRule;
	}

	public void setGetTopicRule(String getTopicRule) {
		this.getTopicRule = getTopicRule;
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

		
	
}
