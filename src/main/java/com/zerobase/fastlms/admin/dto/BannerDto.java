package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class BannerDto {
    private Long id;

    private String bannerName;

    private String openMethod;

    private String linkUrl;

    private int sortValue;

    private boolean usingYn;

    private String filename;
    private String urlFilename;

    private LocalDateTime regDt;
    private LocalDateTime udtDt;

    private long totalCount;
    private long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .openMethod(banner.getOpenMethod())
                .linkUrl(banner.getLinkUrl())
                .sortValue(banner.getSortValue())
                .usingYn(banner.isUsingYn())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for (Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }

    public String getRegDt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return regDt != null ? regDt.format(formatter) : "";
    }
}