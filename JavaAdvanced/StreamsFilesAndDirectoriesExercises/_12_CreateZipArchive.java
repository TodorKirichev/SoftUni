package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12_CreateZipArchive {
    public static void main(String[] args) throws IOException {

        String file1Path = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String file2Path = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String file3Path = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        String zipFilePath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zip.zip";

        zipFiles(file1Path, file2Path, file3Path, zipFilePath);
    }

    private static void zipFiles(String file1Path, String file2Path, String file3Path, String zipFilePath) throws IOException {

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath));

        addToZip(file1Path, zos);

        addToZip(file2Path, zos);

        addToZip(file3Path, zos);
        
        zos.close();
    }

    private static void addToZip(String filePath, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);

        ZipEntry zipEntry = new ZipEntry(new File(filePath).getName());

        zos.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }
}
