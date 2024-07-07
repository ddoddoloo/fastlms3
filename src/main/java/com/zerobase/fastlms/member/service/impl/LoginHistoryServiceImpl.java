package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public void loggingHistory(String loggedId, String userAgent, String clientIp) {
        loginHistoryRepository.save(
                LoginHistory.builder()
                        .loggedId(loggedId)
                        .loggedDt(LocalDateTime.now())
                        .userAgent(userAgent)
                        .clientIp(clientIp)
                        .build()
        );

        log.info("User-Agent = {}", userAgent);
        log.info("Client-IP = {}", clientIp);
    }

    @Override
    public List<LoginHistoryDto> findByLoggedId(String loggedId) {
        List<LoginHistory> histories = loginHistoryRepository.findByLoggedId(loggedId);
        List<LoginHistoryDto> historyDtos = new ArrayList<>();
        if (!histories.isEmpty()) {
            for (LoginHistory loginHistory : histories) {
                historyDtos.add(LoginHistoryDto.of(loginHistory));
            }
        }

        long totalCount = loginHistoryRepository.countByLoggedId(loggedId);

        if (!CollectionUtils.isEmpty(historyDtos)) {
            int i = 0;
            for (LoginHistoryDto x : historyDtos) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - i);
                i++;
            }
        }
        return historyDtos;
    }
}