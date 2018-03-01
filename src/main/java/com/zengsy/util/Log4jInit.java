package com.zengsy.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * <p>Title: 程序的初始化操作</p>
 *
 * <p>Description:
 * 1.初始化Log4J的配置参数
 * </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ffsc</p>
 *
 * @author 赖歆,方旭尘
 * @version 1.0
 */
public class Log4jInit extends HttpServlet {

  //Initialize global variables
  public void init() throws ServletException {
    //得到log4j的配置文件的位置
    String log4jConfigFile = getInitParameter("log4j_config_file");
    String prefix = this.getServletConfig().getServletContext().getRealPath("/");
    try {
      /**
       * 初始化Log4J
       */
      InputStream in = getServletContext().getResourceAsStream(log4jConfigFile);
      Properties props = new Properties();
      props.load(in);
      String userDir = System.getProperty("user.dir");
      System.out.println("*************获得的相对路径:" + userDir);
      //获取windows或linux系统下对应的目录间隔符
      String blankStr = System.getProperty("file.separator");
      //创建日志文件父级目录
      String logPath = userDir + blankStr + "log" + blankStr + "PhotographyStudio";
      System.out.println("*************获得的日志路径:" + logPath);
      System.out.println("*************获得的分隔符:" + blankStr);

	  //如果日志存放路径不存在则新建
      File logFile = new File(logPath);
      if(!logFile.exists()){
          logFile.mkdirs();
      }
      //修改log4j配置文件log4j.appender.logfile.File配置项的值
	  props.setProperty("log4j.appender.A2.File", logPath + blankStr + props.getProperty("log4j.appender.A2.File"));
      //装入log4j配置信息
      PropertyConfigurator.configure(props);
      System.out.println("Log4j配置文件载入成功!");
    }
    catch (IOException ex) {
      System.out.println("Log4j配置文件载入失败!");
    }
  }

  //Clean up resources
  public void destroy() {
  }
}
