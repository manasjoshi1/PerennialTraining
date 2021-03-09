import java.util.Map;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
 class SendEmail  {  
	  public static void send(Map<String, String> map){  
				String from = map.get("from");
				String password = map.get("pass");
				String to = map.get("to");
				String sub = map.get("subject");
				String msg = map.get("message");
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  
    