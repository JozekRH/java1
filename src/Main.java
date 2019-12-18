import ru.progwards.java1.lessons.bigints.*;

public class Main {
    public static void main(String[] args) {
        AbsInteger num1 = new ByteInteger((byte)125);
        AbsInteger num2 = new ByteInteger((byte)126);
        AbsInteger num3 = AbsInteger.add(num1, num2);
        System.out.println(num3);
        System.out.println(num3.getClass().getName());
    }
}
