import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner mainConsole;
    private static String temp;

    public static void main(String[] args) {
        dataCreation newData = new dataCreation();
        System.out.println("hello User!");
        // used for creating the file
        do {
            newData.userInput();
            File newFile = new File(newData.getDataFileName() + ".txt");
            // will check for if the file already exist, asks user on what to do
            if (newFile.exists()) {
                do {
                    System.out.print("The file already exists, would you like to overwrite? (y/n): ");
                    mainConsole = new Scanner(System.in);
                    temp = mainConsole.nextLine();
                } while (!(temp.equals("y")) && !(temp.equals("n")));
                if (temp.equals("n")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    continue;
                }
            }
            try {
                newFile.createNewFile();
                newData.flagTriggered();
            } catch (Exception e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("error creating file please try again");
            }

        } while (newData.getFlag() == 0);
        // used for getting the amount of data the user wants
        do{
            newData.userInput();
            System.out.println(newData.getDataSize());
    }while(newData.getFlag() == 1);
    }
}
