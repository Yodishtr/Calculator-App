package main.java.Use_Cases.ComplexInteractor;

import main.java.Entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Complex Expression calculation use case
 */
public class ComplexInteractor implements ComplexInputBoundary {
    private final ComplexDataAccessInterface complexDataAccessInterface;
    private final ComplexOutputBoundary complexOutputBoundary;


    public ComplexInteractor(ComplexDataAccessInterface complexDataAccessInterface,
                             ComplexOutputBoundary complexOutputBoundary) {
        this.complexDataAccessInterface = complexDataAccessInterface;
        this.complexOutputBoundary = complexOutputBoundary;
    }

    @Override
    public void calculate(ComplexInputData complexInputData) {
        ArrayList<String> expression = inputDataProcessor(complexInputData);
        String calculationInput = complexInputData.getCalculation();
        if (expression.get(0) == "invalid input"){
            complexOutputBoundary.prepareFailView(expression.getFirst());
        }
        else {

            // division operation since it is highest precedence
            performDivision(expression);

            // multiplication operations since second highest precedence
            performMultiplication(expression);

            // addition operation since penultimate precedence
            performAddition(expression);

            // substraction operation since lowest precedence
            performSubstraction(expression);

            String calculationResult = expression.getFirst();
            BigDecimal numericalValue = new BigDecimal(calculationResult);
            final ComplexOutputData outputData = new ComplexOutputData(numericalValue,
                    calculationResult, calculationInput, false);
            complexOutputBoundary.prepareSuccessView(outputData);
        }
    }

    private ArrayList<String> inputDataProcessor(ComplexInputData complexInputData) {
        Expression calculation = new Expression(complexInputData.getCalculation());
        if (calculation.validateInput()) {
            ArrayList<String> toCalculate = calculation.reformat(complexInputData.getCalculation());
            return toCalculate;
        }
        else{
            String error = "invalid input";
            ArrayList<String> errorReturn = new ArrayList<>();
            errorReturn.add(error);
            return errorReturn;
        }
    }



    private void performDivision(ArrayList<String> expression) {
        if (expression.size() == 1) {
            return;
        }
        int i = 0;
        while (i < expression.size() - 1) {
            if (expression.get(i).equals("/")) {
                Numbers num1 = new Numbers(expression.get(i - 1));
                Numbers num2 = new Numbers(expression.get(i + 1));
                DivisionOperation division = new DivisionOperation();
                Numbers quotient = division.execute(num1, num2);
                expression.set(i - 1, quotient.toString());
                expression.remove(i + 1);
                expression.remove(i);
                i--;
            }
            else{
                i++;
            }
        }
    }

    private void performMultiplication(ArrayList<String> expression) {
        if (expression.size() == 1) {
            return;
        }
        int i = 0;
        while (i < expression.size() - 1){
            if (expression.get(i).equals("*")){
                Numbers num1 = new Numbers(expression.get(i - 1));
                Numbers num2 = new Numbers(expression.get(i + 1));
                MultiplicationOperation multiplication = new MultiplicationOperation();
                Numbers product = multiplication.execute(num1, num2);
                expression.set(i - 1, product.toString());
                expression.remove(i + 1);
                expression.remove(i);
                i--;
            }
            else{
                i++;
            }
        }

    }

    private void performAddition(ArrayList<String> expression) {
        if (expression.size() == 1) {
            return;
        }
        int i = 0;
        while (i < expression.size() - 1){
            if (expression.get(i).equals("+")){
                Numbers num1 = new Numbers(expression.get(i - 1));
                Numbers num2 = new Numbers(expression.get(i + 1));
                AdditionOperation addition = new AdditionOperation();
                Numbers sum = addition.execute(num1, num2);
                expression.set(i - 1, sum.toString());
                expression.remove(i + 1);
                expression.remove(i);
                i--;
            }
            else{
                i++;
            }
        }
    }

    private void performSubstraction(ArrayList<String> expression) {
        if (expression.size() == 1) {
            return;
        }
        int i = 0;
        while (i < expression.size() - 1){
            if (expression.get(i).equals("-")){
                Numbers num1 = new Numbers(expression.get(i - 1));
                Numbers num2 = new Numbers(expression.get(i + 1));
                SubstractionOperation substraction = new SubstractionOperation();
                Numbers sum = substraction.execute(num1, num2);
                expression.set(i - 1, sum.toString());
                expression.remove(i + 1);
                expression.remove(i);
                i--;
            }
            else{
                i++;
            }
        }
    }
}
