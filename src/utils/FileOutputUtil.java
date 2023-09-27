package src.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The `FileOutputUtil` class provides utility methods for writing content to files.
 * @author Sean White
 */
public class FileOutputUtil {
    /**
     * Writes the provided content to a specified file inside the "results" directory.
     *
     * @param filename The name of the file to which the content will be written.
     * @param content  The content to write to the file.
     * @throws IOException If any I/O error occurs.
     */
    public static void writeToFile(String filename, String content) throws IOException {
        // Ensure the "results" directory exists
        File directory = new File("results");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Create the file inside the "results" directory
        File file = new File(directory, filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }
}
