import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        String strDuration = "0000-01-01T00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime expiration = LocalDateTime.parse(strDuration, dtf);
         Duration duration = Duration.between(LocalDateTime.of(0,1,1,0,0,0,0),
                 expiration.plusMonths(1).plusDays(1));
        System.out.println(duration.toDays());
        System.out.println(duration);
    }


}
