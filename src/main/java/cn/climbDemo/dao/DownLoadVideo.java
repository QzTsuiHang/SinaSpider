package cn.climbDemo.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * 本类作为下载视频
 * 
 *
 */
public class DownLoadVideo implements Runnable {

	private String folderPath;
	private String fileName;
	private String url;

	public DownLoadVideo(String folderPath,String fileName,String url) {
		this.folderPath = folderPath;
		this.fileName = fileName;
		this.url = url;
	}
	
	@Override
	public void run() {
		downLostVideo(url);
	}

	/**
	 * 下载视频
	 * 
	 * @param url
	 */
	public void downLostVideo(String url) {
		try {
			Connection.Response document = Jsoup.connect(url).ignoreContentType(true).timeout(10000).execute();
			URL url1 = document.url();
			String a =folderPath + "\\" + fileName + ".mp4";
			File file = new File(a);
			FileUtils.copyURLToFile(url1, file, 100000, 100000);
		} catch (IOException e) {
			return;
		}
	}

}
