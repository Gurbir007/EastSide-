package utils;

import java.io.File;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailUtil {

    public static void sendReport(String reportPath) {
        try {
            // ConfigReader se details fetch karenge
            String host = ConfigReader.get("email.smtp.host");
            String port = ConfigReader.get("email.smtp.port");
            final String user = ConfigReader.get("email.username");
            final String pass = ConfigReader.get("email.password");
            String to = ConfigReader.get("email.to");
            String subject = ConfigReader.get("email.subject");
            String body = ConfigReader.get("email.body");

            // SMTP properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);

            // Session create karenge
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });

            // Message prepare
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            // Multipart body (text + attachment)
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body, "utf-8");

            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile(new File(reportPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachPart);

            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("✅ Report email sent to: " + to);

        } catch (Exception e) {
            System.err.println("❌ Failed to send report email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
