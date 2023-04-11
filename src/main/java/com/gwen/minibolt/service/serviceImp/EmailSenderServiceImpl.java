package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.service.ServiceInt.EmailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;

    //    @Value("${spring.mail.username}")
    private String senderAddress;

    /**
     * @param toMail
     * @param body
     * @param subject
     * @param attachment
     * @return
     */
    @Override
    public String sendMailWithAttachment(String toMail, String body, String subject, String attachment) throws MessagingException {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom("boltzmini@gmail.com");
            messageHelper.setTo(toMail);
            messageHelper.setText(body);
            messageHelper.setSubject(subject);
            if (!Objects.isNull(attachment)) {
                FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
                messageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
                return "mail with attachment sent";
            }
            javaMailSender.send(mimeMessage);
            return "mail without attachment";

    }
}
