public class SubtractStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }

    @Override
    public String getName() {
        return "Subtraction";
    }
}
