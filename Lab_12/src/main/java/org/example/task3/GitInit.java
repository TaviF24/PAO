package org.example.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GitInit {
    public static void execute(String path) throws IOException {
        Path gitPath = Paths.get(path, ".git");
        Files.createDirectory(gitPath);
        Files.createDirectories(gitPath.resolve("objects"));
        Files.createDirectories(gitPath.resolve("refs"));
        Path headFile = gitPath.resolve("HEAD");
        Files.writeString(headFile, "ref: refs/head/main\n");
    }
}
