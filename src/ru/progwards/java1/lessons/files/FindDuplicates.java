package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    private List<List<String>> duplicateList;

    public FindDuplicates() {
        this.duplicateList = new ArrayList<>();
    }

    List<List<String>> findDuplicates(String startPath) throws IOException {
        duplicateList.clear();
        Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                for (List<String> similarFilesList : duplicateList) {
                    Path pathFromList = Paths.get(similarFilesList.get(0));
                    if (file.getFileName().toString().equals(pathFromList.getFileName().toString())
                            && attrs.creationTime().equals(Files.getAttribute(pathFromList, "basic:creationTime"))
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
        });
        return duplicateList;
    }
}
