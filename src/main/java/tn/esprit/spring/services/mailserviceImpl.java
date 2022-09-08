package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.lang.invoke.MethodHandles;

@Service
@Transactional
public class mailserviceImpl implements mailservice {
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void sendMessageWithAttachment(String to,  String username, String trainingname,String trainer) {
        MimeMessage message = emailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("projetprojet489@gmail.com");
            helper.setTo(to);
            helper.setSubject("Congradulation you just got Certified ");
            helper.setText( "Congradulations "+ username+ " You just got certified in : "+ trainingname+
                    "by :" +trainer);

            FileSystemResource file
                    = new FileSystemResource(new File("./src/main/resources/QRCode.png"));
            helper.addAttachment("QR", file);

            emailSender.send(message);
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
