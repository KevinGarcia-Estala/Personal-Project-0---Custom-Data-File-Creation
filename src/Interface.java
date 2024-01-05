import java.io.FileWriter;
import java.io.IOException;

public interface Interface {
    // will be used for whole positive and negative numbers
    Object basicNumbers();

    // will be used for decimal numbers
    Object decimalNumbers();

    // will be used for deciding what format will be used
    void format(FileWriter writer) throws IOException;
    /*
     * will write on to the data file
     * 
     * @param data will be used to pass the numbers
     * 
     */

    void write(Object data, FileWriter writer);

    // will take in the user input for certain questions
    void userInput();
}
