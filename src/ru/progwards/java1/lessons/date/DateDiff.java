package ru.progwards.java1.lessons.date;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateDiff {

    public static void timeBetween(Date date1, Date date2){
        Instant i1 = Instant.ofEpochMilli(date1.getTime());
        Instant i2 = Instant.ofEpochMilli(date2.getTime());
        Duration d = Duration.between(i1, i2);

        LocalDate ld1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period p = Period.between(ld1, ld2);
        System.out.println(String.format("Между date1 и date2 %s лет, %s месяцев, %s дней, %s минут, %s секунд, %s миллисекунд",
                Math.abs(p.getYears()), Math.abs(p.getMonths()), Math.abs(p.getDays()), Math.abs(d.toHoursPart()), Math.abs(d.toMinutesPart()), Math.abs(d.toSecondsPart()), Math.abs(d.toMillisPart())));
    }

    public static void timeToBirthday(Date now, Date birthday){
        while (birthday.before(now)){
            Calendar c = Calendar.getInstance();
            c.setTime(birthday);
            c.add(Calendar.YEAR, 1);
            birthday = c.getTime();
        }

        Instant i1 = Instant.ofEpochMilli(now.getTime());
        Instant i2 = Instant.ofEpochMilli(birthday.getTime());
        Duration d = Duration.between(i1, i2);

        LocalDate ld1 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period p = Period.between(ld1, ld2);
        System.out.println(String.format("До дня рождения %s месяцев, %s дней, %s минут, %s секунд, %s миллисекунд",
                Math.abs(p.getMonths()), Math.abs(p.getDays()), Math.abs(d.toHoursPart()), Math.abs(d.toMinutesPart()), Math.abs(d.toSecondsPart()), Math.abs(d.toMillisPart())));
    }

    public static void averageTime(Date[] events){
        long millis = 0;

        for (int i = 0; i < events.length - 1; i++){
            millis += Math.abs(events[i].getTime() - events[i + 1].getTime());
        }

        millis = millis / (events.length - 1);
        Date date1 = new Date(0);
        Date date2 = new Date(millis);

        Instant i1 = Instant.ofEpochMilli(date1.getTime());
        Instant i2 = Instant.ofEpochMilli(date2.getTime());
        Duration d = Duration.between(i1, i2);

        LocalDate ld1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period p = Period.between(ld1, ld2);

        System.out.println(String.format("Среднее время между событиями %s лет, %s месяцев, %s дней, %s минут, %s секунд, %s миллисекунд",
                Math.abs(p.getYears()), Math.abs(p.getMonths()), Math.abs(p.getDays()), Math.abs(d.toHoursPart()), Math.abs(d.toMinutesPart()), Math.abs(d.toSecondsPart()), Math.abs(d.toMillisPart())));

    }

}
