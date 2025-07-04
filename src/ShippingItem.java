public class ShippingItem {
    private String itemName;
    private int quantity;
    private double itemWeight;
    private double price;

    public ShippingItem(String itemName, double itemWeight, int quantity, double price) {
        this.itemWeight = itemWeight;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int GetQuantity() {
        return  quantity;
    }

    public double GetPrice() {
        return  price;
    }
    public String GetName() {
        return itemName;
    }


    public double GetWeight() {
        return itemWeight;
    }
}
