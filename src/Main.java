import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String sentance = "Убитых словом, добивают молчанием. (c) Уильям Шекспир.";
        StringTokenizer tokenizer = new StringTokenizer(sentance, " .,-!\n");
        String[] strArr = new String[tokenizer.countTokens()];
        int counter = 0;
        while(tokenizer.hasMoreTokens()) {
            if(counter % 2 == 0) {
                if (counter+1 < strArr.length) {
                    strArr[counter+1] = tokenizer.nextToken();
                } else {
                    strArr[counter] = tokenizer.nextToken();
                }
            } else {
                strArr[counter-1] = tokenizer.nextToken();
            }
            counter++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strArr) {
            stringBuilder.append(str).append(" ");
        }
//        System.out.println(stringBuilder.toString());
//        System.out.format("|%04d|%#x|%2.1f|\n", 2, 15, 3.25);
        System.out.format(new Locale("ru"), "|%1$04d|%2$td/%2$tm/%2$tY|%3$1.1f|", 2, new Date(), 123.25);

         class Person {
            public String name;
            public Date birth;
            public double salary;

            Person(String name, Date birth, double salary) {
                this.name = name;
                this.birth = birth;
                this. salary = salary;
            }

             void printPersons(Person[] persons) {
                for(Person person : persons) {
                    System.out.format(new Locale("ru"),"|%1$-10s|%2$td/%2$tm/%2$tY|%3$,10.2f|\n", person.name, person.birth, person.salary);
                }
             }
        }

//        String strDuration = "0000-01-01T00:00:00";
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        LocalDateTime expiration = LocalDateTime.parse(strDuration, dtf);
//         Duration duration = Duration.between(LocalDateTime.of(0,1,1,0,0,0,0),
//                 expiration.plusMonths(1).plusDays(1));
//        System.out.println(duration.toDays());
//        System.out.println(duration);

//        Path path = Paths.get("D:\\file1.txt").toAbsolutePath().normalize();
//        System.out.println(path);
//        String file = path.getFileName().toString();
//        String[] fileArr = file.split("\\.");
//        System.out.println(file);
//        System.out.println(Arrays.toString(fileArr));

//        File file = new File(path.toString() + "/created");
//        File file = new File("./created");
//        System.out.println(file.mkdir());
//        System.out.println(path.toAbsolutePath().normalize().getParent());



//        int res = (-127 & 0xFF) + ((-128) & 0xFF);
//        System.out.println(res);
//        System.out.println(Integer.toBinaryString(-127));
//        System.out.println(-127 & 0xFF);
//        System.out.println(Integer.toBinaryString(-127 & 0xFF));
//        System.out.println((-128) & 0xFF);
//        System.out.println(Integer.toBinaryString((-128) & 0xFF));

    }
}
