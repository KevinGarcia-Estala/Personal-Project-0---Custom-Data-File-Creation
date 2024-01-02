import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class dataCreation implements Interface {
    private int flag = 0;
    private Scanner console;
    private String temp;

    @Override
    public long basicNumbers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'basicNumbers'");
    }

    @Override
    public double decimalNumbers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decimalNumbers'");
    }

    @Override
    public void format() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }

    @Override
    public void userInput() {
        switch (flag) {
            // creating a new file and naming
            case 0:
                do {
                    System.out.print("Please enter the name of you're data file: ");
                    console = new Scanner(System.in);
                    File newFile = new File(console.nextLine() + ".txt");

                    // checks to see if file exist, asks user if it will overwrite or not
                    if (newFile.exists()) {
                        do {
                            System.out.print("The file already exists, would you like to overwrite? (y/n): ");
                            console = new Scanner(System.in);
                            temp = console.nextLine();
                        } while ((!(temp.equals("y"))) && (!(temp.equals("n"))));
                        if (temp.equals("n")) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            continue;
                        }
                    }
                    // creating the file and catching error if the name doesn't work
                    try {
                        newFile.createNewFile();
                        flagTriggered();
                        System.out.println("File created! ");
                    } catch (Exception e) {
                        System.out.println("Error creating, file plase try again");
                    }

                } while (flag == 0);
                break;
            default:
                break;
        }
    }

    // incrementing flag
    private void flagTriggered() {
        flag = +1;
    }

}
