package cn.climbDemo.service;

public class StringDenoising {

	
	/**
	 * 去除路径的一些非法字符
	 * @param 
	 * @return
	 */
	public String pathIllegalCharacter(String path) {
		try {
			path = path.replaceAll("/", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("\\", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll(":", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("\"", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("|", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("*", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("<", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("<", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll(">", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("'", "");
		} catch (Exception e) {
		}
		try {
			path = path.replaceAll("\r\n", "");
		} catch (Exception e) {
		}
		return path;
	}

}
