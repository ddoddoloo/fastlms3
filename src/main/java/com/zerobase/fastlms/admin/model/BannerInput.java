package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class BannerInput {

    private long id;
    private String bannerName;
    private String linkUrl;
    private String openMethod;
    private int sortValue;
    private boolean usingYn;

    String idList;

    private String filename;
    private String urlFilename;
}