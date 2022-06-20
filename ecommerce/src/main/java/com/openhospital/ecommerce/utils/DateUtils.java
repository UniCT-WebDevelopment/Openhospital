package com.openhospital.ecommerce.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

    public static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm";

    public static Instant getInstantFromString(String dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN, Locale.ITALIAN);
        Instant instantDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter).atZone(ZoneOffset.UTC).toInstant();
        return instantDateTime;
    }

    public static String getPrintableStringFromInstant(Instant instant) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN, Locale.ITALIAN).withZone(ZoneOffset.UTC);
        String instantStr = dateTimeFormatter.format(instant);
        return instantStr;
    }
}
