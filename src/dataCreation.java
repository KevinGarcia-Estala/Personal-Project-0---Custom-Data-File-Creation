import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class dataCreation implements Interface {
    private int userFlag = 0;
    private int numberFlag = -999;
    private int formatFlag = -999;
    private Scanner console;
    private Object temp;
    private long minimum;
    private long maximum;
    private int dataSize = 0;
    private Exception error;
    private Random randy = new Random();
    private String fileName;

    //used to take in the user's answers and decide on what data to put onto the file
    private void processing() {
        int numberFlagT = numberFlag;
        try {
            FileWriter writer = new FileWriter(fileName);

            while (dataSize > 0) {
                // choose a number/data
                if(numberFlagT == 4){
                    numberFlag = randy.nextInt((int) (3-1) +1) + 1;
                }
                switch (numberFlag) {
                    case 1:
                        basicNumbers();
                        break;
                    case 2:
                        decimalNumbers();
                        break;
                    case 3:
                        basicNumbers();
                        break;
                }
                write(temp, writer);
                dataSize--;
                if (dataSize != 0) {
                    format(writer);
                }
            }
            writer.close();
        } catch (IOException e) {
        }

    }

    //Used for positive and negatives
    @Override
    public Object basicNumbers() {
        long temp2 = randy.nextInt((int) ((maximum - minimum) + 1));
        temp = minimum + temp2;
        return temp;
    }

    //Used for decimal numbers
    @Override
    public Object decimalNumbers() {
        long temp2 = randy.nextInt((int) ((maximum - minimum) + 1));
        temp = minimum + temp2;
        double temp3 = randy.nextDouble();
        temp = (long) temp + temp3;
        return (temp);
    }

    //used for determining the format for the data
    @Override
    public void format(FileWriter writer) throws IOException {
        switch (formatFlag) {
            case 1:
                temp = " ";
                break;
            case 2:
                temp = "\n";
                break;
            case 3:
                temp = "\t";
            default:
                break;
        }
        writer.write((String) temp);

    }

    /*
     * @param temp is used as a case for both decimal and +/- numbers to be passed through
     * @param writer is the file writer that will write onto the file
     * used to write onto the newly created file
     */
    @Override
    public void write(Object temp, FileWriter writer) {
        try {
            if (numberFlag == 1 || numberFlag == 3) {
                writer.write(Long.toString((long) temp));
            } else {
                writer.write(Double.toString((double) temp));
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Something went wrong please try again");
            System.exit(0);
        }
    }

    @Override
    public void userInput() {
        switch (userFlag) {
            // creating a new file and naming
            case 0:
                do {
                    System.out.print("Please enter the name of you're data file: ");
                    console = new Scanner(System.in);
                    fileName = console.nextLine() + ".txt";
                    File newFile = new File(fileName);

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
                System.out.print("(1) space \n(2) enter \n(3) tab \n");
                do {

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

            // asks the user if they want a specific range of numbers or not
            case 4:
                do {
                    do {
                        System.out.print("Would you like the data to be a certain range of numbers? (y/n): ");
                        console = new Scanner(System.in);
                        temp = console.nextLine();
                    } while ((!(temp.equals("y"))) && (!(temp.equals("n"))));
                    if (temp.equals("y")) {
                        rangeAdded();
                        flagTriggered();
                    } else {
                        if (numberFlag >= 2) {
                            minimum = -999999999;
                            maximum = 999999999;
                        } else {
                            minimum = 0;
                            maximum = 999999999;
                        }
                        flagTriggered();
                    }
                } while (userFlag == 4);
                System.out.println("Please wait while data is being created");
                processing();
                break;
            // restarts the program
            default:
                userFlag = 0;
                break;
        }
    }

    // incrementing flag
    private void flagTriggered() {
        userFlag++;
    }

    // used for determining the range of numbers for the random numbers
    private void rangeAdded() {
        boolean minFlag = true;
        boolean maxFlag = true;
        boolean mainRFlag = true;
        do {
            // check to see if the input for the minimum value is a valid input
            do {
                System.out.print("What will be the minimum value for the range? : ");
                console = new Scanner(System.in);
                try {
                    minimum = console.nextInt();
                    // checking to see if the user minimum range is valid for the data type
                    if ((minimum < 0 && (!(numberFlag >= 3))) || (minimum >= 0 && (numberFlag >= 3))) {
                        throw error;
                    }
                    minFlag = false;
                } catch (Exception e) {
                    System.out.println("Invalid minimum value, please try again");
                }
            } while (minFlag);

            // check to see if the input for the maximum value is a valid input
            do {
                System.out.print("What will be the maximum value for the range? : ");
                console = new Scanner(System.in);
                try {
                    maximum = console.nextInt();
                    maxFlag = false;
                } catch (Exception e) {
                    System.out.println("Invalid maximum value, please try again");
                }
            } while (maxFlag);

            // check if the correct ranges was decided
            if (maximum < minimum) {
                System.out.println("Invalid range values value, please try again");
                minFlag = true;
                maxFlag = true;
            } else {
                mainRFlag = false;
            }

        } while (mainRFlag);
    }

    // will be used to restart the program
    public boolean restartProgram(boolean run) {
        console = new Scanner(System.in);
        do {
            System.out.print("Would you like to create a new file? (y/n): ");
            temp = console.next();
        } while ((!(temp.equals("y"))) && (!(temp.equals("n"))));
        // clear out the terminal
        if (temp.equals("y")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            userInput();
            return true;
        } else {
            System.out.println("Thank you for using this program, good bye!");
            return false;
        }
    }

}
