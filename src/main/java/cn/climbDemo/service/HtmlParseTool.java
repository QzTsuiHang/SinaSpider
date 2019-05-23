package cn.climbDemo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.climbDemo.dao.ParseTool;
import cn.climbDemo.entity.BloggerInfo;
import cn.climbDemo.entity.Keywords;
import cn.climbDemo.entity.Video;
import sun.misc.BASE64Decoder;

public class HtmlParseTool {

	private static String driverKey = "webdriver.chrome.driver";
	private String driverValue;
	private List<Keywords> keywords = ShareVar.opMysql.queryKeyWord(); // 获取关键字
	private ParseTool parsetool = new ParseTool();
	private String username;
	private String password;

	private HtmlParseTool() {
		readUserInfo(); // 读取用户信息
		readDriverInfo(); // 读取WebDriver信息
	}

	/**
	 * 用作判断是找人、文章、视频、话题
	 * @param driver
	 * @param keywords
	 */
	private void judgeSerchWhere(WebDriver driver,Keywords keywords) {
		int type = keywords.getSerchWhere();
		switch(type) {
		case 1 :{ 
					parsetool.xpathClick(driver, ShareVar.wbs.getClickLookPersonRule());
					ShareVar.sleep(3000);
					String url = null;
					try {													
						url = parsetool.cssGetTypeVaule(driver, ShareVar.wbs.getCssGetPersonUrlRule(), "href"); // 获取博主 url
					} catch(Exception e) {
						url = parsetool.xpathGetTypeVaule(driver, ShareVar.wbs.getXpathGetPersonUrlRule(), "href");
					}

					driver.get(url); // 打开博主
					ShareVar.sleep(5000);
					
					BloggerInfo bloggerInfo = parsetool.getBloggerInfo(driver);

					if (bloggerInfo != null)
						ShareVar.bloggerSet.add(bloggerInfo);
				break;
				}
				
		case 2: {
					// 单击文章
					parsetool.xpathClick(driver, ShareVar.wbs.getArticleRule());

						Set<String> articleSet = parsetool.getArticleSet(driver);

						if (articleSet != null && articleSet.size() > 0)
							ShareVar.articleSet.addAll(articleSet);
				}
				break;
	
		case 3: {
					parsetool.xpathClick(driver, ShareVar.wbs.getClickVideoRule());

					Set<Video> videoList = parsetool.getVideoList(driver,keywords.getKeyword());
					if (videoList != null && videoList.size() > 0)
						ShareVar.videoSet.addAll(videoList);
				}
				break;
		
		case 4: {
			
				}
				break;
	
		case 5: {
					parsetool.xpathClick(driver, ShareVar.wbs.getTopicRule());

						Set<String> topicSet = parsetool.getTopicSet(driver);

							if (topicSet != null && topicSet.size() > 0)
									ShareVar.topicSet.addAll(topicSet);
				}
				break;
	}
	}
	
	
	/**
	 * 在搜索框输入关键字进行搜素
	 * @param driver
	 * @param bloggerName 要搜索的关键字
	 */
	private void searchBloggerName(WebDriver driver ,String bloggerName) {
		
		// css规则清空
		parsetool.cssClear(driver, ShareVar.wbs.getSearchInputRule());
		
		// css规则输入关键字
		parsetool.cssSendKeys(driver, ShareVar.wbs.getSearchInputRule(), bloggerName);
	
		// css规则单击事件
		parsetool.cssClick(driver, ShareVar.wbs.getClickSearchRule());
		
		// 睡眠
		ShareVar.sleep(2000);
	}
	
	private void startParseHtml() {

		 System.setProperty(driverKey, "E:\\Google\\Chrome\\Application\\chromedriver.exe");
		 // System.setProperty(driverKey, driverValue);

		WebDriver driver = new ChromeDriver();

		if (ShareVar.wbs != null) {
			driver.get(ShareVar.wbs.getCrawerUrl());
			ShareVar.sleep(6000);

			parsetool.registTweet(driver, username, password); // 登录微博

			for (Keywords keywords : keywords) {
				if (keywords.getKeyword() != null && !(keywords.getKeyword().equals(""))) {

					searchBloggerName(driver,keywords.getKeyword()); 
					
					judgeSerchWhere(driver,keywords);

				}
			}
		}
		driver.quit();
		
		parsetool.parseTweetInfo();
		
		
	}

	/**
	 * 读取WebDriver位置
	 */
	private void readDriverInfo() {
		// 设置浏览器驱动的位置，很重要，不然打开的话可能是空白页
		this.driverValue = System.getProperty("user.dir");
		this.driverValue += "\\driver\\chromedriver.exe";

	}

	/**
	 * 读取用户信息
	 * 
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private void readUserInfo() {
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = bdf.newDocumentBuilder();
			Document document = db.parse(new File("user.xml"));
			NodeList list = document.getElementsByTagName("user1");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				this.username = element.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
				this.password = decode(element.getElementsByTagName("password").item(0).getFirstChild().getNodeValue());
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	private String decode(String str) {
		byte[] bt = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bt);
	}

	public static void start() {

		HtmlParseTool hpt = new HtmlParseTool();
		hpt.startParseHtml();
		
	
	}
}