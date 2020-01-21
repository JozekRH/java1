package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try {
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
                                Files.copy(file, targetDir, StandardCopyOption.REPLACE_EXISTING);
                            }
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
