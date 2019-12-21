package ru.progwards.java1.lessons.io2;

public class PhoneNumber {

    public static void main(String[] args) {
        System.out.println(format("8 999 111 22 33"));
    }

    public static String format(String phone) {
        StringBuilder sb = new StringBuilder(phone.replaceAll("[^0-9]", ""));
        if(sb.length() == 11 && sb.charAt(0) != '7') {
            sb.replace(0, 1, "7");
        } else {
            sb.insert(0, "7");
        }
        sb.insert(0, "+").insert(2, "(").insert(6, ")").insert(10, "-");
        return sb.toString();
    }


}
