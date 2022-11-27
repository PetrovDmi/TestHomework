package RedactAndAnalyseFile;

import UserInterface.WorkWithFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRedactor implements WorkWithFile {
    // убрать в мэйн класс, сделать хэшмапу арейлистов
    //сделать функцию туловеркейс для всего файла и записать в другой файл
    Scanner scanner = new Scanner(System.in);

    private File getSourceFile() {
        return new File("resources/1.txt");
    }
    public File getCopyFile() {
        File destination = new File("temp/" + removeExtension(getSourceFile().getName()) + "_отредактированный_" + java.time.LocalDate.now() + ".txt");
        return destination;
    }

    public void copyUserFile() throws IOException {
        File source = getSourceFile();
        String fileNameWithExtension = source.getName();
        String fileName = removeExtension(fileNameWithExtension);
        System.out.println("Работа с файлом " + fileName);
        File destination = getCopyFile();
        if (destination.exists() && !destination.isDirectory()) {
            destination.delete();
        }
        Files.copy(source.toPath(), destination.toPath());

    }

    public String removeExtension(String fileName) {
        if (fileName.indexOf(".") > 0) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return fileName;
        }
    }

    @Override
    public void readFile(ArrayList<String> linesOfFile) {
        try (FileReader fileReader = new FileReader("resources/1.txt");) {
            Scanner scanner = new Scanner(fileReader);
            linesOfFile.clear();
            while (scanner.hasNextLine()) {
                String scannedLine = scanner.nextLine();
                linesOfFile.add(scannedLine);
            }
        } catch (IOException e) {
            System.out.println("Input error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error " + e.getMessage());
        }
    }

    public void printFile(ArrayList<String> linesOfFile) {
        for (String line : linesOfFile) {
            System.out.println(line);
        }
    }

    @Override
    public void writeInTheEndOfFile(ArrayList<String> linesOfFile) {
        String line = scanner.nextLine();
        linesOfFile.add(line);
    }

    public void saveEditedFile(File file, ArrayList<String> lines) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines) {
            fileWriter.write(line + "\n");
        }
        fileWriter.close();
    }

    public void setTextToLowerCase (ArrayList<String> lines) {
        for (String line : lines) {
            line.toLowerCase();
        }
    }
}


