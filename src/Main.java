import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner mainConsole;
    private static String temp;

    public static void main(String[] args) {
        dataCreation newData = new dataCreation();
        System.out.println("hello User!");
        // used for asking name of the data file
        newData.userInput();
        // used for asking the amount of data they want on the file
        newData.userInput();
        // used for asking what type of data they want on the file
        newData.userInput();
        // used for determining what format they want to use
        newData.userInput();

    }
    /*
     * ? this is just used to clear out the terminal
     * System.out.print("\033[H\033[2J");
     * System.out.flush();
     */
}
