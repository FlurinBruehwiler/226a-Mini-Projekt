package main.java;

public class InvalidInputException extends Exception{
    /**
     * Description: An exception for the cases, that the user inputs a wrong number;
     * @param from
     * @param to
     */
    public InvalidInputException(int from, int to){
        super("The input must be between " + from + " and " + to);
    }
}
