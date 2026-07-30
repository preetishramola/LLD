public class Main {
    public static void main(String[] args) {
        CalculatorContext calculator = new CalculatorContext(new AddStrategy());

        int a = 10;
        int b = 5;

        System.out.printf("Strategy: %s, %d and %d => %d\n",
                calculator.getStrategyName(), a, b, calculator.executeStrategy(a, b));

        calculator.setStrategy(new SubtractStrategy());
        System.out.printf("Strategy: %s, %d and %d => %d\n",
                calculator.getStrategyName(), a, b, calculator.executeStrategy(a, b));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.printf("Strategy: %s, %d and %d => %d\n",
                calculator.getStrategyName(), a, b, calculator.executeStrategy(a, b));
    }
}
