package com.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sendMail extends HttpServlet {
	/*
	 *发送给邮件：
		1.配置属性信息，property 
		2.创建session实例
		3.创建通道transport
		4.建立服务器连接
		5.获取发送的Message
			5.1.创建MimeMessage对象
			5.2.创建发送者，创建接收者
			5.3.设置发送方式和接受方式
			5.4.设置主题和内容
		6.发送信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String e_names = request.getParameter("e_name");
			String[] enames=e_names.split(";");
			String topic = request.getParameter("topic");
			String content = request.getParameter("content");
			String name = (String)request.getSession().getAttribute("name");
			String pwd = (String)request.getSession().getAttribute("pwd");
			//设置配置文件
			try {
			Properties propert=new Properties();
			propert.setProperty("mail.host", "smtp.163.com");//不同的邮箱服务器不是一样的
			propert.setProperty("mail.transport.protocol", "smtp");
			propert.setProperty("mail.stmp.auth", "true");
			Session session=Session.getInstance(propert);
			Transport transport = session.getTransport();
				//连接邮箱服务器
			    //"m15270588073@163.com", "JIN1950681497"
			    //用户名为m15270588073 pwd为授权码 JIN1950681497 我的密码是JIN15270588073
				transport.connect("smtp.163.com",name,pwd);
				//获取邮箱的信息
				Message message = warpMessage(session,enames,name,topic,content);
				//发送邮箱的信息
				transport.sendMessage(message, message.getAllRecipients());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			 response.sendRedirect("success.jsp");
			//request.getRequestDispatcher("success.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//将信息封装到邮件发送对象中
	public Message warpMessage(Session session,String[] emails,String name,String topic,String content) throws Exception{
		MimeMessage mm=new MimeMessage(session);
		//设置发送人
		mm.setFrom(new InternetAddress(name+"@163.com"));
		//设置收件人
		InternetAddress[] address=new InternetAddress[emails.length];
		for(int x=0;x<emails.length;x++){
			address[x]=new InternetAddress(emails[x]);
		}
		mm.addRecipients(Message.RecipientType.TO, address);// 设置发送方式与接收者
		mm.setSubject(topic);//设置主题
		mm.setContent(content, "text/html;charset=utf-8");//内容
		return mm;
	}

}
