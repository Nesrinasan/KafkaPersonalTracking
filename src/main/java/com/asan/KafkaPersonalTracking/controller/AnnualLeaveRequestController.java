package com.asan.KafkaPersonalTracking.controller;

import com.asan.KafkaPersonalTracking.model.AnnualLeaveRequestDto;
import com.asan.KafkaPersonalTracking.manager.AnnualLeaveManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal/api/")
@RequiredArgsConstructor
public class AnnualLeaveRequestController {

    @Autowired
    AnnualLeaveManager annualLeaveService;

    @PostMapping("annual-leave")
    public void annualLeave(@RequestBody AnnualLeaveRequestDto requestDto){
        annualLeaveService.annualLeaveSave(requestDto);
    }
}
