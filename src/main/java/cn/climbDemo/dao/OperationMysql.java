package cn.climbDemo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.climbDemo.entity.BloggerInfo;
import cn.climbDemo.entity.BloggerTweet;
import cn.climbDemo.entity.BloggerTweetImageUrl;
import cn.climbDemo.entity.Keywords;
import cn.climbDemo.entity.WebSite;
import cn.mapper.OperationMysqlMapper;


public class OperationMysql {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private OperationMysqlMapper mysqlMappe;
	// private Jedis jedis = new Jedis("localhost",6380);
	
	public OperationMysql() {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		// 获取sqlSession，和spring整合后由spring管理
		sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		mysqlMappe = sqlSession.getMapper(OperationMysqlMapper.class);
	}

	/**
	 * 查询WebSite里面的所有规则
	 * 
	 * @return WebSite 里面所有规则
	 */
	public WebSite getWebSite() {
		// 执行查询方法
		WebSite wbs = mysqlMappe.getWebSite();
		return wbs;
	}

	/**
	 * 获取关键字
	 * 
	 * @return 关键字 List 集合
	 */
	public List<Keywords> queryKeyWord() {
		List<Keywords> keywords = mysqlMappe.queryKeyWords();
		return keywords;
	}


	/**
	 * 插入博主信息
	 * 
	 * @param blgggerInfo
	 */
	public synchronized void insertBloggerInfo(BloggerInfo blgggerInfo) {
		mysqlMappe.insertBloggerInfo(blgggerInfo);
		sqlSession.commit();
	}

	
	/**
	 * 插入博主发出微博
	 */
	public synchronized void insertBloggerTweet(BloggerTweet bloggerTweet) {
		mysqlMappe.insertBloggerTweet(bloggerTweet);
		sqlSession.commit();
	}
	
	/**
	 * 插入博主发出信息的图片
	 */
	public synchronized void insertBloggerTweetImageUrl(BloggerTweetImageUrl bloggerTweetImageUrl) {
		mysqlMappe.insertBloggerTweetImageUrl(bloggerTweetImageUrl);
		sqlSession.commit();
	}
	
	
	/**
	 * 关闭mysql服务器
	 */
	public void closeMySQL() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	
	
//	/**
//	 * 获取 Redis 数据库里面的所有Url
//	 * 
//	 * @return
//	 */
//	public Jedis setUrlList() {
//		Set<String> hkeys = jedis.hkeys("urls");
//		for (String string : hkeys) {
//			jedis.set(string, "urlList");
//		}
//		return jedis;
//	}
	
//	public void insertUrlList() {
//		
//	}
	
}
