public class CalculatorContext {
    private Strategy strategy;

    public CalculatorContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy must be set before execution.");
        }
        return strategy.execute(a, b);
    }

    public String getStrategyName() {
        return strategy == null ? "No strategy" : strategy.getName();
    }
}
