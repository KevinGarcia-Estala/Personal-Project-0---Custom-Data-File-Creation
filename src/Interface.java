public interface Interface {
    // will be used for whole positive and negative numbers
    long basicNumbers();
    // will be used for decimal numbers
    double decimalNumbers();
    // will be used for deciding what format will be used
    void format();
    // will write on to the data file
    void write();
    // will take in the user input for certain questions
    void userInput();
}
