package com.gwen.minibolt.service.ServiceInt;

import jakarta.mail.MessagingException;

public interface EmailSenderService {
    String sendMailWithAttachment(String toMail, String body, String subject, String attachment) throws MessagingException;
}
