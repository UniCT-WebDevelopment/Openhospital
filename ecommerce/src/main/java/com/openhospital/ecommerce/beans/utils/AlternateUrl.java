package com.openhospital.ecommerce.beans.utils;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class AlternateUrl {

    private String href;
    private String rel = "alternate";
    private String lang;

    public AlternateUrl(String href, String lang) {
        this.href = href;
        this.lang = lang;
    }

}
