package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {

    BannerDto getById(long id);

    boolean add(BannerInput bannerInput);

    boolean set(BannerInput bannerInput);

    List<BannerDto> list(BannerParam parameter);

    boolean del(String idList);

    List<BannerDto> frontList();
}