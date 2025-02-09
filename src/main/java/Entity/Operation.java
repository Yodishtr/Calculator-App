package Entity;

/**
 * An interface for operations to be performed by the calculator
 */
public interface Operation {

    /**
     * Performs the operation based on the available expression
     * @param num2, num1
     * @return a number object which is the result of performing the operations expression
     */
    public Numbers execute(Numbers num1, Numbers num2);
}
