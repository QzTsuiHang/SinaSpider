package cn.climbDemo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.climbDemo.entity.BloggerInfo;
import cn.climbDemo.entity.BloggerTweet;
import cn.climbDemo.entity.BloggerTweetImageUrl;
import cn.climbDemo.entity.Video;
import cn.climbDemo.service.ShareVar;
import cn.climbDemo.service.ThreadParse;

public class ParseTool {

	/**
	 * 登录微博
	 */
	public void registTweet(WebDriver driver, String username, String password) {
		// 把浏览器最大化
		driver.manage().window().maximize();

		cssClear(driver, ShareVar.wbs.getClickAccountNumberRule());

		cssSendKeys(driver, ShareVar.wbs.getClickAccountNumberRule(), username);

		ShareVar.sleep(2000);

		cssClear(driver, ShareVar.wbs.getClickPasswordRule());

		cssSendKeys(driver, ShareVar.wbs.getClickPasswordRule(), password);

		ShareVar.sleep(2000);

		cssClick(driver, ShareVar.wbs.getClickRegisterRule());

		ShareVar.sleep(5000);
	}



	/**
	 * 获取博主信息
	 * 
	 * @param driver
	 */
	public BloggerInfo getBloggerInfo(WebDriver driver) {

		javaScriptDrop(driver, 0, 500);
		try {
			cssClick(driver, ShareVar.wbs.getClickAllTweetRule()); // 点击全部微博规则
		}catch(Exception e) {
			driver.findElement(By.linkText("全部")).click();
		}
		ShareVar.sleep(2000);
		BloggerInfo blogger = new BloggerInfo();

		String bloggerName = driver.findElement(By.cssSelector(ShareVar.wbs.getBloggerNameRule())).getText();
		sysout("博主名称：" + bloggerName);
		blogger.setId(ShareVar.getBloggerId());
		blogger.setBloggerName(bloggerName);

		String job = driver.findElement(By.cssSelector(ShareVar.wbs.getBloggerJobRule())).getText();
		sysout("博主工作：" + job);
		blogger.setBloggerJob(job);

		String attentionNumbe = driver.findElements(By.cssSelector(ShareVar.wbs.getBloggerAFTRule())).get(0).getText();
		String fansNumber = driver.findElements(By.cssSelector(ShareVar.wbs.getBloggerAFTRule())).get(1).getText();
		String tweetNumber = driver.findElements(By.cssSelector(ShareVar.wbs.getBloggerAFTRule())).get(2).getText();
		
		if(attentionNumbe != null && !(attentionNumbe.equals("")))
			blogger.setAttentionNumber(attentionNumbe);
		
		if(fansNumber != null && !(fansNumber.equals("")))
			blogger.setFansNumber(fansNumber);
	
		if(tweetNumber != null && !(tweetNumber.equals("")))
			blogger.setTweetNumber(tweetNumber);

		sysout("博主关注数：" + attentionNumbe);
		sysout("博主粉丝数：" + fansNumber);
		sysout("博主发出微博：" + tweetNumber);

		javaScriptDrop(driver, 0, 600);
		ShareVar.sleep(800);
		ShareVar.sleep(1500);
		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {

			int count = 10;
			
			for (int i = 0; i < count; i++) {
				BloggerTweet bloggerTweet = new BloggerTweet();
				WebElement element = null;
				try {
					List<WebElement> elements = driver.findElements(By.cssSelector(ShareVar.wbs.getTweetModuleRule()));
					count = elements.size();
					
					element = elements.get(i);
				} catch (Exception e) {

				}
				
				javaScriptLocatiom(driver, element); // 移到element的最顶部
				if(i == 12 || i==25 )
					ShareVar.sleep(3000);

				bloggerTweet.setId(ShareVar.getBloggetTweetId());
				bloggerTweet.setBId(blogger.getId());
				String tweetTitle = ""; // 微博标题
				try {

					element.findElement(By.cssSelector(ShareVar.wbs.getTweetClickFullTitleRule())).click(); // 点击展开全文规则
					ShareVar.sleep(1000);
					tweetTitle = element.findElements(By.cssSelector(ShareVar.wbs.getTweetTitleRule())).get(1).getText();
				} catch (Exception e) {
					tweetTitle = element.findElement(By.cssSelector(ShareVar.wbs.getTweetTitleRule())).getText();

				}
				if (tweetTitle == null || tweetTitle.equals(""))
					bloggerTweet.setTweetTitle("混杂");
				else
					bloggerTweet.setTweetTitle(tweetTitle);
				sysout("微博标题：" + tweetTitle);

				String time = element.findElement(By.cssSelector(ShareVar.wbs.getTweetTimeRule())).getText(); // 微博发出时间
				if(time != null && !time.equals("")) {
					bloggerTweet.setTweetTime(time);
					sysout("发出时间：" + time);
				}

				String videoUrl = null; // 视频url
				
				List<WebElement> imageUrlList = new ArrayList<WebElement>();// 图片List集合
				int imageNumber = 1; //图片名后缀
				try {
					
					videoUrl = element.findElement(By.cssSelector(ShareVar.wbs.getTweetVideoUrlRule())).getAttribute("src"); // 视频url
					if (videoUrl != null && !(videoUrl.equals(""))) {
						System.out.println(videoUrl);
						bloggerTweet.setTweetVideoUrl(videoUrl);
					}

					
					imageUrlList = element.findElements(By.cssSelector(ShareVar.wbs.getTweetImageUrlRule())); // 图片List集合
					for (WebElement image : imageUrlList) {
						BloggerTweetImageUrl tweetImage = new BloggerTweetImageUrl();
						tweetImage.setId(ShareVar.getImageId());
						tweetImage.setTId(bloggerTweet.getId());
						String imageUrl = image.getAttribute("src");
						
						if(bloggerTweet.getTweetTitle().length() > 15) {
							tweetImage.setImageName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle().substring(0,15) + "...(" + imageNumber++ + "))"));
						} else {
							tweetImage.setImageName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle() + "("  + imageNumber++ + ")"));
						}
						
						if (imageUrl != null && !(imageUrl.equals(""))) {
							tweetImage.setImageUrl(imageUrl);
							bloggerTweet.getTweetImageUrl().add(tweetImage);
							sysout(tweetImage.getImageUrl());
						}
					}
				} catch (Exception e) {
					imageUrlList = element.findElements(By.cssSelector(ShareVar.wbs.getTweetImageUrlRule())); // 图片List集合
					for (WebElement image : imageUrlList) {
						
						BloggerTweetImageUrl tweetImage = new BloggerTweetImageUrl();
						tweetImage.setId(ShareVar.getImageId());
						tweetImage.setTId(bloggerTweet.getId());
						String imageUrl = image.getAttribute("src");
						
						if(bloggerTweet.getTweetTitle().length() > 15) {
							tweetImage.setImageName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle().substring(0,15) + "...(" + imageNumber++ + "))"));
						} else {
							tweetImage.setImageName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle() + "("  + imageNumber++ + ")"));
						}
						
						
						if (imageUrl != null && !(imageUrl.equals(""))) {
							tweetImage.setImageUrl(imageUrl);
							bloggerTweet.getTweetImageUrl().add(tweetImage);
							sysout(tweetImage.getImageUrl());
						}
					}
				}
				if (videoUrl != null && !(videoUrl.equals("")) || imageUrlList.size() > 0) {
					if (bloggerTweet.getTweetTitle().length() > 15) {
						bloggerTweet.setTweetIVPath(ShareVar.wbs.getTweetIVPath() + blogger.getBloggerName() + "\\" +ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle().substring(0, 15)));
						bloggerTweet.setTweetVideoName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle().substring(0, 15) + "..."));
					} else {
						bloggerTweet.setTweetIVPath(ShareVar.wbs.getTweetIVPath() + blogger.getBloggerName() + "\\" + ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle()) );
						bloggerTweet.setTweetVideoName(ShareVar.strDenoising.pathIllegalCharacter(bloggerTweet.getTweetTitle()));
					}
				}

				String transpond = element.findElements(By.cssSelector(ShareVar.wbs.getTweetTCLNumberRule())).get(3).getText(); // 转发
				if (transpond != null && !(transpond.equals(""))) {
					bloggerTweet.setTranspondNumber(transpond);
					sysout("转发：" + transpond);
				}

				String comment = element.findElements(By.cssSelector(ShareVar.wbs.getTweetTCLNumberRule())).get(5).getText(); // 评论
				if (comment != null && !(comment.equals(""))) {
					bloggerTweet.setCommentNumber(comment);
					sysout("评论：" + comment);
				}

				String like = element.findElements(By.cssSelector(ShareVar.wbs.getTweetTCLNumberRule())).get(7).getText(); // 点赞
				if (like != null && !(like.equals(""))) {
					bloggerTweet.setLikeNumber(like);
					sysout("点赞：" + like);
				}
				sysout("保存位置："+ bloggerTweet.getTweetIVPath());

				blogger.getBlogerTweetSet().add(bloggerTweet);

				sysout("");
				sysout("");
				sysout("");
				sysout("");
				sysout("");
				
				sysout("图片长度:" + bloggerTweet.getTweetImageUrl().size());
			}

			if (number != ShareVar.wbs.getPagenumber()) {
				javaScriptDownmost(driver);
				try {
					xpathClick(driver, ShareVar.wbs.getTweetNextRule());
				} catch (Exception e){
					driver.findElement(By.linkText("下一页")).click();
				}
				ShareVar.sleep(5000);
			}
		}
		sysout("微博长度:" + blogger.getBlogerTweetSet().size());
		
		return blogger;
	}

	/**
	 * 获取文章url集合
	 */
	public Set<String> getArticleSet(WebDriver driver) {

		ShareVar.sleep(2000);
		Set<String> articleSet = new HashSet<String>();
		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {
			articleSet.addAll(xpathGetTypesValue(driver, ShareVar.wbs.getGetArticleUrlRule(), "href"));

			if (number != ShareVar.wbs.getPagenumber())
				xpathClick(driver, ShareVar.wbs.getNextArticleRule());
		}

		return articleSet;
	}

	/**
	 * 获取视频
	 */
	public Set<Video> getVideoList(WebDriver driver, String keyword) {

		ShareVar.sleep(2000);
		Set<Video> videoSet = new HashSet<Video>();
		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {
			videoSet.addAll(xpathGetVideoInfo(driver, keyword));

			if (number != ShareVar.wbs.getPagenumber())
				xpathClick(driver, ShareVar.wbs.getNextVideoRule());

		}

		return videoSet;
	}

	/**
	 * 获取video信息
	 * 
	 * @param driver
	 * @param videoNameRule
	 * @param videoImageUrlRule
	 * @param videoUrlRule
	 * @return
	 */
	private Set<Video> xpathGetVideoInfo(WebDriver driver, String keyword) {
		Set<Video> videoSet = new HashSet<Video>();

		List<WebElement> elements = driver.findElements(By.xpath(ShareVar.wbs.getVideoModuleRule()));

		for (WebElement element : elements) {
			
			if(element != null)
				javaScriptLocatiom(driver, element);
			
			Video video = new Video();
			sysout();
			sysout();

		
			String videoTitle = null;
			try {
				element.findElement(By.cssSelector(ShareVar.wbs.getVideoClickFullTitleRule())).click();
				ShareVar.sleep(1000);
				videoTitle = element.findElements(By.cssSelector(ShareVar.wbs.getVideoTitleRule())).get(1).getText();
			} catch (Exception e) {
				videoTitle = element.findElement(By.cssSelector(ShareVar.wbs.getVideoTitleRule())).getText();
			}
			if(videoTitle != null && !(videoTitle.equals(""))) {
				video.setVideoName(videoTitle);
				sysout(videoTitle);
			}
			
			
			String videoImageUrl = element.findElement(By.cssSelector(ShareVar.wbs.getVideoImageUrlRule())).getAttribute("src");
			if(videoImageUrl != null && !(videoImageUrl.equals(""))) {
				video.setVideoImageUrl(videoImageUrl);
				sysout(videoImageUrl);
			}
			
			
			String videoUrl =  element.findElement(By.cssSelector(ShareVar.wbs.getVideoUrlRule())).getAttribute("src");
			if( videoUrl != null && !(videoUrl.equals(""))) {
				video.setVideoUrl(videoUrl);
				sysout(videoUrl);
			}
			
			String transpond = null;
			String comment = null;
			String like = null;
			try {
				transpond = element.findElements(By.cssSelector(ShareVar.wbs.getVideoTCLNumberRrule())).get(0).getText();
				comment = element.findElements(By.cssSelector(ShareVar.wbs.getVideoTCLNumberRrule())).get(1).getText();
				like = element.findElements(By.cssSelector(ShareVar.wbs.getVideoTCLNumberRrule())).get(2).getText();
			}catch(Exception e) {
				
			}
		
			if(transpond!= null && !(transpond.equals(""))) {
				video.setVideoTranspondNumber(transpond);
			}
			if(comment!= null && !(comment.equals(""))) {
				video.setVideoCommentNumber(comment);
			}
			if(like!= null && !(like.equals(""))) {
				video.setVideoLikeNumber(like);
			}

			videoSet.add(video);

			if (video.getVideoName().length() > 15 && video.getVideoUrl() != null && !(video.getVideoUrl().equals(""))
					|| video.getVideoImageUrl() != null && !(video.getVideoImageUrl().equals(""))) {
		
				video.setVideoPath((ShareVar.wbs.getVideoPath() + keyword + "\\" + video.getVideoName().substring(0, 15) + "...").replaceAll(" ", ""));
			
			} else if (video.getVideoName().length() > 15 && video.getVideoUrl() != null
					&& !(video.getVideoUrl().equals(""))
					|| video.getVideoImageUrl() != null && !(video.getVideoImageUrl().equals(""))) {
				video.setVideoPath((ShareVar.wbs.getVideoPath() + keyword + "\\" + video.getVideoName()).replaceAll(" ", ""));
			}
			sysout(video.getVideoPath());
			sysout();
			sysout();
			sysout();
			sysout();
		}

		return videoSet;

	}

	/**
	 * 打印
	 * 
	 * @param strings
	 */
	public void sysout(String... strings) {
		for (String string : strings) {
			System.out.println(string);
		}
	}

	/**
	 * 获取话题url规则
	 */
	public Set<String> getTopicSet(WebDriver driver) {

		ShareVar.sleep(2000);

		Set<String> topicUrlSet = xpathGetTypesValue(driver, ShareVar.wbs.getGetTopicRule(), "href");

		return topicUrlSet;
	}

	
	/**
	 * 开始解析微博信息
	 */
	public void parseTweetInfo() {
		// 下载视频线程池
		// ExecutorService parse = Executors.newFixedThreadPool(15);
		if(ShareVar.bloggerSet.size() > 0 ) {
			for (BloggerInfo bloggerinfo : ShareVar.bloggerSet) {
					
				// 把博主信息插入进去
				ShareVar.opMysql.insertBloggerInfo(bloggerinfo);
				
				ThreadParse threadParse = new ThreadParse(bloggerinfo);
				threadParse.parse();
			//	parse.execute(threadParse);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * js单次下拉操作
	 */
	public void javaScriptDrop(WebDriver driver, int start, int spacin) {

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

		jsDriver.executeScript("window.scrollTo(" + start + "," + spacin + ")");

		ShareVar.sleep(1500);

	}

	/**
	 * 拉到页面最底部
	 */
	public void javaScriptDownmost(WebDriver driver) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ShareVar.sleep(1500);
	}

	/**
	 * 拉到页面指定位置
	 */
	public void javaScriptLocatiom(WebDriver driver, WebElement element) {
		
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		try {
			jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch(Exception e) {
			jsDriver.executeScript("arguments[0].scrollIntoView(false);", element);
		}
		ShareVar.sleep(1500);
	}

	/**
	 * css规则清空事件
	 * 
	 * @param rule
	 *            需要清空地方的规则
	 */
	public void cssClear(WebDriver driver, String cssRule) {
		driver.findElement(By.cssSelector(cssRule)).clear();
	}

	/**
	 * css规则输入关键字
	 * 
	 * @param rule
	 *            需要输入关键字地方的规则
	 * @param keyword
	 *            关键字
	 */
	public void cssSendKeys(WebDriver driver, String cssRule, String keyword) {
		driver.findElement(By.cssSelector(cssRule)).sendKeys(keyword);
	}

	/**
	 * css规则单击事件
	 * 
	 * @param cssRule
	 */
	public void cssClick(WebDriver driver, String cssRule) {
		driver.findElement(By.cssSelector(cssRule)).click();
		ShareVar.sleep(3000);
	}

	/**
	 * xpath单击事件
	 */
	public void xpathClick(WebDriver driver, String xpathRule) {
		driver.findElement(By.xpath(xpathRule)).click();
		ShareVar.sleep(1500);
	}

	/**
	 * xpath获取属性值
	 * 
	 * @param typeRule
	 *            获取属性地方的规则
	 * @param typeName
	 *            属性名称
	 */
	public String xpathGetTypeVaule(WebDriver driver, String typeRule, String typeName) {
		String typeValue = driver.findElement(By.xpath(typeRule)).getAttribute(typeName);
		return typeValue;
	}

	/**
	 * css获取属性值
	 * 
	 * @param typeRule
	 *            获取属性地方的规则
	 * @param typeName
	 *            属性名称
	 */
	public String cssGetTypeVaule(WebDriver driver, String typeRule, String typeName) {
		String typeValue = driver.findElement(By.cssSelector(typeRule)).getAttribute(typeName);
		return typeValue;
	}
	
	/**
	 * 获取属性里面的多个值
	 * 
	 * @param typeRule
	 *            规则
	 * @param typeName
	 *            属性名称
	 * @return
	 */
	public Set<String> xpathGetTypesValue(WebDriver driver, String typeRule, String typeName) {

		Set<String> typeValueSet = new HashSet<String>();
		List<WebElement> elements = driver.findElements(By.xpath(typeRule));
		for (WebElement element : elements) {
			String value = element.getAttribute(typeName);
			if (value != null && !(value.equals("")))
				typeValueSet.add(value);
		}

		return typeValueSet;

	}

}
