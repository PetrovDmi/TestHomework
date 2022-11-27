import RedactAndAnalyseFile.FileRedactor;
import UserInterface.WorkWithFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> linesOfFile = new ArrayList<>();
        FileRedactor fileRedactor = new FileRedactor();
        WorkWithFile workWithFile = new FileRedactor();
        Scanner scanner = new Scanner(System.in);

        fileRedactor.copyUserFile();
        printMenu();
        while (true) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" : {
                    workWithFile.readFile(linesOfFile);
                    System.out.println("Файл успешно считан" + System.lineSeparator());
                    break;
                }
                case "2" : {
                    System.out.println("Заша запись: ");
                    workWithFile.writeInTheEndOfFile(linesOfFile);
                    System.out.println("Строка записана" + System.lineSeparator());
                    break;
                }
                case "3" : {
                    workWithFile.saveEditedFile(fileRedactor.getCopyFile(), linesOfFile);
                    break;
                }
                case "4" : {

                    break;
                }
                case "5" : {
                    workWithFile.printFile(linesOfFile);
                    break;
                }
                case "6" : {
                    workWithFile.setTextToLowerCase(linesOfFile);
                    break;
                }
                case "EXT" : {
                    System.out.println(System.lineSeparator() + "Завершение работы редактора ...");
                    break;
                }
                default: {
                    System.out.println("Ошибка 404. Такой команды нет."  + System.lineSeparator());
                    break;
                }
            }
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?" + System.lineSeparator() +
                "1 - Чтение файла" + System.lineSeparator() +
                "2 - Записать строку в файл" + System.lineSeparator() +
                "3 - Сохранить файл" + System.lineSeparator() +
                "4 - Анализ файла" + System.lineSeparator() +
                "5 - Напечатать файл" + System.lineSeparator() +
                "6 - Весь текст к нижнему регистру" + System.lineSeparator() +
                "EXT - Выйти из приложения" + System.lineSeparator());

    }
}