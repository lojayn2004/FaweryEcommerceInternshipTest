public class NormalShippableStrategy implements IShippingStrategy{
    private double itemWeight;

    public NormalShippableStrategy(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    @Override
    public double GetShippingWeight() {
        return itemWeight;
    }
}
