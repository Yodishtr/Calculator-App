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
        String[] splitted = input.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (String element : splitted){
            result.add(element);
        }
        return result;
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
            return false;

        }
        ArrayList<String> processedExpression = reformat(input);
        int lastElementIndex = processedExpression.size() - 1;
        if (processedExpression.get(lastElementIndex).equals("+")
                || processedExpression.get(lastElementIndex).equals("-")
                || processedExpression.get(lastElementIndex).equals("*")
                || processedExpression.get(lastElementIndex).equals("/")) {


            return false;
        }
        return true;
    }

}
