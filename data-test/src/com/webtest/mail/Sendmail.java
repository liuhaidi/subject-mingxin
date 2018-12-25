package com.webtest.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Sendmail {
		    public static String myEmailAccount /*= "2310618296@qq.com"*/;
		    public static String myEmailPassword /*= "mruoruywpejzdjfh"*/;
		    // ����������� SMTP ��������ַ
		    // ����163����� SMTP ��������ַΪ: smtp.163.com
		    public static String myEmailSMTPHost /*= "smtp.qq.com"*/;
		    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
		    public static String receiveMailAccount /*= "3012115199@qq.com"*/;
		    public void sendMail_Txt(String myEmailAccount,String myEmailPassword,String myEmailSMTPHost,String receiveMailAccount) throws Exception{
		        // 1. ������������, ���������ʼ��������Ĳ�������
		        Properties props = new Properties();                    // ��������
		        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
		        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
		        final String smtpPort = "465";
		        props.setProperty("mail.smtp.port", smtpPort);
		        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.setProperty("mail.smtp.socketFactory.fallback", "false");
		        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		        
		        // 2. �������ô����Ự����, ���ں��ʼ�����������
		        Session session = Session.getDefaultInstance(props);
		        session.setDebug(true);// ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
		        // 3. ����һ���ʼ�
		        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
		        // 4. ���� Session ��ȡ�ʼ��������
		        Transport transport = session.getTransport();
		        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
		        // 
		        transport.connect(myEmailAccount, myEmailPassword);
		        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
		        transport.sendMessage(message, message.getAllRecipients());
		        // 7. �ر�����
		        transport.close();
		    }
		    public void sendMail_TuWen(String myEmailAccount,String myEmailPassword,String myEmailSMTPHost,String receiveMailAccount) throws Exception{
		        Properties props = new Properties();                    // ��������
		        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
		        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
		        final String smtpPort = "465";
		        props.setProperty("mail.smtp.port", smtpPort);
		        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.setProperty("mail.smtp.socketFactory.fallback", "false");
		        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		        Session session = Session.getDefaultInstance(props);
		        session.setDebug(true);// ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
		        MimeMessage message = createMimeMessageTuWen(session, myEmailAccount, receiveMailAccount);
		        Transport transport = session.getTransport();
		        transport.connect(myEmailAccount, myEmailPassword);
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		        // 1. ����һ���ʼ�
		        MimeMessage message = new MimeMessage(session);
		        // 2. From: ������
		        message.setFrom(new InternetAddress(sendMail, "liuhaidi", "UTF-8"));
		        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
		        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "songxiaojiao", "UTF-8"));
		        // 4. Subject: �ʼ�����
		        message.setSubject("javamail�����ʼ�", "UTF-8");
		        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
		        message.setContent("helloworld!", "text/html;charset=UTF-8");
		        // 6. ���÷���ʱ��
		        message.setSentDate(new Date());
		        // 7. ��������
		        message.saveChanges();
		        return message;
		    }
		    public static MimeMessage createMimeMessageTuWen(Session session, String sendMail, String receiveMail) throws Exception {
		    	 //1.����һ���ʼ���ʵ������
		        MimeMessage message = new MimeMessage(session);
		        //2.���÷����˵�ַ
		        message.setFrom(new InternetAddress(sendMail));
		        /**
		         * 3.�����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
		         * MimeMessage.RecipientType.TO:����
		         * MimeMessage.RecipientType.CC������
		         * MimeMessage.RecipientType.BCC������
		         */
		        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail));
		        //4.�����ʼ�����
		        message.setSubject("�ʼ�����(����ͼƬ�͸���)","UTF-8");
		         
		        //�����������ʼ�����
		        message.setContent("�򵥵Ĵ��ı��ʼ���", "text/html;charset=UTF-8");
		        // 5. ����ͼƬ"�ڵ�"
		        MimeBodyPart image = new MimeBodyPart();
		        // ��ȡ�����ļ�
		        DataHandler dh = new DataHandler(new FileDataSource("D:\\software\\eclipse-java-oxygen-2-win32-x86_64\\oa-test\\20181121-141106.jpg")); 
		        // ��ͼƬ������ӵ�"�ڵ�"
		        image.setDataHandler(dh); 
		        // Ϊ"�ڵ�"����һ��Ψһ��ţ����ı�"�ڵ�"�����ø�ID��
		        image.setContentID("mailTestPic");     
		        // 6. �����ı�"�ڵ�"
		        MimeBodyPart text = new MimeBodyPart();
		        // �������ͼƬ�ķ�ʽ�ǽ�����ͼƬ�������ʼ�������, ʵ����Ҳ������ http ���ӵ���ʽ�������ͼƬ
		        text.setContent("����һ��ͼƬ<br/><a href='http://www.cnblogs.com/ysocean/p/7666061.html'><img src='cid:mailTestPic'/></a>", "text/html;charset=UTF-8");
		        // 7. ���ı�+ͼƬ������ �ı� �� ͼƬ"�ڵ�"�Ĺ�ϵ���� �ı� �� ͼƬ"�ڵ�"�ϳ�һ�����"�ڵ�"��
		        MimeMultipart mm_text_image = new MimeMultipart();
		        mm_text_image.addBodyPart(text);
		        mm_text_image.addBodyPart(image);
		        mm_text_image.setSubType("related");    // ������ϵ
		        // 8. �� �ı�+ͼƬ �Ļ��"�ڵ�"��װ��һ����ͨ"�ڵ�"
		        // ������ӵ��ʼ��� Content ���ɶ�� BodyPart ��ɵ� Multipart, ����������Ҫ���� BodyPart,
		        // ����� mailTestPic ���� BodyPart, ����Ҫ�� mm_text_image ��װ��һ�� BodyPart
		        MimeBodyPart text_image = new MimeBodyPart();
		        text_image.setContent(mm_text_image);  
		        // 9. ��������"�ڵ�"
		        MimeBodyPart attachment = new MimeBodyPart();
		        // ��ȡ�����ļ�
		        DataHandler dh2 = new DataHandler(new FileDataSource("D:\\study\\three1\\test\\web\\�ʼ�.docx"));
		        // ������������ӵ�"�ڵ�"
		        attachment.setDataHandler(dh2);
		        // ���ø������ļ�������Ҫ���룩
		        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));        
		        // 10. ���ã��ı�+ͼƬ���� ���� �Ĺ�ϵ���ϳ�һ����Ļ��"�ڵ�" / Multipart ��
		        MimeMultipart mm = new MimeMultipart();
		        mm.addBodyPart(text_image);
		        mm.addBodyPart(attachment);     // ����ж�����������Դ������������
		        mm.setSubType("mixed");         // ��Ϲ�ϵ
		        // 11. ���������ʼ��Ĺ�ϵ�������յĻ��"�ڵ�"��Ϊ�ʼ���������ӵ��ʼ�����
		        message.setContent(mm);
		        //�����ʼ��ķ���ʱ��,Ĭ����������
		        message.setSentDate(new Date());
		        return message;
		    }
}
		    
	


