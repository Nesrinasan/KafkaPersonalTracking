package com.asan.KafkaPersonalTracking.service;

import com.asan.KafkaPersonalTracking.service.mail.MailService;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

    @Override
    public void sendMail(String mailBody) {
        /**
         * Send mail
         */
    }
}
