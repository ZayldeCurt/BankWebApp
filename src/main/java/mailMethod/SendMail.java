package mailMethod;

import domain.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Properties;

public class SendMail {
//    static Properties mailServerProperties;
//    static Session getMailSession;
//    static MimeMessage generateMailMessage;

    public static void sendNewMail(User user){
        String to = "mail@gmail.com";
        String from ="mail2@gmail.com";
        String login = "mail2";
        String password = "haslo";



//        Properties properties = System.getProperties();
        Properties properties = new Properties();
        String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.user",from);
        properties.put("mail.smtp.password",password);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.auth","true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login,password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Account confirmation");
            message.setText("http://localhost:8080/activationServlet?userId=" + user.getId()+"&number="+user.getAccountNumber());

            Transport.send(message);
            String title = "send emial";
            String res = "message sent";
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


//    public static void generateAndSendEmail() throws AddressException, MessagingException {
//
//        // Step1
//        System.out.println("\n 1st ===> setup Mail Server Properties..");
//        mailServerProperties = System.getProperties();
//        mailServerProperties.put("mail.smtp.port", "587");
//        mailServerProperties.put("mail.smtp.auth", "true");
//        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//        System.out.println("Mail Server Properties have been setup successfully..");
//
//        // Step2
//        System.out.println("\n\n 2nd ===> get Mail Session..");
//        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
//        generateMailMessage = new MimeMessage(getMailSession);
//        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("michalswiatowy.praca@gmail.com"));
////        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("test1@crunchify.com"));
////        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
//        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("michalswiatowy.praca@gmail.com"));
//        generateMailMessage.setSubject("Greetings from Crunchify..");
//        String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
//        generateMailMessage.setContent(emailBody, "text/html");
//        System.out.println("Mail Session has been created successfully..");
//
//        // Step3
//        System.out.println("\n\n 3rd ===> Get Session and Send mail");
//        Transport transport = getMailSession.getTransport("smtp");
//
//        // Enter your correct gmail UserID and Password
//        // if you have 2FA enabled then provide App Specific Password
//        transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
//        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//        transport.close();
//    }


}
