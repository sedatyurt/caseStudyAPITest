package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileHelper {

    public static void writeResponseToFile(String str) throws IOException {
        String path = "responses/" + LocalDateTime.now() + "_RESPONSE.json";
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        bWriter.close();
    }
}
