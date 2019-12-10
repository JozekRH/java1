import ru.progwards.java1.lessons.basics.AccuracyDoubleFloat;
import ru.progwards.java1.lessons.basics.Astronomy;
import ru.progwards.java1.lessons.basics.ReverseDigits;

public class Main {
    public static void main(String[] args) {
        System.out.println(AccuracyDoubleFloat.volumeBallDouble(1));
        System.out.println(AccuracyDoubleFloat.volumeBallFloat(1));
        System.out.println(AccuracyDoubleFloat.calculateAccuracy(AccuracyDoubleFloat.EARTH_RADIUS));
    }
}
