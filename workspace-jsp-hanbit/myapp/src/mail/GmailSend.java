package mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSend extends Thread {

	private static class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			//������ ���̵� , ��й��?
			return new PasswordAuthentication("taehune94", "rhkdwo9079@");
		}
	}
	
	public static void send(String title, String content, String toEmail) {
		Properties p = new Properties();
		p.put("mail.smtp.user", "taehune94@gmail.com"); //���� ������
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(p, auth);
			session.setDebug(true); 
			MimeMessage msg = new MimeMessage(session);
			String message = content;
			msg.setSubject(title);
			//InternetAddress(�����ּ�, �����»��?�̸�, ���ڼ�)
			Address fromAddr = new InternetAddress("taehune94@gmail.com"); 
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(toEmail); 
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(message, "text/html;charset=KSC5601");
			Transport.send(msg);
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String title = "JSPStudy���� ���Ӱ� YouTube ä�� �� �������?�����α�";
		String content = "<h3>JSPStudy���� ���Ӱ� YouTube ä���� �����մϴ�.</h3>";
		content += "<a href='https://www.youtube.com/channel/UCVrhnbfe78ODeQglXtT1Elw'>";
		content += "<h3>1.JSPStudy ��ڰ� ���������ϴ� YouTube</h3></a>";
		content += "<img src='http://jspstudy.co.kr/main/images/youtube.jpg'>";
		content += "<br><br>";
		content += "<a href='http://jspstudy.co.kr/main/main.jsp?PATH=/admin/adminRead.jsp?a_num=165&m_num=7&keyField=a_division1&keyWord=notice'>";
		content += "<h3>2.JSP & Servlet �� ���α׷��� �Թ� ���� �ҽ�, PPT, ���α׷�</h3></a>";
		content += "<img src='http://jspstudy.co.kr/main/images/jsp_bookimg.jpg'>";
		content += "<br><br>";
		content += "<a href='http://jspstudy.co.kr/board/file/etc_03.pdf'>";
		content += "<h3>3.�����?�������� �����α� PDF</h3></a>";
		content += "<img src='http://jspstudy.co.kr/main/images/etc03_1.jpg'>";
		content += "<img src='http://jspstudy.co.kr/main/images/etc03_2.jpg'>";
		content += "<img src='http://jspstudy.co.kr/main/images/etc03_3.jpg'>";
		content += "<img src='http://jspstudy.co.kr/main/images/etc03_4.jpg'>";
		content += "<br><br>";
		content += "<a href='http://JSPStudy.co.kr'><h2>http://JSPStudy.co.kr</h2></a>";
		
		send(title, content, "satelite12@naver.com");
		System.out.println("����~~~~");
	}
}











