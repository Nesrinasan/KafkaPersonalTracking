package com.asan.KafkaPersonalTracking.service.mail;

import com.asan.KafkaPersonalTracking.model.AnnualLeaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailConsumerService {

    @Autowired
    MailService mailService;

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${app.kafka.groupId}")
    public void sendMailToOtherPersonalsAboutAnnualLeave(@Payload AnnualLeaveRequestDto annualLeaveRequestDto){

        String personNo = annualLeaveRequestDto.getPersonNo();
        Date firstDate = annualLeaveRequestDto.getFirstDate();
        Date lastDate = annualLeaveRequestDto.getLastDate();

        String mailBody = "Our employee number: "+ personNo+" is on leave between " + firstDate +" and" + lastDate ;

        mailService.sendMail(mailBody);

    }

}
