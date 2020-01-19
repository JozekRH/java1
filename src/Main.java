import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

//        String strDuration = "0000-01-01T00:00:00";
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        LocalDateTime expiration = LocalDateTime.parse(strDuration, dtf);
//         Duration duration = Duration.between(LocalDateTime.of(0,1,1,0,0,0,0),
//                 expiration.plusMonths(1).plusDays(1));
//        System.out.println(duration.toDays());
//        System.out.println(duration);

        Path path = Paths.get(".").toAbsolutePath().normalize();
        //System.out.println(path.toAbsolutePath().normalize().toString());
        File file = new File(path.toString() + "/created");
        //File file = new File("./created");
        System.out.println(file.mkdir());
        System.out.println(path.toAbsolutePath().normalize().getParent());
    }
}
