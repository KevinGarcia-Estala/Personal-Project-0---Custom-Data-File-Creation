import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner mainConsole;
    private static String temp;

    public static void main(String[] args) {
        dataCreation newData = new dataCreation();
        System.out.println("hello User!");
        //used for asking name of the data file
        newData.userInput();
    }
}

