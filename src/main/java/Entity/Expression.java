package main.java.Entity;

import java.util.ArrayList;

/**
 * Formats user input into an expression (dont forget to add whitespace before and after an operation)
 */
public class Expression {
    private final String input;

    /**
     * Constructor for expression
     * @param input
     */
    public Expression(String input) {
        this.input = input;
    }


    /**
     * formats the input in a list for operations to work with
     * @param input a string expression provided by the calculator user
     * @return a list containing the formatted expression
     */
    public ArrayList<String> reformat(String input){
        String formattedInput = preprocessInput(input);
        String[] splitted = formattedInput.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (String element : splitted){
            result.add(element);
        }
        return result;
        }

    /**
     * Preprocesses the input to ensure spaces around operators for consistent splitting.
     *
     * @param input The raw user input.
     * @return The preprocessed input with spaces around operators.
     */
    private String preprocessInput(String input) {
        return input.replaceAll("([+\\-*/()])", " $1 ");
    }

    /**
     * Validates the input for invalid characters or empty input.
     *
     * @throws IllegalArgumentException If the input contains invalid characters or is empty.
     */
    public boolean validateInput() {
        if (input.isEmpty()) {
            return false;
        }
        if (!input.matches("[0-9+\\-*/(). ]+")) {
            throw new IllegalArgumentException("Input contains invalid characters.");
            return false;
        }
        ArrayList<String> processedExpression = reformat(input);
        int lastElementIndex = processedExpression.size() - 1;
        if (processedExpression.get(lastElementIndex).equals("+")
                || processedExpression.get(lastElementIndex).equals("-")
                || processedExpression.get(lastElementIndex).equals("*")
                || processedExpression.get(lastElementIndex).equals("/")) {
            throw new IllegalArgumentException("Input ends with invalid characters.");
            return false;
        }
        return true;
    }

}
