package designpatterns.composite.calculator;

public class ArithmeticExpression implements Expression {
    private final Expression leftArithmeticExpression;
    private final Expression rightArithmeticExpression;
    private final Operator operator;

    public ArithmeticExpression(Expression leftArithmeticExpression,
                                Expression rightArithmeticExpression,
                                Operator operator) {
        this.leftArithmeticExpression = leftArithmeticExpression;
        this.rightArithmeticExpression = rightArithmeticExpression;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        switch (operator) {
            case ADD:
                return leftArithmeticExpression.evaluate() + rightArithmeticExpression.evaluate();
            case SUBTRACT:
                return leftArithmeticExpression.evaluate() - rightArithmeticExpression.evaluate();
            case MULTIPLY:
                return leftArithmeticExpression.evaluate() * rightArithmeticExpression.evaluate();
            case DIVIDE:
                return leftArithmeticExpression.evaluate() / rightArithmeticExpression.evaluate();
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
