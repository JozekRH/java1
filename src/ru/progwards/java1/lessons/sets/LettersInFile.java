package ru.progwards.java1.lessons.sets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {

    public static void main(String[] args) throws IOException {
        System.out.println(process("D:\\progwards\\file2.txt"));

    }

    public static String process(String fileName) throws FileNotFoundException, IOException {
        Set<Character> alphabet = new TreeSet<>();
        alphabet.add((char)1025);
        alphabet.add((char)1105);
        for (int i = 1040; i <= 1103; i++) {
            alphabet.add((char)i);
        }
        for (int i = 65; i <= 90; i++) {
            alphabet.add((char)i);
        }
        for (int i = 97; i <= 122; i++) {
            alphabet.add((char)i);
        }

        try(FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader).useDelimiter("")) {

            Set<Character> lettersInFile = new TreeSet<>();
            while (scanner.hasNext()) {
                Character ch = scanner.next().charAt(0);
                if(alphabet.contains(ch))
                    lettersInFile.add(ch);
            }
            StringBuilder sb = new StringBuilder();
            for(Character letter : lettersInFile) {
                sb.append(letter);
            }
            return sb.toString();
        }
    }
}
