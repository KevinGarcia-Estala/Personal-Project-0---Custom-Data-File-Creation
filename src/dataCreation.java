import java.util.Scanner;

public class dataCreation implements Interface {
    private String dataFileName;
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
            case 0:
                System.out.print("Please enter the name of the data that is going to be created: ");
                console = new Scanner(System.in);
                dataFileName = console.nextLine();
                break;

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

    // update the flag if passed
    public void flagTriggered() {
        flag = +1;
    }

}
