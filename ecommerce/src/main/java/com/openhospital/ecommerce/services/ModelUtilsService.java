package com.openhospital.ecommerce.services;

import com.openhospital.ecommerce.constants.OrderStatus;
import com.openhospital.ecommerce.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ModelUtilsService {

    public Instant getInstantFromString(String dateTime) {
        return DateUtils.getInstantFromString(dateTime);
    }

    public String getPrintableStringFromInstant(Instant instant) {
        return DateUtils.getPrintableStringFromInstant(instant);
    }
    public String getPrintableCheckIn(String checkIn) {
        return DateUtils.getPrintableStringFromInstant(Instant.parse(checkIn));
    }

    public String getPrintableOrderStatus(String status) {
        return OrderStatus.findObjectByCode(status).getUserDescription();
    }
}
