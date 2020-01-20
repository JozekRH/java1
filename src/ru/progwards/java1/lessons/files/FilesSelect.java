package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        Files.walkFileTree(Paths.get(inFolder), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (pathMatcher.matches(file)) {
                    for (String key : keys) {
                        if (Files.readString(file).contains(key)) {
                            Path keyDir = Paths.get(outFolder).resolve(key);
                            if (Files.notExists(keyDir))
                                Files.createDirectory(keyDir);
                            Path targetDir = keyDir.resolve(file.getFileName());
                            Files.copy(file, targetDir);
                        }
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
