import java.util.Scanner;

public class Main {
    private static String temp;
    private static boolean run = true;

    public static void main(String[] args) {
        dataCreation newData = new dataCreation();
        do {
            System.out.println("hello User!");
            // used for asking name of the data file
            newData.userInput();
            // used for asking the amount of data they want on the file
            newData.userInput();
            // used for asking what type of data they want on the file
            newData.userInput();
            // used for determining what format they want to use
            newData.userInput();
            // used for determining if the user wants a range of numbers or not
            newData.userInput();
            run = newData.restartProgram(run);
        } while (run);
    }

    /*
     * ? this is just used to clear out the terminal
     * System.out.print("\033[H\033[2J");
     * System.out.flush();
     */
    // static void restartProgram(dataCreation newData) {
    //     Scanner mainConsole = new Scanner(System.in);
    //     do {
    //         System.out.print("Would you like to create a new file? (y/n): ");
    //         temp = mainConsole.next();
    //     } while ((!(temp.equals("y"))) && (!(temp.equals("n"))));
    //     mainConsole.close();
    //     // clear out the terminal
    //     if (temp.equals("y")) {
    //         System.out.print("\033[H\033[2J");
    //         System.out.flush();
    //         newData.userInput();
    //     } else {
    //         System.out.println("Thank you for using this program, good bye!");
    //         run = false;
    //     }
    // }
}
