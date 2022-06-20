package com.openhospital.ecommerce.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j2
@Component
class CustomInitializer implements InitializingBean {

    @Autowired
    private Environment environment;

    @Autowired
    private BuildProperties buildProperties;

    @Override
    public void afterPropertiesSet() throws Exception {

        if (buildProperties != null) {
            log.info("[[ APPLICATION ]] VERSION: " + buildProperties.getVersion());
            log.info("[[ APPLICATION ]] BUILD TIMESTAMP: " + buildProperties.getTime());
        } else {
            log.warn("BUILD INFORMATION NOT AVAILABLE");
        }

        if (environment != null && environment.getActiveProfiles() != null) {
            log.info("[[ APPLICATION ]] PROFILES: " +
                    Arrays.toString(environment.getActiveProfiles()));
        } else {
            log.warn("ENVIRONMENT INFORMATION NOT AVAILABLE");
        }
    }

}
