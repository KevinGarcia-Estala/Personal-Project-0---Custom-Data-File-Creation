import java.util.Scanner;

public class dataCreation implements Interface {
    private String dataFileName;
    private int dataSize = 0;
    private int flag = 0;
    private Scanner console;

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
            // for the name of the file
            case 0:
                System.out.print("Please enter the name of the data that is going to be created: ");
                console = new Scanner(System.in);
                dataFileName = console.nextLine();
                break;
            // for the data size of the file
            case 1:
                do {
                    try {
                        System.out.print("Please enter the amount of data you require: ");
                        console = new Scanner(System.in);
                        dataSize = console.nextInt();
                        if(dataSize <= 0){
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input please try again");
                        dataSize = 0;
                    }
                } while (dataSize <= 1);
                break;
            default:
                console.close();
        }

    }

    // retrive the file name
    public String getDataFileName() {
        return dataFileName;
    }

    // retrives the flag value
    public int getFlag() {
        return flag;
    }

    // retrives the data size
    public int getDataSize() {
        return dataSize;
    }

    // update the flag if passed
    public void flagTriggered() {
        flag = +1;
    }

}
