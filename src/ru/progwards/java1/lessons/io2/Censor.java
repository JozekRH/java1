package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;

public class Censor {

    public static class CensorException extends Exception {

        private final String fileName;
        private final String message;

        public CensorException(String fileName, String message) {
            super();
            this.message = message;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return fileName + ":" + message;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        try(RandomAccessFile raf = new RandomAccessFile(inoutFileName, "rw")) {
            StringBuilder sb = new StringBuilder();
            long startWordPos = 0;
            long lastStopPos = 0;
            while(lastStopPos < raf.length()) {
                sb.delete(0, sb.length());
                startWordPos = raf.getFilePointer();
                lastStopPos = startWordPos;
                char curChar = '0';
                while (curChar != ' ' && curChar != '\n' && lastStopPos < raf.length()) {
                    curChar = (char) raf.read();
                    lastStopPos++;
                    sb.append(curChar);
                }
                String currentWord = sb.toString();
                for (String obsceneWord : obscene) {
                    int index = currentWord.indexOf(obsceneWord);
                    if (index != -1) {
                        raf.seek(startWordPos + (long)index);
                        for (int i = 0; i < obsceneWord.length(); i++) {
                            raf.write('*');
                        }
                    }
                }
                raf.seek(lastStopPos);
            }

        } catch (Exception e) {
            throw new CensorException(inoutFileName, e.getMessage());
        }

    }

    public static void main(String[] args) {
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            censorFile("D:\\file1.txt", obscene);
        } catch (CensorException e) {
            //
        }
    }
}
