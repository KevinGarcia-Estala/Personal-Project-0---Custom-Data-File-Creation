import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class dataCreation implements Interface {
    private int userFlag = 0;
    private int numberFlag = -999;
    private int formatFlag = -999;
    private Scanner console;
    private Object temp;
    private int dataSize = 0;
    private Exception error;

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
        switch (userFlag) {
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
                            continue;
                        }
                    }
                    // creating the file and catching error if the name doesn't work
                    try {
                        newFile.createNewFile();
                        flagTriggered();
                        System.out.println("File created! ");
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Error creating, file plase try again");
                    }

                } while (userFlag == 0);
                break;

            // deciding how much data will be written onto the file
            case 1:
                do {
                    System.out.print("how many data values do you need?: ");
                    console = new Scanner(System.in);
                    try {
                        dataSize = console.nextInt();
                        if (dataSize <= 0) {
                            throw error;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input, please try again");
                        continue;
                    }
                    flagTriggered();

                } while (userFlag == 1);
                System.out.println("Size has been determined");
                System.out.println();
                break;

            // determine what type of numbers will be used for the data file
            case 2:
                System.out.print("(1) numbers \n(2) decimals \n(3) negatives \n(4) mix \n");
                do {
                    System.out.print("please select what type of data you want on you're file: ");
                    console = new Scanner(System.in);
                    try {
                        numberFlag = console.nextInt();
                        if (numberFlag <= 0 || numberFlag >= 5) {
                            throw error;
                        } else {
                            flagTriggered();
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input, please try again");
                    }
                } while (userFlag == 2);
                break;

            // determine what format will be used for the data file
            case 3:
                do {
                    System.out.print("(1) space \n(2) enter \n(3) tab \n");
                    System.out.print("please select what type of format do you want on you're file: ");
                    console = new Scanner(System.in);
                    try {
                        formatFlag = console.nextInt();
                        if (formatFlag <= 0 || formatFlag >= 4) {
                            throw error;
                        } else {
                            flagTriggered();
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input, please try again");
                    }
                } while (userFlag == 3);
                break;
            
                //asks the user if they want a specific range of numbers or not
            case 4:
            //TODO: create a option for users to decide if they want a certain range of numbers or not
            default:
                userFlag = 0;
                break;
        }
    }

    // incrementing flag
    private void flagTriggered() {
        userFlag++;
    }

}
