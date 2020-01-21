package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    List<List<String>> findDuplicates(String startPath) {
        List<List<String>> duplicateList = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    for (List<String> similarFilesList : duplicateList) {
                        Path pathFromList = Paths.get(similarFilesList.get(0));
                        if (file.getFileName().toString().equals(pathFromList.getFileName().toString())
                                && attrs.lastModifiedTime().equals(Files.getLastModifiedTime(pathFromList))
                                && attrs.size() == (Long) Files.getAttribute(pathFromList, "basic:size")
                                && Files.readString(file).equals(Files.readString(pathFromList))) {
                            similarFilesList.add(file.toString());
                            return FileVisitResult.CONTINUE;
                        }
                    }
                    List<String> newList = new ArrayList<>();
                    newList.add(file.toString());
                    duplicateList.add(newList);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return duplicateList;
    }
}
