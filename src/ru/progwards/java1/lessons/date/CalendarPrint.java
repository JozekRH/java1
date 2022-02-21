package ru.progwards.java1.lessons.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class CalendarPrint {
    public static void printMonth(int month, int year){
        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String m = new SimpleDateFormat("LLLL ", new Locale("ru")).format(calendar.getTime());
        m = m.substring(0, 1).toUpperCase() + m.substring(1);
        System.out.println(new SimpleDateFormat("YYYY ").format(calendar.getTime()) + m);
        System.out.println("ПН ВТ СР ЧТ ПТ СБ ВС");

        String initialSpace = "";
        for (int i = 1; i < dayOfWeek - 1; i++) {
            initialSpace += "   ";
        }
        System.out.print(initialSpace);

        for (int i = 1, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
            for (int j = ((i == 1) ? dayOfWeek - 1 : 1); j < 8 && (dayOfMonth <= daysInMonth); j++) {
                System.out.printf("%2d ", dayOfMonth);
                dayOfMonth++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        printMonth(2, 2022);

        Date d1 = new Date(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE));
        Date d2 = new Date(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE));
        Instant i1 = Instant.ofEpochMilli(d1.getTime());
        Instant i2 = Instant.ofEpochMilli(d2.getTime());
        Duration d = Duration.between(i1, i2);

        LocalDate ld1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period p = Period.between(ld1, ld2);
        System.out.println(String.format("Между date1 и date2 %s лет, %s месяцев, %s дней, %s минут, %s секунд, %s миллисекунд",
                Math.abs(p.getYears()), Math.abs(p.getMonths()), Math.abs(p.getDays()), Math.abs(d.toHoursPart()), Math.abs(d.toMinutesPart()), Math.abs(d.toSecondsPart()), Math.abs(d.toMillisPart())));
    }
}
