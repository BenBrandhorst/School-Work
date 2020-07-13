/*File: TwoFactor.java
 * Author: Ben Brandhorst
 * Date: April 12th 2020
 * Purpose: SDEV425 Homework 2
 */
package Homework2;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @description This program uses Java to send emails over the SSL protocol.
 * @author Eric
 */
public class TwoFactor {

  /** @param args the command line arguments */
  public void sendEmail(int code) {
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    Session session =
        Session.getDefaultInstance(
            props,
            new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("umgc.homework@gmail.com", "@k2*7S3Udy7%");
              }
            });
    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("umgc.homework@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("leftie247@gmail.com"));
      message.setSubject("Two Factor Authentication");
      message.setText(
          "Please enter this number in the application to authenticate your identity."
              + "\n\n"
              + code);

      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}