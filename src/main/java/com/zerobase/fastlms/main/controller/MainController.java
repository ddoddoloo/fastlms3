package com.zerobase.fastlms.main.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {
    private final BannerService bannerService;

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        List<BannerDto> bannerList = bannerService.frontList();
        model.addAttribute("list", bannerList);
        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }
}