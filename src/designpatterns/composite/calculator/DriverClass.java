package designpatterns.composite.calculator;

public class DriverClass {
    public static void main(String[] args) {

        //2*(1+7)
       /*

                         *
                       /   \
                     2      +
                           / \
                          1   7

        */

        Expression two = new Number(2);

        Expression one = new Number(1);
        Expression seven = new Number(7);

        ArithmeticExpression addExpression = new ArithmeticExpression(one, seven, Operator.ADD);

        ArithmeticExpression parentExpression = new ArithmeticExpression(two, addExpression, Operator.MULTIPLY);

        System.out.println(parentExpression.evaluate());


    }

}
