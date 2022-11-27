package UserInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface WorkWithFile {
    void readFile(ArrayList<String> linesOfFile);

    void writeInTheEndOfFile(ArrayList<String> linesOfFile);

    void saveEditedFile(File file, ArrayList<String> lines) throws IOException;

    void printFile(ArrayList<String> linesOfFile);

    void setTextToLowerCase(ArrayList<String> lines);
}

