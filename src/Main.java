

public class Main {
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
     ? this is just used to clear out the terminal
     * System.out.print("\033[H\033[2J");
     * System.out.flush();
     */
}
