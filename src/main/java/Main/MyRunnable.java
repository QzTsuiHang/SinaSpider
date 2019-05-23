package Main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.climbDemo.service.HtmlParseTool;

public class MyRunnable implements Runnable {

	ScheduledExecutorService ses;
		
	public MyRunnable(ScheduledExecutorService ses) {
		this.ses = ses;
	}

	public void run() {
		
		HtmlParseTool.start();
		if(ses!=null)
			ses.schedule(new MyRunnable(ses), getNextTime(), TimeUnit.SECONDS);
	}

	
	/**
	 * 获取下次执行的秒数
	 * @return 
	 */
	public long getNextTime() {

		// 获取当前时间
		LocalDateTime ldt = LocalDateTime.now();
		
		// 获取下次执行时间
		LocalDateTime ldt2 = convertDateToLDT(getDate());
		
		// 把当前时间转换为秒数
		long currentTimeSec = getMilliByTime(ldt);

		// 把下次时间转换为秒数
		long nextTimeSec = getMilliByTime(ldt2);

		// 把下次执行时间的秒数减去当前时间的秒数
		return nextTimeSec-currentTimeSec;
	}
	
	/**
	 * 获取下次执行时间的date
	 */
	@SuppressWarnings("deprecation")
	public Date getDate() {
		
		Date date = new Date();// 获取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		date.setHours(8); // 把时间设为每天8点
		date.setMinutes(0); // 把分钟设为0
		date.setSeconds(0); // 把秒设为0
		
		return date;
	}
	
	/**
	 *  Date转换为LocalDateTime
	 * @param date
	 * @return
	 */
    public LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
    
    /**
     * 获取指定日期的毫秒
     * @param time
     * @return
     */
    public long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }



}
