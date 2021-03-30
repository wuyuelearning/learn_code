package other.test.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

/**
 * Created by wuyue on 2020/12/16.
 */
public class Test {
    public static void main(String[] args) {
        Date date =new Date();
        System.out.println(date);

        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate =LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime =LocalTime.now();
        System.out.println(localTime);




        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-dd/MM");
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);

        Instant instant =Instant.now();
        System.out.println(instant);
    }
}
