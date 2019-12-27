package ru.progwards.java1.lessons.sets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {

    public static void main(String[] args) throws IOException {
        System.out.println(process("D:\\progwards\\file2.txt"));

    }

    public static String process(String fileName) throws FileNotFoundException, IOException {

        try(FileReader fileReader = new FileReader(fileName)) {

            Set<Character> lettersInFile = new TreeSet<>();
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                char ch = (char)charCode;
                if(Character.isLetter(ch))
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
