package servlet;

import domain.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "SendMailServlet",urlPatterns = "/sendConfEmail")
public class SendMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String to = "michalswiatowy.praca@gmail";
//        String from ="michalswiatowy.praca@gmail";
////        String host ="localhost";
//        String login = "login";
//        String password = "02lahciMsatiW";
//
//
//        Properties properties = System.getProperties();
//        String host = "smtp.gmail.com";
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host",host);
//        properties.put("mail.smtp.user",from);
//        properties.put("mail.smtp.password",password);
//        properties.put("mail.smtp.port",587);
//        properties.put("mail.smtp.auth","true");
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(login,password);
//            }
//        });
//        response.setContentType("text/html");
//
////        HttpSession httpSession = request.getSession(false);
//
//        HttpSession UserSession = ((HttpServletRequest) request).getSession(false);
////        long uId =  (Long)httpSession.getAttribute("userId");
//        User user=(User) UserSession.getAttribute("user");
//        Long uId = user.getId();
////        String uAC = user.getAccountNumber();
//
//        PrintWriter printWriter = response.getWriter();
//
//        try{
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("Account confirmation");
//            message.setText("http://localhost:8080/activationServlet?userId=" + uId);
//
//            Transport.send(message);
//            String title = "send emial";
//            String res = "message sent";
//            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
//
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
