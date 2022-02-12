package study.java8to11._06_Date_Time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateApp {
    public static void main(String[] args) {
        // 옛날용
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        java.text.SimpleDateFormat dateFormat = new SimpleDateFormat();

        // 최신
        // 기계용
        Instant instant = Instant.now();
        System.out.println(instant);  // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);  // 현재 위치

        // 사람용
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);  // 현재 위치

        LocalDateTime birthDate = LocalDateTime.of(1982, Month.JULY, 15, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
    }
}
