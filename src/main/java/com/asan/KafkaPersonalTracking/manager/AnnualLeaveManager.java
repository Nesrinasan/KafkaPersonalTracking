package com.asan.KafkaPersonalTracking.manager;

import com.asan.KafkaPersonalTracking.model.AnnualLeaveRequestDto;
import com.asan.KafkaPersonalTracking.repository.AnnualLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnualLeaveManager {

    private final KafkaTemplate<String, AnnualLeaveRequestDto> kafkaTemplate;
    private final AnnualLeaveRepository annualLeaveRepository;

    @Value("${app.kafka.topic.name}")
    private String topicName;

    public void annualLeaveSave(AnnualLeaveRequestDto requestDto) {
        annualLeaveRepository.save(requestDto);

        sendMailToManagers(requestDto);

    }

    public void sendMailToManagers(AnnualLeaveRequestDto requestDto){

        kafkaTemplate.send(topicName, requestDto);

    }


}
