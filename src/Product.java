public class Product  {
    private String ProductName;
    private double ProductPrice;
    private int ProductQuantity;

    private IShippingStrategy shippingStrategy;
    private IExpiryStrategy expiryStrategy;

    public Product(String ProductName,
                   double ProductPrice,
                   int ProductQuantity,
                   IShippingStrategy shippingStrategy,
                   IExpiryStrategy expiryStrategy) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity =  ProductQuantity;
        this.shippingStrategy = shippingStrategy;
        this.expiryStrategy = expiryStrategy;
    }

    public int GetAvaliableQuantity() {
        return ProductQuantity;
    }


    public void DecreaseProductQuantity(int quantity) throws Exception {
            if(quantity > ProductQuantity) {
                throw new Exception("Insuffienct Product quantity");
            }
            ProductQuantity -= quantity;
    }


    public String getProductName() {
        return ProductName;
    }
    public double getProductPrice() {
        return ProductPrice;
    }

    public void setShippingStrategy(IShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void setExpiryStrategy(IExpiryStrategy expiryStrategy) {
        this.expiryStrategy = expiryStrategy;
    }

    public boolean IsExpired() {
        return expiryStrategy.IsExpired();
    }

    public IShippingStrategy GetShippingStrategy() {
        return shippingStrategy;
    }

    public double GetWeight() {
        return shippingStrategy.GetShippingWeight();
    }

}
