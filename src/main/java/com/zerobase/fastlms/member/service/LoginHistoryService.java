package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginHistoryService {

    void loggingHistory(String loggedId, String userAgent, String clientIp);

    List<LoginHistoryDto> findByLoggedId(String loggedId);
}