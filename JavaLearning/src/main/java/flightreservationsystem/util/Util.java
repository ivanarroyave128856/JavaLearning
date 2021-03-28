package flightreservationsystem.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    public static String getBasicFileContent(String FullFilePath) throws IOException {
        Path fileName = Path.of(FullFilePath);
        return Files.readString(fileName);
    }

    public static void saveFile(String FullFilePath, String content) throws IOException {
        Path filePath = Paths.get(FullFilePath);
        Files.writeString(filePath, content).toFile();
    }
}
