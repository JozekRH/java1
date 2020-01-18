package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {

    public static enum FormatStyle {SHORT, LONG, FULL}

    private ZonedDateTime start; // дата-время начала действия страховки
    private Duration duration; // продолжительность действия

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        switch (style) {
            case SHORT:
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate localDate = LocalDate.parse(strStart, dtf);
                LocalTime localTime = LocalTime.of(0, 0, 0, 0);
                ZoneId zone = ZoneId.systemDefault();
                ZonedDateTime start = ZonedDateTime.of(localDate, localTime, zone);
                this.start = start;
                break;
            case LONG:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime localDateTime = LocalDateTime.parse(strStart, dtf);
                zone = ZoneId.systemDefault();
                start = ZonedDateTime.of(localDateTime, zone);
                this.start = start;
                break;
            case FULL:
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                start = ZonedDateTime.parse(strStart, dtf);
                this.start = start;
                break;
        }
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        this.duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        ZonedDateTime expiration = start.plusMonths(months).plusDays(days).plusHours(hours);
        this.duration = Duration.between(start, expiration);
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {
            case SHORT:
                long ms = Long.parseLong(strDuration);
                this.duration = Duration.ofMillis(ms);
                break;
            case LONG:
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime expiration = LocalDateTime.parse(strDuration, dtf);
                this.duration = Duration.between(LocalDateTime.of(0,1,1,0,0,
                        0,0), expiration.plusMonths(1).plusDays(1));
                break;
            case FULL:
                this.duration = Duration.parse(strDuration);
        }
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if(start.isAfter(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault())))
            return false;
        if(duration == null)
            return true;
        return start.plus(duration).isAfter(dateTime);
    }

    public String toString() {
        String validStr = checkValid(ZonedDateTime.now()) ? " is valid" : " is not valid";
        return "Insurance issued on " + start + validStr;
    }
}
